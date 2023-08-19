package com.newsapp.ui.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.newsapp.R
import com.newsapp.data.local.NewsModelEntity
import com.newsapp.data.remote.model.NewsResponse
import com.newsapp.databinding.ActivityMainBinding
import com.newsapp.di.helper.ImageLoader
import com.newsapp.ui.news.adapter.NewsAdapter
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity(){

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    @Inject
    lateinit var mImageLoader: ImageLoader

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var mViewModel: NewsViewModel

    var adapter:NewsAdapter ? =null



    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        mViewModel = ViewModelProviders
            .of(this, factory)
            .get(NewsViewModel::class.java)
        with(mBinding){
            mainViewModel = mViewModel
            lifecycleOwner = this@MainActivity
        }

        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)


        adapter = NewsAdapter(this,mImageLoader)
        mBinding.recyclerView.adapter = adapter



        mViewModel.loadTopHeadlines(this)


        mViewModel.latestNews.observe(this,topHeadlinesResponse)

        mBinding.swiperefresh.setOnRefreshListener {
            mViewModel.loadTopHeadlines(this)

            mViewModel.latestNews.observe(this,topHeadlinesResponse)
        }



    }

   var  topHeadlinesResponse = Observer<List<NewsModelEntity>> {
       if (it!=null && it.size>0)
       {
           adapter!!.setData(it as ArrayList<NewsModelEntity>)

           mBinding.swiperefresh.isRefreshing =false
       }
   }
}