package com.newsapp.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.newsapp.data.local.NewsModelEntity

class Converters {
    @TypeConverter
    fun listToJson(value: List<NewsModelEntity>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<NewsModelEntity>::class.java).toList()
}