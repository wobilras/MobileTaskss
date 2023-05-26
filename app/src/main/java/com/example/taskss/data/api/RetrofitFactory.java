package com.example.taskss.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {
    private static Retrofit retrofit = null;

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private RetrofitFactory() {
    } // class should not be initialized

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
