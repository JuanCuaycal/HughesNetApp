package com.hughesnet.hughesnetapp.model;

import com.google.gson.annotations.SerializedName;

public class Asesor {

    @SerializedName("name")
    private String name;

    @SerializedName("surname")
    private String surname;

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

    @SerializedName("phone")
    private String phone;


}
