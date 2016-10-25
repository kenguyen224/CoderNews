package com.example.kenguyen.codernews.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.kenguyen.codernews.Model.Article;
import com.example.kenguyen.codernews.Model.SearchRequest;
import com.example.kenguyen.codernews.Model.SearchResult;
import com.example.kenguyen.codernews.R;
import com.example.kenguyen.codernews.Utils.RetrofitUtils;
import com.example.kenguyen.codernews.api.ArticleApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Callback;
import retrofit2.Retrofit;
import static com.example.kenguyen.codernews.Utils.Constant.API_KEY;

public class SearchActivity extends AppCompatActivity {

    private SearchRequest mSearchRequest;
    private ArticleApi mArticleApi;
    @BindView(R.id.rvArticle)
    RecyclerView rvArticle;

    @BindView(R.id.pbLoading)
    RelativeLayout pbLoading;

    @BindView(R.id.pbLoadMore)
    ProgressBar pbLoadMore;


    private interface Listener{
        void onResult(SearchResult searchResult);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        setUpApi();
    }

    private void setUpApi(){
        mSearchRequest = new SearchRequest();
        mArticleApi = RetrofitUtils.get(API_KEY).create(ArticleApi.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent(this, SettingActivity.class);

        if (item.getItemId() == R.id.action_settings) {
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void fetchArticles (Listener listener){

    }

}
