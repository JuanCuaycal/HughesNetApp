package com.hughesnet.hughesnetapp.api;

import com.hughesnet.hughesnetapp.model.Advisor;
import com.hughesnet.hughesnetapp.model.Asesor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiProfile {


    @GET
    Call<List<Advisor>> getAdvisor(@Url String url);

}
