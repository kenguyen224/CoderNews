package com.example.kenguyen.codernews.api;

import com.example.kenguyen.codernews.Model.SearchResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by KeNguyen on 22/10/2016.
 */

public interface ArticleApi {
    @GET("article_search.json")
    Call<SearchResult> search(@QueryMap(encoded = true) Map<String, String> options);
}
