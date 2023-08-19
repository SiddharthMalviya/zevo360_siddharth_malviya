package com.newsapp.di.module

import android.app.Application
import android.content.Context
import com.newsapp.data.datamanger.DataManager
import com.newsapp.data.datamanger.IDataManager
import com.newsapp.di.helper.ImageLoader
import com.newsapp.di.helper.ImageLoaderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideRepo(dataRepoImpl: DataManager): IDataManager {
        return dataRepoImpl
    }

    @Provides
    @Singleton
    fun provideImageLoader(imageLoader: ImageLoaderImpl): ImageLoader {
        return imageLoader
    }
}