package com.hughesnet.hughesnetapp.api;

import com.hughesnet.hughesnetapp.model.Asesor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiAsesor {
    @GET
    Call<List<Asesor>> getAsesores(@Url String url);

}
