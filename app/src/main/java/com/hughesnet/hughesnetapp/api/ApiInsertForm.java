package com.hughesnet.hughesnetapp.api;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface ApiInsertForm {
    @FormUrlEncoded
    @POST("/insertform.php")
    public  void insertform(
            @Field("id_asesor") String id_asesor,
            @Field("fecha_pedido") String fecha_pedido,
            @Field("p1") String p1,
            @Field("p2") String p2,
            @Field("p3") String p3,
            @Field("p4") String p4,
            @Field("p5") String p5,
            @Field("p6") String p6,
            @Field("p7") String p7,
            @Field("p8") String p8,
            @Field("p9") String p9,
            @Field("p10") String p10,
            @Field("p11") String p11,
            @Field("p12") String p12,
            @Field("p13") String p13,
            @Field("p14") String p14,
            @Field("p15") String p15,
            @Field("p16") String p16,
            @Field("p17") String p17,
            @Field("p18") String p18,
            @Field("p19") String p19,
            @Field("p20") String p20,
            @Field("p21") String p21,
            @Field("p22") String p22,
            @Field("p23") String p23,
            @Field("p24") String p24,
            @Field("p25") String p25,
            @Field("p26") String p26,
            @Field("p27") String p27,
            @Field("p28") String p28,
            @Field("p29") String p29,
            @Field("p30") String p30,
            Callback<Response> callback
    );



}
