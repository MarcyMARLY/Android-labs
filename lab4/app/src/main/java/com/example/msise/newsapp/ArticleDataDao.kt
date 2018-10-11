package com.example.msise.newsapp

import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.example.msise.newsapp.model.ArticleData

interface ArticleDataDao {

    @Query("SELECT * from articleData")
    fun getAll(): List<ArticleData>

    @Insert(onConflict = REPLACE)
    fun insert(articleData: ArticleData)

    @Query("DELETE from articleData")
    fun deleteAll()
}