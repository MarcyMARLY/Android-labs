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
        fillList()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data == null) return
        var title: String = data.getStringExtra(TITLE)
        var data: String = data.getStringExtra(DATA)
        val article = ArticleData(Random().nextLong(), title, data)
        newsList!!.add(article)
        newsAdapter!!.notifyDataSetChanged()
    }

    private fun initView() {
        recyclerView = findViewById(R.id.activity_news_rv)
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

        flButton = findViewById(R.id.activity_main_fab)
        flButton.setOnClickListener {
            val intent: Intent = Intent(this, NewsFormActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    private fun fillList() {
        val testArticleData = ArticleData(100, "Title", "Hohoho")
    }
}
