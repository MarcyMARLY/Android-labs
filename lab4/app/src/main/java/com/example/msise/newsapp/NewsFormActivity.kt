package com.example.msise.newsapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TITLE = "title"
private const val DATA = "data"

class NewsFormActivity : AppCompatActivity() {

    private lateinit var title: EditText
    private lateinit var data: EditText
    private lateinit var sendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_form)
        initView()
        sendButton.setOnClickListener {
            if (title == null || data == null) {

                return@setOnClickListener
            }
            val intent: Intent = Intent()
            intent.putExtra(TITLE, title.text.toString())
            intent.putExtra(DATA, data.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    private fun initView() {
        title = findViewById(R.id.activity_et_title)
        data = findViewById(R.id.activity_et_date)
        sendButton = findViewById(R.id.activity_button_send)
    }
}
