package com.example.sergionavarro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Logeado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logeado);

        ImageView backgroundLogeado = findViewById(R.id.backgroundLogeado);

        Glide.with(this)
                .load("https://as2.ftcdn.net/v2/jpg/03/10/43/63/1000_F_310436310_kMzFckNuIXlUxodg2dTDnzSQm9lI9UKj.jpg")
                .into(backgroundLogeado);
    }
}