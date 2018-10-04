package com.example.msise.tabapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.msise.tabapp.R.layout.toolbar
import com.example.msise.tabapp.models.Article
import kotlinx.android.synthetic.main.content_news_details.activity_details_body
import kotlinx.android.synthetic.main.content_news_details.activity_details_date
import kotlinx.android.synthetic.main.content_news_details.activity_details_title

import kotlinx.android.synthetic.main.activity_news_details.*

class NewsDetailsActivity : AppCompatActivity() {
    private val EXTRA_ARTICLE:String = "extra_article"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        val article = intent.extras.getSerializable(EXTRA_ARTICLE) as? Article

        activity_details_title.text = article!!.title
        activity_details_date.text = article!!.data
        activity_details_body.text = article!!.body
    }

}
