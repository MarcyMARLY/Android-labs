package com.example.msise.lab5sampleapp.model

import com.google.gson.annotations.SerializedName

data class ArticleData(
        @SerializedName("userId") var userId: Long?,
        @SerializedName("id") var id: Long?,
        @SerializedName("title") var title: String,
        @SerializedName("body") var body: String
) {
    constructor() : this(null, null, "", "")
}