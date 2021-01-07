package com.hughesnet.hughesnetapp.model;

import com.google.gson.annotations.SerializedName;

public class Asesor {

    @SerializedName("username")
    private String username;

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("phone1")
    private String phone1;

    public String getUsername() { return username; }

    public String getFirstname() { return firstname; }

    public String getPhone1() { return phone1; }
}
