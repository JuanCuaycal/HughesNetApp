package com.hughesnet.hughesnetapp.api;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface ApiInsertClient {
    @FormUrlEncoded
    @POST("/insertclient.php")
    public  void insertclient(
            @Field("id_advisor") String id_advisor,
            @Field("name") String name,
            @Field("surname") String surname,
            @Field("phone") String phone,
            @Field("province") String province,
            @Field("address") String address,
            @Field("observation") String observation,
            @Field("status") String status,
            Callback<Response> callback
    );


}
