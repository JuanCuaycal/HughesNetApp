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

            @Field("telefono") String telefono,
            @Field("nombre") String nombre,
            @Field("apellido") String apellido,
            @Field("correo") String correo,
            @Field("dni") String dni,
            @Field("password") String password,
            Callback<Response> callback
    );



}