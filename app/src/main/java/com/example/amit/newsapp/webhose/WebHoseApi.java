package com.example.amit.newsapp.webhose;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebHoseApi {
    @GET("filterWebContent")
    Call<WebhoseRoot> getWebHoseRoot();
}
