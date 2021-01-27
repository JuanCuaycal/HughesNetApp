package com.hughesnet.hughesnetapp.model;

import com.google.gson.annotations.SerializedName;

public class News {


    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("fecha")
    private String fecha;

    @SerializedName("images")
    private String images;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
