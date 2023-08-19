package com.newsapp.data.local

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsDbRepo(newsDatabase: AppDatabase) {

    private var newDAO: NewsDao = newsDatabase.newsDao

    fun insertNews(news:ArrayList<NewsModelEntity>){
        CoroutineScope(Dispatchers.IO).launch {
            newDAO.insertNews(news)
        }
    }

    fun getNewsHeadLines():List<NewsModelEntity>{
        return newDAO.fetchNews()
    }

}