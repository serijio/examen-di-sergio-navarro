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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class Registro extends AppCompatActivity {

    ImageView logoRegister;
    TextView appNameRegister;
    TextInputLayout emailRegister;
    TextInputLayout userRegister;
    MaterialButton createAcc;
    MaterialButton backLogin;
    MaterialButton regUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ImageView backgroundLogin = findViewById(R.id.backgroundRegister);

        Glide.with(this)
                .load("https://as2.ftcdn.net/v2/jpg/03/10/43/63/1000_F_310436310_kMzFckNuIXlUxodg2dTDnzSQm9lI9UKj.jpg")
                .into(backgroundLogin);

        logoRegister = findViewById(R.id.logoRegister);
        appNameRegister = findViewById(R.id.appNameRegister);
        emailRegister = findViewById(R.id.emailRegister);
        userRegister = findViewById(R.id.userRegister);
        createAcc = findViewById(R.id.registerNowButton);
        backLogin = findViewById(R.id.backToLogin);
        regUser = findViewById(R.id.registerNowButton);
        
        backLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //transitionBack();
                Intent intent = new Intent(Registro.this, Acceso.class);

                Pair[] pairs = new Pair[6];
                pairs[0] = new Pair<View, String>(logoRegister, "logoTrans");
                pairs[1] = new Pair<View, String>(appNameRegister, "bfuTrans");
                pairs[2] = new Pair<View, String>(emailRegister, "emailTrans");
                pairs[3] = new Pair<View, String>(userRegister, "userTrans");
                pairs[4] = new Pair<View, String>(createAcc, "accTrans");
                pairs[5] = new Pair<View, String>(backLogin, "loginTrans");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Registro.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }
            }
        });
        
        regUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Registro.this, "User correctly added. Proceed to login now.", Toast.LENGTH_LONG).show();
            }
        });

    }
}