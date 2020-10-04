package com.example.smarttravel;

import android.util.Log;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private CovidApi covidApi;

    public NetworkManager() {
        Gson gson = new Gson();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.covid19api.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         covidApi = retrofit.create(CovidApi.class);
    }

    public void getCovidData(Callback<World> callback) {
        Call<World> summary = covidApi.summary();
        summary.enqueue(callback);
    }
}
