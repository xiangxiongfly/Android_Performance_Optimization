package com.example.memory.bitmap;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.example.memory.R;

public class BitmapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        // 逻辑密度
        float density = metrics.density;
        // 物理密度
        int densityDpi = metrics.densityDpi;
        Log.e("TAG", density + "-" + densityDpi);

        // 1倍图
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.splash1);
        printBitmap(bitmap1, "drawable-mdpi");

        // 2倍图
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.splash2);
        printBitmap(bitmap2, "drawable-xhdpi");

        // 3倍图
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.drawable.splash3);
        printBitmap(bitmap3, "drawable-xxhdpi");

        // 4倍图
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.drawable.splash4);
        printBitmap(bitmap4, "drawable-xxxhdpi");

        // drawable
        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.drawable.splash);
        printBitmap(bitmap5, "drawable");
        /*
        3.0-480
        drawable-mdpi Bitmap占用内存:37127376 width:2574 height:3606 1像素占用大小:4
        drawable-xhdpi Bitmap占用内存:9281844 width:1287 height:1803 1像素占用大小:4
        drawable-xxhdpi Bitmap占用内存:4125264 width:858 height:1202 1像素占用大小:4
        drawable-xxxhdpi Bitmap占用内存:2323552 width:644 height:902 1像素占用大小:4
        drawable Bitmap占用内存:37127376 width:2574 height:3606 1像素占用大小:4
         */
    }

    private void printBitmap(Bitmap bitmap, String drawable) {
        String builder = drawable +
                " Bitmap占用内存:" +
                bitmap.getByteCount() +
                " width:" +
                bitmap.getWidth() +
                " height:" +
                bitmap.getHeight() +
                " 1像素占用大小:" +
                getByteBy1px(bitmap.getConfig());
        Log.e("TAG", builder);
    }

    private int getByteBy1px(Bitmap.Config config) {
        if (Bitmap.Config.ALPHA_8.equals(config)) {
            return 1;
        } else if (Bitmap.Config.RGB_565.equals(config)) {
            return 2;
        } else if (Bitmap.Config.ARGB_8888.equals(config)) {
            return 4;
        }
        return 1;
    }
}