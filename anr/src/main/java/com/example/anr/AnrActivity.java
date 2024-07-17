package com.example.anr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class AnrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anr);
    }

    public void onClick1(View view) {
        try {
            Thread.sleep(20000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void onClick2(View view) {
        SharedPreferences sp = getSharedPreferences("app", Context.MODE_PRIVATE);
        for (int i = 0; i < 100000; i++) {
            SharedPreferences.Editor edit = sp.edit();
            for (int j = 0; j < 100000; j++) {
                edit.putString("name", "aaaaa")
                        .putInt("age", 18)
                        .putBoolean("sex", true)
                        .commit();
            }
        }
    }
}