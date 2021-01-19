package com.hughesnet.hughesnetapp.api;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface ApiChangePicture {


    @FormUrlEncoded
    @POST("/Upload.php")
    public void Uploadphoto(
            @Field("imagen") String imagen,
            @Field("nombre") String nombre,

            Callback<Response> callback


    );

}
