package com.newsapp.di.module

import com.newsapp.data.local.AppDatabase
import com.newsapp.data.local.NewsDbRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppDbModule {

    @Singleton
    @Provides
    fun providesNewsRepository(newsDatabase: AppDatabase): NewsDbRepo {
        return NewsDbRepo(newsDatabase)
    }
}