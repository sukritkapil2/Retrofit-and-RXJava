package com.example.learnandroid.API;

import com.example.learnandroid.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpoints {
    @GET("/testdata")
    Call<List<Post>> getAllPosts();
}
