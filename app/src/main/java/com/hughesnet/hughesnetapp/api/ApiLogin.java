package com.hughesnet.hughesnetapp.api;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface ApiLogin {

    @FormUrlEncoded
    @POST("/login.php")
    public  void loggear(

            @Field("correo") String correo,
            @Field("password") String password,

            Callback<Response> callback

    );

}
