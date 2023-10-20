package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    private ImageView ivMyImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMyImage = findViewById(R.id.ivMyImage);
//        String url = "https://pipi.itstep.click/images/monika.jpg";
        String url = "http://10.0.2.2:5290/images/1.jpg";
        Glide // бібліотека, яка призначена для стягування фоток з інета для свого UI на Android
                .with(this)
                .load(url)
                .apply(new RequestOptions().override(600))
                .into(ivMyImage);
    }
}