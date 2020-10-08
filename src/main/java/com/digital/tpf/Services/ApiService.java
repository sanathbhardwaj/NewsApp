package com.digital.tpf.Services;

import com.digital.tpf.model.Headlines;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    String API_KEY = "6fbb6916d16141d3961d0889d71a01a8";

    String BASE_URL = "https://newsapi.org/";


    @Headers("X-Api-Key:" + API_KEY)
    @GET("/v2/top-headlines")
    Call<Headlines> getHeadlines(
            @Query("category") String category,
            @Query("country") String country
    );
}
