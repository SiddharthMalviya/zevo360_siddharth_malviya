package com.newsapp.data.remote.model

import com.google.gson.annotations.SerializedName

class NewsResponse {

    @SerializedName("status")
    var status:String? =null

    @SerializedName("totalResults")
    var totalResults:Int =0

    @SerializedName("articles")
    var articles:ArrayList<NewsDataModel>? =null


}