package com.example.msise.lab5sampleapp

import com.example.msise.lab5sampleapp.model.ArticleData
import retrofit2.Call
import retrofit2.http.GET

interface APIHandler {

    @GET("posts/")
    fun getPosts(): Call<List<ArticleData>>
}