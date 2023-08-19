package com.newsapp.ui.news.adapter

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.newsapp.R
import com.newsapp.data.local.NewsModelEntity
import com.newsapp.di.helper.ImageLoader
import com.newsapp.ui.news.NewsDetailsActivity

class NewsAdapter(val mContext:Context,val mImageLoader: ImageLoader) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var list:ArrayList<NewsModelEntity>

   init {
       list = ArrayList()
   }
    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img_bg = itemView.findViewById<ImageView>(R.id.img_bg)
        var txt_by_author = itemView.findViewById<TextView>(R.id.txt_by_author)
        var txt_des = itemView.findViewById<TextView>(R.id.txt_des)
        var txt_title = itemView.findViewById<TextView>(R.id.txt_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var root = LayoutInflater.from(mContext).inflate(R.layout.news_list_item,parent,false)
        return NewsViewHolder(root)
    }

    override fun getItemCount(): Int {
        if (list!=null && list.size>0){
       return list.size
        }else{
            return  0
        }
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
          if (list!=null && list.size>0){
              var data = list[position]
              if (!TextUtils.isEmpty(data.urlToImage)){
                  mImageLoader.loadIntoImage(holder.img_bg,data.urlToImage!!)
              }

              data.urlToImage?.let {
                  mImageLoader.loadIntoImage(holder.img_bg,it)
              }

              data.author?.let {
                  holder.txt_by_author.text = "by "+it
              }

              data.title?.let {
                  holder.txt_title.text = it
              }

             data.author?.let {
                 holder.txt_by_author.text = it
             }

              data.content?.let {
                  holder.txt_des.text = it
              }
              holder.itemView.setTag(position)
              holder.itemView.setOnClickListener(object :View.OnClickListener{
                  override fun onClick(v: View?) {
                      var pos = v!!.tag.toString().toInt()
                      var m = list[pos]
                      var intent = Intent(v.context,NewsDetailsActivity::class.java)
                      intent.putExtra("url",m.url)
                      v.context.startActivity(intent)
                  }

              })
          }
    }

    fun setData(list: ArrayList<NewsModelEntity>){
        this.list = list
        notifyDataSetChanged()
    }
}