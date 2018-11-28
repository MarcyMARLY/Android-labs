package com.example.msise.lab5sampleapp

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.msise.lab5sampleapp.adapter.NewsAdapter
import com.example.msise.lab5sampleapp.model.ArticleData
import kotlinx.android.synthetic.main.activity_main.activity_main_fab
import kotlinx.android.synthetic.main.activity_main.activity_news_rv
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

private const val TITLE = "title"
private const val DATA = "data"

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var flButton: FloatingActionButton
    private var newsList: MutableList<ArticleData>? = ArrayList()
    private var newsAdapter: NewsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = ApiClient().getClient()
        val apiPoint = client.create(APIHandler::class.java)
        var data: List<ArticleData>? = null

        val call = apiPoint.getPosts()

        call.enqueue(object : Callback<List<ArticleData>> {
            override fun onResponse(call: Call<List<ArticleData>>?, response: Response<List<ArticleData>>?) {
                data = response?.body()
                initView(data)
            }

            override fun onFailure(call: Call<List<ArticleData>>?, t: Throwable?) {
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data == null) return
        var title: String = data.getStringExtra(TITLE)
        var data: String = data.getStringExtra(DATA)
        val article = ArticleData(Random().nextLong(), Random().nextLong(), title, data)
        val call = ApiClient()
                .getClient()
                .create(APIHandler::class.java)
                .post(article)

        call.enqueue(object : Callback<ArticleData> {

            override fun onResponse(call: Call<ArticleData>?, response: Response<ArticleData>?) {
                val post = response?.body()
            }

            override fun onFailure(call: Call<ArticleData>?, t: Throwable?) {
            }

        })
        newsList?.add(article)
        newsAdapter?.notifyDataSetChanged()
    }

    private fun initView(data: List<ArticleData>?) {
        recyclerView = activity_news_rv
        newsList = data as MutableList<ArticleData>?
        newsList?.let {
            newsAdapter = NewsAdapter(newsList!!)
        }
        val linearLayoutManager = LinearLayoutManager(applicationContext)

        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.layoutManager = linearLayoutManager
        } else {
            recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
        }
        recyclerView.adapter = newsAdapter

        flButton = activity_main_fab
        flButton.setOnClickListener {
            val intent: Intent = Intent(this, NewsFormActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }
}
