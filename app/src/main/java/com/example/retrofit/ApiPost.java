package com.example.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiPost {
    @POST("/api/users")
    Call<PostResponse> createPost(@Body PostData post);
}
