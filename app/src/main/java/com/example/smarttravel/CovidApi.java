package com.example.smarttravel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CovidApi {

    @GET("/summary")
    Call<World> summary();
}
