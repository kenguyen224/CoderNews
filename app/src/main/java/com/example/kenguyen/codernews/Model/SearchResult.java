package com.example.kenguyen.codernews.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by KeNguyen on 22/10/2016.
 */

public class SearchResult {
    @SerializedName("docs")
    private List<Article> article;

    public List<Article>getArticle(){return article;}
}
