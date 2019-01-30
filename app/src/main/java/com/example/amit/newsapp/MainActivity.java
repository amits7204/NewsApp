package com.example.amit.newsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.amit.newsapp.newsadapter.NewsAdapter;
import com.example.amit.newsapp.newsclient.NewsClient;
import com.example.amit.newsapp.pojoclassofnewsapi.Articles;
import com.example.amit.newsapp.pojoclassofnewsapi.NewsRoot;
import com.example.amit.newsapp.R;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public NewsAdapter mNewsAdapter;
    public List<Articles> mNewsArticles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        setContentView(R.layout.activity_main);
        final RecyclerView lNewsRecyclerView = findViewById(R.id.news_recyclerview);


        Call<NewsRoot> lNewsApi = NewsClient.getNewsApi().getNewsRoot("in");
        lNewsApi.enqueue(new Callback<NewsRoot>() {
            @Override
            public void onResponse(Call<NewsRoot> call, Response<NewsRoot> response) {
                if (response.isSuccessful()){
                    if (response.body() != null) {
                        mNewsArticles = response.body().getArticles();
                    }
                    mNewsAdapter = new NewsAdapter(mNewsArticles, getApplicationContext());
                    LinearLayoutManager lLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
                    lNewsRecyclerView.setLayoutManager(lLinearLayoutManager);
                    lNewsRecyclerView.setAdapter(mNewsAdapter);
                }
            }

            @Override
            public void onFailure(Call<NewsRoot> call, Throwable t) {
                Log.w("MainActivity", "Failed: "+t.getMessage());
            }
        });

    }
}
