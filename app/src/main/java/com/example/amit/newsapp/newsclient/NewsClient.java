package com.example.amit.newsapp.newsclient;

import com.example.amit.newsapp.newsapi.NewsApi;

import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsClient {

    private static Retrofit mRetrofit = null;
    private static Retrofit getClient(){
        HttpLoggingInterceptor lHttp = new HttpLoggingInterceptor();
        lHttp.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient lClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(lHttp)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(NewsApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(lClient)
                .build();
        return mRetrofit;
    }

    public static NewsApi getNewsApi(){
        return getClient().create(NewsApi.class);
    }
    public static NewsApi getTheHinduNewsApi(){
        return getClient().create(NewsApi.class);
    }
}
