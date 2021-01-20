package com.hughesnet.hughesnetapp.api;

import com.hughesnet.hughesnetapp.model.DatosX;
import com.hughesnet.hughesnetapp.model.ReferidosCount;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiReferidosCount {
    @GET
    Call<List<ReferidosCount>> getResultCount(@Url String url);
}
