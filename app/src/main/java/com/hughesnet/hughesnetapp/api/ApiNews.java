package com.hughesnet.hughesnetapp.api;

import com.hughesnet.hughesnetapp.model.Advisor;
import com.hughesnet.hughesnetapp.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface ApiNews {
//    @Headers("Content-Type:application/json; charset=UTF-8")
    @GET
    Call<List<News>> getNews(@Url String url);
}
