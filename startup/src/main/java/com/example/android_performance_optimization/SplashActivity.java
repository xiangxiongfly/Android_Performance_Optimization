package com.example.android_performance_optimization;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(
                () -> {
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                }, 2000L);
    }
}