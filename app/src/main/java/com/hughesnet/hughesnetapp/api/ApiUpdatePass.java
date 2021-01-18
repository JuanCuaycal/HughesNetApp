package com.hughesnet.hughesnetapp.api;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;


public interface ApiUpdatePass {

    @FormUrlEncoded
    @POST("/contrasena.php")
    public  void insertadvisor(

            @Field("contrasena") String contrasena,
            @Field("ncontrasena") String ncontrasena,
            @Field("dni") String dni,
            Callback<Response> callback
    );



}