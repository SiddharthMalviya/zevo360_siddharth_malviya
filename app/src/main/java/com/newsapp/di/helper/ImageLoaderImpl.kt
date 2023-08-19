package com.newsapp.di.helper

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ImageLoaderImpl @Inject constructor(private val context: Context) :ImageLoader {

    override fun loadIntoImage(imageView: ImageView, url: String) {
       Picasso.get().load(url).into(imageView)
    }


}