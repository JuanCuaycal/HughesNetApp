package com.hughesnet.hughesnetapp.api;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;


public interface ApiRegister {

    @FormUrlEncoded
    @POST("/register.php")
    public  void insertadvisor(

            @Field("nombre") String nombre,
            @Field("apellido") String apellido,
            @Field("dni") String dni,
            @Field("telefono") String telefono,
            @Field("correo") String correo,
            @Field("password") String password,
            @Field("type") String type,
            Callback<Response> callback
    );



}