package com.example.msise.newsapp

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.msise.newsapp.adapter.NewsAdapter
import com.example.msise.newsapp.model.ArticleData
import java.util.*

private const val TITLE = "title"
private const val DATA = "data"

class MainActivity : AppCompatActivity() {

    private var mDb: ArticleDatabase? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var flButton: FloatingActionButton
    private var newsList: MutableList<ArticleData>? = ArrayList()
    private var newsAdapter: NewsAdapter? = null
    private lateinit var mDbWorkerThread: DbWorkerThread
    private val mUiHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mDbWorkerThread = DbWorkerThread("dbWorkerThread")
        mDbWorkerThread.start()
        mDb = ArticleDatabase.getInstance(this)

        fillList()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (data == null) return
        var title: String = data.getStringExtra(TITLE)
        var data: String = data.getStringExtra(DATA)
        val article = ArticleData(Random().nextLong(), title, data)
        insertWeatherDataInDb(article)
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

    private fun fetchWeatherDataFromDb() {
        val task = Runnable {
            val articleData =
                    mDb?.articleDataDao()?.getAll()
            mUiHandler.post({
                if (articleData == null || articleData?.size == 0) {

                    return@post
                } else {
                    newsList = articleData as MutableList<ArticleData>?
                    initView()
                }
            })
        }
        mDbWorkerThread.postTask(task)
    }

    private fun insertWeatherDataInDb(articleData: ArticleData) {
        val task = Runnable { mDb?.articleDataDao()?.insert(articleData) }
        mDbWorkerThread.postTask(task)
    }

    private fun fillList() {
        val testArticleData = ArticleData(100, "Title", "Hohoho")
        insertWeatherDataInDb(testArticleData)
        fetchWeatherDataFromDb()
    }
}
