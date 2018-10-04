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
import com.example.msise.tabapp.adapters.CategoryAdapter
import com.example.msise.tabapp.models.Category
import kotlinx.android.synthetic.main.fragment_category.fragment_category_rv

class CategoryFragment: Fragment() {
    private var recView: RecyclerView? = null
        private var categoryList: MutableList<Category>? = ArrayList()
    private var categoryAdapter: CategoryAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recView = fragment_category_rv

        fillList()
        if (categoryList != null) {
            categoryAdapter = CategoryAdapter(categoryList!!)
        }
        val linearLayoutManager = LinearLayoutManager(context)

        if (context!!.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recView!!.layoutManager = linearLayoutManager
        } else {
            recView!!.layoutManager = GridLayoutManager(context, 2)
        }
        recView!!.adapter = categoryAdapter
    }

    private fun fillList() {
        val item: Category = Category("Sport")
        val anotherItem: Category = Category("Music")
        categoryList!!.add(item)
        categoryList!!.add(anotherItem)
        categoryList!!.add(item)
        categoryList!!.add(anotherItem)
        categoryList!!.add(item)
        categoryList!!.add(anotherItem)
    }
}