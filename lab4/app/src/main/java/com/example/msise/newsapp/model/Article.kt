package com.example.msise.newsapp.model

import java.io.Serializable

data class Article(
        var title: String,
        var data: String,
        var body:String
): Serializable