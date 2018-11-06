package com.example.msise.lab5sampleapp

import com.example.msise.lab5sampleapp.model.ArticleData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkController: Callback<List<ArticleData>> {
    override fun onFailure(call: Call<List<ArticleData>>?, t: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResponse(call: Call<List<ArticleData>>?, response: Response<List<ArticleData>>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}