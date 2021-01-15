package com.hughesnet.hughesnetapp.api;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface ApiUpdateStatus {

    @FormUrlEncoded
    @POST("/cambioEstado.php")
    public  void updateClient(


            @Field("telefono") String telefono,
           // @Field("dni") String dni,
            @Field("status") String status,
            Callback<Response> callback
    );
}
