package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.android.dto.category.CategoryItemDTO;
import com.example.android.service.ApplicationNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {
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
        ApplicationNetwork
                .getInstance() // init connection
                .getCategoriesApi() // get interface with urls to work with cetegories
                .list() // use its method with url to get list of categories
                .enqueue(new Callback<List<CategoryItemDTO>>() { // enqueue -> asynchronous request to the server
                    @Override
                    public void onResponse(Call<List<CategoryItemDTO>> call, Response<List<CategoryItemDTO>> response) {
                        Log.d("my-tag", "Список категорій: ");
                        if (response.isSuccessful()) {
                            for (CategoryItemDTO category : response.body()) {
                                Log.d("my-tag", "Назва: " + category.getName() + " Опис: " + category.getDescription() + " Фото: " + category.getImage());
                            }
                        } else {
                            Log.d("my-tag", "респонс не успішний");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<CategoryItemDTO>> call, Throwable t) {
                        Log.d("my-tag", "!!!Помилка при отриманні списку категорі!!!" + t.getMessage());
                    }
                });

    }
}