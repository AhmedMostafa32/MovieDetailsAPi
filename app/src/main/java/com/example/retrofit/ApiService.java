package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("975df089-360c-423b-b830-e51b67da8ef2")
    Call<List<Movie>> getMovies();
}