package com.example.amit.newsapp.newsapi;

import com.example.amit.newsapp.pojoclassofnewsapi.NewsRoot;
import com.example.amit.newsapp.pojoclassofnewsapi.thehindu.TheHinduRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    String BASE_URL = "https://newsapi.org/v2/";
    @GET("top-headlines?apiKey=52cca7e265f840bd874d0e7d3e91326b")
    Call<NewsRoot> getNewsRoot(@Query("Sources") String aSource);

    @GET("top-headlines?apiKey=52cca7e265f840bd874d0e7d3e91326b")
    Call<TheHinduRoot> getTheHinduNewsRoot(@Query("Sources") String aSource);

    @GET("everything?apiKey=52cca7e265f840bd874d0e7d3e91326b")
    Call<NewsRoot> getEverythingNews(@Query("domains") String aDomains,
                                    @Query("language") String aLanguage);

    @GET("everything?apiKey=52cca7e265f840bd874d0e7d3e91326b")
    Call<TheHinduRoot> getEverythingIndianNews(@Query("domains") String aDomains,
                                     @Query("language") String aLanguage);

}
