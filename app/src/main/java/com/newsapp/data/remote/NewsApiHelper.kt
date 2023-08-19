package com.newsapp.data.remote

import com.newsapp.data.remote.model.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApiHelper {

//    @GET("{fullUrl}")
    @GET("https://newsapi.org/v2/top-headlines?country=us&apiKey=eb5aa2ba73734ce69d0d5abd772da8c8")
    fun fetchNewsHeadLines():Single<NewsResponse>
}

