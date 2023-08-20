package com.newsapp.data.datamanger

import androidx.lifecycle.LiveData
import com.newsapp.data.local.NewsDbRepo
import com.newsapp.data.local.NewsModelEntity
import com.newsapp.data.remote.NewsApiHelper
import com.newsapp.data.remote.model.NewsDataModel
import com.newsapp.data.remote.model.NewsResponse
import com.newsapp.utils.AppConstant
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DataManager @Inject
constructor(private val newsApiHelper: NewsApiHelper,private val dbNB:NewsDbRepo) : IDataManager {
    override fun getArticlesList(): Single<NewsResponse> {
     return newsApiHelper.fetchNewsHeadLines(AppConstant.top_headlines+AppConstant.API_KEY)
    }

    override fun saveNewsDetails(list: ArrayList<NewsModelEntity>) {
      dbNB.insertNews(list)
    }

    override fun getDbNews(): List<NewsModelEntity> {
       return dbNB.getNewsHeadLines()
    }


}