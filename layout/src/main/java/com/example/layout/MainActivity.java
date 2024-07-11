package com.example.layout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import androidx.core.view.LayoutInflaterCompat;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyjingfish.android_aop_core.annotations.CheckNetwork;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 统计控件耗时
//        LayoutInflaterCompat.setFactory2(getLayoutInflater(), new LayoutInflater.Factory2() {
//            @Nullable
//            @Override
//            public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
//                long start = System.nanoTime();
//                View view = getDelegate().createView(parent, name, context, attrs);
//                Log.e("TAG", name + "耗时：" + (System.nanoTime() - start) + "ns");
//                return view;
//            }
//
//            @Nullable
//            @Override
//            public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
//                return null;
//            }
//        });

        super.onCreate(savedInstanceState);

        // AsyncLayoutInflater
//        long start = System.currentTimeMillis();
//        new AsyncLayoutInflater(this).inflate(R.layout.activity_main, null, new AsyncLayoutInflater.OnInflateFinishedListener() {
//            @Override
//            public void onInflateFinished(@NonNull View view, int resid, @Nullable ViewGroup parent) {
//                setContentView(view);
//            }
//        });
//        Log.e("TAG", "setContentView耗时：" + (System.currentTimeMillis() - start));

        // 统计setContentView耗时
        long start = System.currentTimeMillis();
        setContentView(R.layout.activity_main);
        long time = System.currentTimeMillis() - start;
        Log.e("TAG", "setContentView耗时：" + time);
    }


    @CheckNetwork(toastText = "没有网络呀～～～")
    public void onClick(View view) {

    }
}