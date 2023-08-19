package com.newsapp.di.component

import com.newsapp.NewsApplication
import com.newsapp.di.builder.BuilderModule
import com.newsapp.di.module.AppDbModule
import com.newsapp.di.module.AppModule
import com.newsapp.di.module.NetworkModule
import com.newsapp.di.module.RoomDatabaseModule
import com.newsapp.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,RoomDatabaseModule::class, ViewModelModule::class, NetworkModule::class, BuilderModule::class,AppDbModule::class, AndroidInjectionModule::class, AndroidSupportInjectionModule::class])
interface AppComponent {
    fun inject(app: NewsApplication)
}