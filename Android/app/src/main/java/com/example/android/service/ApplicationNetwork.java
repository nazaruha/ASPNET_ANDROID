package com.example.android.service;

import com.example.android.network.CategorriesApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApplicationNetwork { // service which will be sending requests to web (сервіс який буде посилати запити по мережі)
    private static ApplicationNetwork instance; // reference to itself (посилання на себе)

    private Retrofit retrofit; // to make api requests

    public ApplicationNetwork() {
        retrofit = new Retrofit.Builder()
            .baseUrl("https://pipi.itstep.click") // url for connecting
            .addConverterFactory(GsonConverterFactory.create()) // to convert into json
            .build(); // to complicate it
    }

    public static ApplicationNetwork getInstance() { // to init instance (if it's not) and return it
        if (instance == null) {
            instance = new ApplicationNetwork();
        }
        return instance;
    }

    public CategorriesApi getCategoriesApi() {
        return retrofit.create(CategorriesApi.class);
    }
}
