package com.newsapp.data.datamanger

import androidx.lifecycle.LiveData
import com.newsapp.data.local.NewsModelEntity
import com.newsapp.data.remote.model.NewsDataModel
import com.newsapp.data.remote.model.NewsResponse
import io.reactivex.Single

interface IDataManager  {

    fun getArticlesList():Single<NewsResponse>

    fun saveNewsDetails(list: ArrayList<NewsModelEntity>)

    fun getDbNews():List<NewsModelEntity>




}