package com.example.anr;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class StuckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stuck);
//        Log.e("TAG", "开始123");
//        Debug.startMethodTracing("myTrace");

        working();

//        Debug.stopMethodTracing();

        test();
    }

    // 违规代码
    private void test() {


        // 主线IO操作问题
//        File externalStorage = getFilesDir();
//        File destFile = new File(externalStorage, "hello.txt");
//        try {
//            OutputStream output = new FileOutputStream(destFile, true);
//            output.write("I am testing io".getBytes());
//            output.flush();
//            output.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        // Activity内存泄露问题
//        BaseApp.addActivity(this);

//        BaseApp.addObj(new Person("name111"));
//        BaseApp.addObj(new Person("name222"));
//        BaseApp.addObj(new Person("name333"));
//        BaseApp.addObj(new Person("name444"));

//        MySQLiteOpenHelper dbHelper = new MySQLiteOpenHelper(this);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        Cursor cursor = db.query("course", null, null, null, null, null, null);
//        if (cursor != null) {
//            while (cursor.moveToNext()) {
//
//            }
//        }
    }

    private void working() {
//        new Handler().post(new Runnable() {
//            @Override
//            public void run() {
//                Trace.beginSection("workingRun");
//                try {
//                    Thread.sleep(2000L);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                Trace.endSection();
//            }
//        });
    }

    public void sleepClick(View view) {
        testSleep();
    }

    private void testSleep() {
        Log.e("TAG", "sleep前");
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Log.e("TAG", "sleep后");
    }

    public void mathClick(View view) {
        testMath();
    }

    private void testMath() {
        Log.e("TAG", "math前");
        long start = System.currentTimeMillis();
        double result = 0;
        for (int i = 0; i < 10000000; i++) {
            result += Math.acos(Math.cos(i));
            result -= Math.asin(Math.sin(i));
            result += Math.acos(Math.cos(i));
            result -= Math.asin(Math.sin(i));
        }
        Log.e("TAG", "math" + result);
        Log.e("TAG", "耗时 " + (System.currentTimeMillis() - start));
    }
}