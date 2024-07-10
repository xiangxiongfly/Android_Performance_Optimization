package com.example.memory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.memory.bitmap.BitmapActivity;
import com.example.memory.leak.LeakActivity;
import com.example.memory.shake.ShakeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void memoryShakeClick(View view) {
        startActivity(new Intent(this, ShakeActivity.class));
    }

    public void memoryLeakClick(View view) {
        startActivity(new Intent(this, LeakActivity.class));
    }

    public void bitmapClick(View view) {
        startActivity(new Intent(this, BitmapActivity.class));
    }
}