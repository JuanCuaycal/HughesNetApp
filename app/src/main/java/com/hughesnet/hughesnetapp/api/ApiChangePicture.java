package com.hughesnet.hughesnetapp.api;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface ApiChangePicture {


    @FormUrlEncoded
    @POST("/ImgArregloEnt.php")
    public void inseruser(
            @Field("a") String a,
            @Field("b") String b,
            Callback<Response> callback


    );
}
