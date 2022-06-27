package com.lucamesquitaa.testretrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpoint {
    @GET("posts")
    public Call<List<Posts>> getPosts();

}
