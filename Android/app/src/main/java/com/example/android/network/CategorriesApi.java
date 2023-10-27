package com.example.android.network;

import com.example.android.dto.category.CategoryItemDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategorriesApi {
    @GET("/api/categories/list")
    public Call<List<CategoryItemDTO>> list();
}
