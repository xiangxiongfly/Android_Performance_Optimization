package com.example.anr;

import android.app.Activity;
import android.app.Application;
import android.os.StrictMode;

import com.example.anr.bean.Person;
import com.example.anr.block.AppBlockCanaryContext;
import com.github.anrwatchdog.ANRWatchDog;
import com.github.moduth.blockcanary.BlockCanary;

import java.util.ArrayList;

public class BaseApp extends Application {
    private static ArrayList<Activity> activityList = new ArrayList<>();
    private static ArrayList<Object> sList = new ArrayList<>();

    public static void addActivity(Activity a) {
        activityList.add(a);
    }

    public static void addObj(Object a) {
        sList.add(a);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
//        initStrictMode();
        new ANRWatchDog().start();
    }

    private void initStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectCustomSlowCalls() //API等级11，使用StrictMode.noteSlowCode
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()// or .detectAll() for all detectable problems
                    .penaltyLog() //在Logcat 中打印违规异常信息
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectActivityLeaks()
                    .detectLeakedSqlLiteObjects()
                    .setClassInstanceLimit(Person.class, 2)
                    .detectLeakedClosableObjects() //API等级11
                    .penaltyLog()
                    .build());
        }
    }
}
