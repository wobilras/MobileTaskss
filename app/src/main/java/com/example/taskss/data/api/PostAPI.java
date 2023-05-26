package com.example.taskss.data.api;

import com.example.taskss.data.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostAPI {

        @GET("posts/1")
        Call<Post> getFirstPost();

        @POST("posts")
        Call<Post> pushPost(@Body Post post);

        @GET("posts")
        Call<List<Post>> getAllPosts();

}
