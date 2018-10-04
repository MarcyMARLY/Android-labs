package com.example.msise.tabapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.msise.tabapp.ArticleClickListener
import com.example.msise.tabapp.R
import com.example.msise.tabapp.models.Article



class RecentNewsAdapter(
        private val newsList: List<Article>,
        private val listener: ArticleClickListener? = null
):
        RecyclerView.Adapter<RecentNewsAdapter.NewsViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.row_article, parent, false)
        return NewsViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentArticle: Article = newsList[position]
        holder.title.text = currentArticle.title
        holder.date.text = currentArticle.data
    }

    class NewsViewHolder(itemView: View, listener: ArticleClickListener?) :
            RecyclerView.ViewHolder(itemView), View.OnClickListener
    {
        var title: TextView
        var date: TextView
        var mListener: ArticleClickListener? = null

        init {
            title = itemView.findViewById(R.id.row_article_title)
            date = itemView.findViewById(R.id.row_article_date)
            mListener = listener
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            if (view != null) {
                mListener!!.onClick(view, adapterPosition)
            }
        }
    }
}