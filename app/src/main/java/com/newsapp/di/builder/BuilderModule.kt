package com.newsapp.di.builder

import com.newsapp.ui.news.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {
    @ContributesAndroidInjector
    abstract fun bindHomeActivity(): MainActivity
}