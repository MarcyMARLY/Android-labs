package com.example.msise.newsapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.msise.newsapp.R
import com.example.msise.newsapp.model.ArticleData

class NewsAdapter(
        private val newsList: List<ArticleData>
): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_article, parent, false)

        return NewsViewHolder(itemView)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentPosition = newsList[position]

        holder.title.text = currentPosition.title
        holder.date.text = currentPosition.data
    }

    class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var date: TextView

        init {
            title = itemView.findViewById(R.id.row_article_title)
            date = itemView.findViewById(R.id.row_article_date)
        }
    }
}