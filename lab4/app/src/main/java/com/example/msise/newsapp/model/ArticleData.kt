package com.example.msise.newsapp.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "articleData")
data class ArticleData(
        @PrimaryKey(autoGenerate = true) var id: Long?,
        @ColumnInfo(name = "title") var title: String,
        @ColumnInfo(name = "data") var data: String,
        @ColumnInfo(name = "body") var body: String
) {
    constructor() : this(null, "", "", "")
}