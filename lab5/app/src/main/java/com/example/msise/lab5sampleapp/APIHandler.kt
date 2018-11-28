package com.example.msise.lab5sampleapp

import com.example.msise.lab5sampleapp.model.ArticleData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIHandler {

    @GET("posts/")
    fun getPosts(): Call<List<ArticleData>>

    @POST("posts/")
    fun post(@Body post: ArticleData): Call<ArticleData>
}
