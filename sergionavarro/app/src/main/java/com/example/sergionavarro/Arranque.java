package com.example.sergionavarro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Arranque extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arranque);

        assignGradient();

        ImageView backgroundSplash = findViewById(R.id.backgroundSplash);
        Glide.with(this)
                .load("https://as2.ftcdn.net/v2/jpg/03/10/43/63/1000_F_310436310_kMzFckNuIXlUxodg2dTDnzSQm9lI9UKj.jpg")
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                //.centerCrop()
                .into(backgroundSplash);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.go_up);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.go_down);

        final TextView name = findViewById(R.id.appNameSplash);
        final ImageView logo = findViewById(R.id.logoSplash);

        name.setAnimation(animation2);
        logo.setAnimation(animation1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Arranque.this, Acceso.class);

                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(logo, "logoTrans");
                pairs[1] = new Pair<View, String>(name, "bfuTrans");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Arranque.this, pairs);
                    startActivity(intent, options.toBundle());
                } else {
                    startActivity(intent);
                    finish();
                }
            }
        },4000);


    }

    private void assignGradient() {
        GradientDrawable gradient = new GradientDrawable();
        gradient.setColors(
                new int[] {
                        getResources().getColor(R.color.white),
                        getResources().getColor(R.color.black)
                }
        );
        gradient.setOrientation(
                GradientDrawable.Orientation.TOP_BOTTOM
        );
        gradient.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        gradient.setShape(GradientDrawable.RECTANGLE);
        findViewById(R.id.backgroundGradient).setBackground(gradient);
    }
}