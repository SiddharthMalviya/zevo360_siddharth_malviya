package com.newsapp.ui.news

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.newsapp.data.datamanger.DataManager
import com.newsapp.data.datamanger.IDataManager
import com.newsapp.data.local.NewsModelEntity
import com.newsapp.data.remote.model.NewsDataModel
import com.newsapp.data.remote.model.NewsResponse
import com.newsapp.ui.base.BaseViewModel
import com.newsapp.utils.NetworkUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import javax.inject.Inject

class NewsViewModel @Inject constructor(private val dataRepo: IDataManager): BaseViewModel() {


    val newLiveData: MutableLiveData<NewsResponse> = MutableLiveData()
    var latestNews:MutableLiveData<List<NewsModelEntity>> =MutableLiveData()
    var list:ArrayList<NewsModelEntity>
    init {
        list = ArrayList()
        list.clear()
    }


      fun loadTopHeadlines(context: Context){
        if (NetworkUtils(context).verifyAvailableNetwork()) {
            addDisposable(dataRepo.getArticlesList()  .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                    {
                        Log.d("test==>",it.status.toString())
                         if (it.status =="ok" && it.articles!=null && it.articles!!.size>0){
                             Log.d("articles==>",it.articles!!.size.toString())

                             saveNews(it.articles!!,context)
//                             newLiveData.postValue(it)
                         }

                    }  ,{
                        Log.d("test==>",it.message!!)
                    }
                ));
        }else{
            fetchNewsLatest(context);
            Toast.makeText(context,"please check internet connection",Toast.LENGTH_LONG).show()
        }
    }

     fun fetchNewsLatest(context: Context){
         var list =  dataRepo.getDbNews()

         latestNews.postValue(list)
         Log.d("fetchNewsLatest====>", list.size.toString())

    }

      fun saveNews(list: ArrayList<NewsDataModel>, context: Context){
        this.list.clear()
        for (i in 0..list.size-1){
            var d = list[i]
            var model = NewsModelEntity()
            d.author.let {
                model.author = it
            }
            d.source!!.id.let {
                model.id = it
            }
            model.name.let {
                model.name =it

            }
            d.content.let {
                model.content = it
            }
            d.title.let {
                model.title = it
            }
            d.description.let {
                model.description = it
            }

            d.publishedAt.let {
                model.publishedAt  = it
            }
            d.urlToImage.let {
                model.urlToImage = it
            }
            d.url.let {
                model.url = it
            }


           this.list.add(model)

        }

        dataRepo.saveNewsDetails(this.list)
          fetchNewsLatest(context)
    }
}