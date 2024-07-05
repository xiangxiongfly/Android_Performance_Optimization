package com.example.android_performance_optimization.task;

import com.aice.appstartfaster.task.AppStartTask;
import com.example.android_performance_optimization.BaseApp;
import com.example.android_performance_optimization.lib.ActivityManager;

public class ActivityTask  extends AppStartTask {
    private BaseApp instance;

    public ActivityTask(BaseApp instance) {
        this.instance = instance;
    }

    @Override
    public void run() {
        ActivityManager.getInstance().init(instance);
    }

    @Override
    public boolean isRunOnMainThread() {
        return false;
    }
}
