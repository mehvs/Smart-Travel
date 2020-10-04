package com.example.smarttravel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class World {

    @SerializedName("Global")
    private Global globalCases;

    @SerializedName("Countries")
    private List<Country> countries;

    public Global getGlobalCases() {
        return globalCases;
    }

    public List<Country> getCountries() {
        return countries;
    }
}
