package com.example.amit.newsapp.webhose.webhoseclient;

import com.example.amit.newsapp.webhose.WebHoseApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebhoseClient {
    private static final String BASE_URL = "http://webhose.io/filterWebContent?token=e07bb1e4-bb1e-4387-a69e-e8510eea5f44&format=json&sort=crawled&q=site_type%3Anews%20";

    private static Retrofit mRetrofit = null;
    private static Retrofit getClient(){
        HttpLoggingInterceptor lHlinterceptor = new HttpLoggingInterceptor();
        lHlinterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient lOkHttp = new OkHttpClient()
                .newBuilder()
                .addInterceptor(lHlinterceptor)
                .build();

        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(lOkHttp)
                .baseUrl(BASE_URL)
                .build();

        return mRetrofit;
    }

    public static WebHoseApi getWebhose(){
        return getClient().create(WebHoseApi.class);
    }
}
