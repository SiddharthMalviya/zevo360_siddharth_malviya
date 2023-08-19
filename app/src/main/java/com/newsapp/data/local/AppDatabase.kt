package com.newsapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.newsapp.utils.Converters
import retrofit2.Converter

@Database(
    entities = [NewsModelEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){

    abstract val newsDao:NewsDao

//    companion object{
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//
//        fun getInstance(context: Context): AppDatabase {
//            synchronized(AppDatabase::class.java) {
//                var instance = INSTANCE
//
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        AppDatabase::class.java,
//                        "news_app_database"
//                    )   //Destroy the first version of the database as the data contained is no longer required.
//                        //The first version of the database contained a column for Room auto-generated primary key of type Long,
//                        //which has been removed from the second version of the database
//                        .fallbackToDestructiveMigrationFrom(1)
//                        .build()
//                }
//                INSTANCE = instance
//                return instance
//            }
//        }
//
//    }
}