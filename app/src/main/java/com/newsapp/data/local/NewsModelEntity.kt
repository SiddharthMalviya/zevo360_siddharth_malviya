package com.newsapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "news_table" , indices = [Index(value = ["title"], unique = true)])
class NewsModelEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name= "ids")
    var ids:Int =0

    @ColumnInfo(name = "id")
    var id: String? =null

    @ColumnInfo(name = "name")
    var name:String? =null

    @ColumnInfo(name = "author")
    var author:String? =null

    @ColumnInfo(name = "title")
    var title:String? =null

    @ColumnInfo(name = "description")
    var description:String? =null

    @ColumnInfo(name = "url")
    var url:String ? =null

    @ColumnInfo(name = "urlToImage")
    var urlToImage:String? =null

    @ColumnInfo(name = "publishedAt")
    var publishedAt:String? =null

    @ColumnInfo(name = "content")
    var content:String?= null

    override fun toString(): String {
        return "NewsModelEntity(ids=$ids, id=$id, name=$name, author=$author, title=$title, description=$description, url=$url, urlToImage=$urlToImage, publishedAt=$publishedAt, content=$content)"
    }


}