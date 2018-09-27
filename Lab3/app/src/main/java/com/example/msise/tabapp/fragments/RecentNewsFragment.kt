package com.example.msise.tabapp.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msise.tabapp.R
import com.example.msise.tabapp.adapters.RecentNewsAdapter
import com.example.msise.tabapp.models.Article
import kotlinx.android.synthetic.main.fragment_recent_news.fragment_recent_news_rv

class RecentNewsFragment : Fragment() {
    private var recView: RecyclerView? = null
    private var newsList: MutableList<Article>? = ArrayList()
    private var newsAdapter: RecentNewsAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_recent_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recView = fragment_recent_news_rv

        fillList()
        if (newsList != null) {
            newsAdapter = RecentNewsAdapter(newsList!!)
        }
        val linearLayoutManager = LinearLayoutManager(context)

        if (context!!.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recView!!.layoutManager = linearLayoutManager
        } else {
            recView!!.layoutManager = GridLayoutManager(context, 2)
        }
        recView!!.adapter = newsAdapter
    }
    private fun fillList() {
        val item: Article = Article("Facebook reports jump in profits", "05-11-2017", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
        val anotherItem: Article = Article("Google reports jump in profits", "09-11-2017", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.")
        newsList!!.add(item)
        newsList!!.add(anotherItem)
        newsList!!.add(item)
        newsList!!.add(anotherItem)
        newsList!!.add(item)
        newsList!!.add(anotherItem)
    }
}