package com.example.msise.newsapp

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.msise.newsapp.model.ArticleData

@Database(entities = arrayOf(ArticleData::class), version = 1)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun articleDataDao(): ArticleDataDao

    companion object {
        private var INSTANCE: ArticleDatabase? = null

        fun getInstance(context: Context): ArticleDatabase? {
            if (INSTANCE == null) {
                synchronized(ArticleDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            ArticleDatabase::class.java, "news.db")
                            .build()
                }
            }

            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}