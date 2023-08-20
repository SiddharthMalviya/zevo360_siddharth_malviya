package com.newsapp.data.remote

import com.newsapp.data.remote.model.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApiHelper {

//    @GET("{fullUrl}")
    @GET("{fullUrl}")
    fun fetchNewsHeadLines(@Path("fullUrl") fullUrl:String):Single<NewsResponse>
}

