package com.example.smarttravel;

import com.google.gson.annotations.SerializedName;

public class Global {

    @SerializedName("NewConfirmed")
    private int newCases;

    public int getNewCases() {
        return newCases;
    }
}