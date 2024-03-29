package com.example.localprideshoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        if (getSupportActionBar() != null)
            getSupportActionBar().hide();

        ImageView imgBackground = findViewById(R.id.img_background);

        Glide.with(this)
                .load(R.drawable.splashscreen)
                .into(imgBackground);

        int waktu_loading = 4000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashscreen = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(splashscreen);
                finish();
            }
        }, waktu_loading);
    }
}
