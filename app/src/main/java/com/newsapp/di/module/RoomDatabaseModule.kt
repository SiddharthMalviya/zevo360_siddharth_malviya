package com.newsapp.di.module

import android.app.Application
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.newsapp.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomDatabaseModule(application: Application) {
    private var libraryApplication = application
    private lateinit var newsDatabase: AppDatabase


    @Singleton
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        newsDatabase = Room.databaseBuilder(libraryApplication, AppDatabase::class.java, "news_database")
            .allowMainThreadQueries()
            .build()
        return newsDatabase
    }


    private val databaseCallback = object : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Log.d("RoomDatabaseModule", "onCreate")


//            CoroutineScope(Dispatchers.IO).launch {
//                addSampleBooksToDatabase()
//            }
        }
    }

    @Singleton
    @Provides
    fun providesNewsDAO(newsDatabase: AppDatabase) = newsDatabase.newsDao

}