package com.example.msise.tabapp

import android.view.View

interface ArticleClickListener {
    fun onClick(view: View, position: Int)
}