package com.example.msise.tabapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.msise.tabapp.adapters.NewsTabsAdapter
import kotlinx.android.synthetic.main.activity_main.activity_main_tablayout
import kotlinx.android.synthetic.main.activity_main.activity_main_view_pager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabsAdapter = NewsTabsAdapter(supportFragmentManager)
        activity_main_view_pager.adapter = tabsAdapter

        activity_main_tablayout.setupWithViewPager(activity_main_view_pager)
    }
}
