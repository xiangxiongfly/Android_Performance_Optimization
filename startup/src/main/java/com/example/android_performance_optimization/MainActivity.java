package com.example.android_performance_optimization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.android_performance_optimization.aop.CostTime;
import com.example.android_performance_optimization.delay_init.ClearTask;
import com.example.android_performance_optimization.delay_init.DelayInitDispatcher;
import com.example.android_performance_optimization.delay_init.PreloadTask;
import com.flyjingfish.android_aop_core.annotations.CheckNetwork;
import com.flyjingfish.android_aop_core.annotations.SingleClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DelayInitDispatcher.newInstance()
                .addTask(new PreloadTask())
                .addTask(new ClearTask())
                .start();
    }
}