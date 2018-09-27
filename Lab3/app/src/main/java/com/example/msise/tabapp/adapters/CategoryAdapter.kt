package com.example.msise.tabapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.msise.tabapp.R
import com.example.msise.tabapp.models.Category

class CategoryAdapter(private val categoryList: List<Category>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =  LayoutInflater.from(parent.context)
                .inflate(R.layout.row_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentCategory: Category = categoryList[position]
        holder.title.text = currentCategory.title
    }

    class CategoryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var title: TextView

        init {
            title = itemView.findViewById(R.id.row_category_title)
        }
    }
}