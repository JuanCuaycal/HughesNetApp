package com.hughesnet.hughesnetapp.api;

import com.hughesnet.hughesnetapp.model.Asesor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiRegister {

    @FormUrlEncoded


    @POST("/postRegister.php")
    public  void registrovalido(

            @Field("z") String z;

    );



}