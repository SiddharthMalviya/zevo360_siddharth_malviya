package com.newsapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNews(newsList:ArrayList<NewsModelEntity>)

    @Query("SELECT * FROM news_table")
    fun fetchNews():List<NewsModelEntity>


}