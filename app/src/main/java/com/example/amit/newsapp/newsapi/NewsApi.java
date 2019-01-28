package com.example.amit.newsapp.newsapi;

import com.example.amit.newsapp.pojoclassofnewsapi.NewsRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("top-headlines?apiKey=52cca7e265f840bd874d0e7d3e91326b")
    Call<NewsRoot> getNewsRoot(@Query("Country") String aCountry);
}
