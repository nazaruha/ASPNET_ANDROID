package com.example.android.category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.android.MainActivity;
import com.example.android.R;
import com.example.android.dto.category.CategoryCreateDTO;
import com.example.android.dto.category.CategoryItemDTO;
import com.example.android.service.ApplicationNetwork;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryCreateActivity extends AppCompatActivity {

    TextInputLayout tlCategoryName;
    TextInputLayout tlCategoryImage;
    TextInputLayout tlCategoryDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_create);

        tlCategoryName = findViewById(R.id.tlCategoryName);
        tlCategoryImage = findViewById(R.id.tlCategoryImage);
        tlCategoryDescription = findViewById(R.id.tlCategoryDescription);
    }

    public void onClickCreateCategory(View view) {
        String name = tlCategoryName.getEditText().getText().toString().trim();
        String image = tlCategoryImage.getEditText().getText().toString().trim();
        String description = tlCategoryDescription.getEditText().getText().toString().trim();

//        Log.d("salo", "---Name---"+name);
//        Log.d("salo", "---Image---"+image);
//        Log.d("salo", "---Description---"+description);
        CategoryCreateDTO dto = new CategoryCreateDTO();
        dto.setName(name);;
        dto.setImage(image);
        dto.setDescription(description);

        ApplicationNetwork.getInstance()
                .getCategoriesApi()
                .create(dto)
                .enqueue(new Callback<CategoryItemDTO>() {
                    @Override
                    public void onResponse(Call<CategoryItemDTO> call, Response<CategoryItemDTO> response) {
                        if (response.isSuccessful()) {
                            Intent intent = new Intent(CategoryCreateActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<CategoryItemDTO> call, Throwable t) {
                        Log.d("-errorCreateCategory-", t.getMessage());
                    }
                });
    }
}