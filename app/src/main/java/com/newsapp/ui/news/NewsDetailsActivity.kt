package com.newsapp.ui.news

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.newsapp.R

class NewsDetailsActivity :AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_details_latout)


        var webviwe : WebView = findViewById(R.id.webviwe)
        webviwe.settings.setJavaScriptEnabled(true);
        webviwe.setWebViewClient(WebViewClient());
        if (intent.hasExtra("url")){
            webviwe.loadUrl(intent.getStringExtra("url").toString());
        }

    }
}