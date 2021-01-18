package com.hughesnet.hughesnetapp.api;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;


public interface ApiUpdate {

    @FormUrlEncoded
    @POST("/profileupdate.php")
    public  void insertadvisor(

            @Field("nombre") String nombre,
            @Field("apellido") String apellido,
            @Field("telefono") String telefono,
            @Field("correo") String correo,
            @Field("dni") String dni,
            Callback<Response> callback
    );



}