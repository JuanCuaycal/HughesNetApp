package com.hughesnet.hughesnetapp.model;

import com.google.gson.annotations.SerializedName;

public class Advisor {
    @SerializedName("dni")
    private String dni;

    @SerializedName("name")
    private String name;

    @SerializedName("surname")
    private String surname;

    @SerializedName("phone")
    private String phone;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("city")
    private String city;


    @SerializedName("description")
    private String description;

    @SerializedName("channel")
    private String channel;

    @SerializedName("type")
    private String type;

    @SerializedName("actitud")
    private String actitud;


    @SerializedName("aptitud")
    private String aptitud;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @SerializedName("imagen")
    private String imagen;

    public String getActitud() {
        return actitud;
    }

    public void setActitud(String actitud) {
        this.actitud = actitud;
    }

    public String getAptitud() {
        return aptitud;
    }

    public void setAptitud(String aptitud) {
        this.aptitud = aptitud;
    }


    public void setId_client(String id_client) {
        this.dni = id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
