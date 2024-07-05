package com.example.android_performance_optimization.delay_init;

import android.util.Log;

public class PreloadTask implements Task {
    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
            Log.e("TAG", "预加载数据");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
