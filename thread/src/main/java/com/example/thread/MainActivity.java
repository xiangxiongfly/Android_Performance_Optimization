package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Process;
import android.util.Log;

import com.example.thread.utils.CPUThreadPool;
import com.example.thread.utils.IOThreadPool;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("myWork");
                Process.setThreadPriority(Process.THREAD_PRIORITY_DEFAULT);
                // 这是一些任务
            }
        }).start();


        CPUThreadPool.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                Log.e("TAG", "CPU密集任务");
            }
        });

        IOThreadPool.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                Log.e("TAG", "IO密集任务");
            }
        });

    }
}