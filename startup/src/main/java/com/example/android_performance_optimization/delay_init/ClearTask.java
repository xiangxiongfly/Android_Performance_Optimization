package com.example.android_performance_optimization.delay_init;

import android.util.Log;

public class ClearTask implements Task {
    @Override
    public void run() {
        try {
            Thread.sleep(2000L);
            Log.e("TAG", "清理资源");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
