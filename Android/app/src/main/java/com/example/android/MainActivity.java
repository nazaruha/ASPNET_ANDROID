package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    interface IRequestCategory {
        @GET("/api/categories/list")
        Call<List<Category>> GetCategories();
    }

    private ImageView ivMyImage;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMyImage = findViewById(R.id.ivMyImage);
    }

    public void OnGetImageHandleClick(View view) {
        url = "https://pipi.itstep.click/images/monika.jpg";
        //        String url = "http://10.0.2.2:5290/images/1.jpg";
        Glide // бібліотека, яка призначена для стягування фоток з інета для свого UI на Android
                .with(this)
                .load(url)
                .apply(new RequestOptions().override(600))
                .into(ivMyImage);


    }

    public void OnGetCategoriesHandleClick(View view) {
//        url = "https://pipi.itstep.click/api/categories/list";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pipi.itstep.click")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IRequestCategory requestCategory = retrofit.create(IRequestCategory.class);
        requestCategory.GetCategories().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
//                Log.d("my-tag", "Список категорій: " + response.body().toString());
                Log.d("my-tag", "Список категорій: ");
                if (response.isSuccessful()) {
                    for (Category category : response.body()) {
                        Log.d("my-tag", "Назва: " + category.GetName() + " Опис: " + category.GetDescription() + " Фото: " + category.GetImage());
                    }
                } else {
                    Log.d("my-tag", "респонс не успішний");
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.d("my-tag", "!!!Помилка при отриманні списку категорі!!!" + t.getMessage());
            }
        });
    }
}