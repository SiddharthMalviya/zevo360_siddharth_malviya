package com.newsapp.di.helper

import android.widget.ImageView

interface ImageLoader {

    fun  loadIntoImage(imageView:ImageView,url:String)
}