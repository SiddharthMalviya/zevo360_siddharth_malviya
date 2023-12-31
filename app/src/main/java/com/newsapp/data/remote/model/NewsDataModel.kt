package com.newsapp.data.remote.model

import com.google.gson.annotations.SerializedName


class NewsDataModel {


    @SerializedName("source")
    var source:SourceData? =null

    @SerializedName("author")
    var author:String? =null

    @SerializedName("title")
    var title:String? =null

    @SerializedName("description")
    var description:String? =null

    @SerializedName("url")
    var url:String ? =null

    @SerializedName("urlToImage")
    var urlToImage:String? =null

    @SerializedName("publishedAt")
    var publishedAt:String? =null

    @SerializedName("content")
    var content:String?= null

}