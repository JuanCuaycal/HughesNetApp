package com.hughesnet.hughesnetapp.api;

import com.hughesnet.hughesnetapp.Datos;
import com.hughesnet.hughesnetapp.model.Advisor;
import com.hughesnet.hughesnetapp.model.DatosX;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiDatos {


    @GET
    Call<List<DatosX>> getAdvisor(@Url String url);

}
