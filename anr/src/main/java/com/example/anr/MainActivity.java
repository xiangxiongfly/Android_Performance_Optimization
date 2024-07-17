package com.example.anr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void stuckClick(View view) {
        startActivity(new Intent(this, StuckActivity.class));
    }

    public void anrClick(View view) {
        startActivity(new Intent(this, AnrActivity.class));
    }
}