package com.example.sergionavarro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class Acceso extends AppCompatActivity {

    ImageView logoLogin;
    TextView appNameLogin;
    TextInputLayout username;
    TextInputLayout pass;
    MaterialButton loginNow;
    MaterialButton register;
    MaterialButton login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        ImageView backgroundLogin = findViewById(R.id.backgroundLogin);

        Glide.with(this)
                .load("https://as2.ftcdn.net/v2/jpg/03/10/43/63/1000_F_310436310_kMzFckNuIXlUxodg2dTDnzSQm9lI9UKj.jpg")
                .into(backgroundLogin);

        logoLogin = findViewById(R.id.logoLogin);
        appNameLogin = findViewById(R.id.appNameLogin);
        username = findViewById(R.id.userLogin);
        pass = findViewById(R.id.passLogin);
        loginNow = findViewById(R.id.loginButton);
        register = findViewById(R.id.registerButton);
        login = findViewById(R.id.loginButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Acceso.this, Registro.class);

                Pair[] pairs = new Pair[6];
                pairs[0] = new Pair<View, String>(logoLogin, "logoTrans2");
                pairs[1] = new Pair<View, String>(appNameLogin, "bfuTrans2");
                pairs[2] = new Pair<View, String>(username, "usernameTrans");
                pairs[3] = new Pair<View, String>(pass, "passTrans");
                pairs[4] = new Pair<View, String>(loginNow, "loginNowTrans");
                pairs[5] = new Pair<View, String>(register, "registerTrans");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Acceso.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Acceso.this, Logeado.class);
                startActivity(intent);
            }
        });
    }
}