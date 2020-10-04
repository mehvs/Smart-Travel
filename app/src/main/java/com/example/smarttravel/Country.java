package com.example.smarttravel;

import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("Country")
    private String country;

    @SerializedName("NewConfirmed")
    private int newCases;

    public String getCountry() {
        return country;
    }

    public int getNewCases() {
        return newCases;
    }
}