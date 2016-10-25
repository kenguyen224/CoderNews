package com.example.kenguyen.codernews.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.kenguyen.codernews.Model.Article;
import com.example.kenguyen.codernews.R;

public class ArticleActivity extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        toolbar = (Toolbar) findViewById(R.id.idToolBar);
        setSupportActionBar(toolbar);
        Article article = (Article) getIntent().getSerializableExtra("article");

        WebView webView = (WebView) findViewById(R.id.wvArticle);

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().getJavaScriptEnabled();
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl(article.getWebUrl());


    }


}
