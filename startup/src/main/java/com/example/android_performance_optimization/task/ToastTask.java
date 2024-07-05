package com.example.android_performance_optimization.task;

import android.app.Application;

import com.aice.appstartfaster.task.AppStartTask;
import com.example.android_performance_optimization.lib.AppConfig;
import com.example.android_performance_optimization.lib.ToastLogInterceptor;
import com.example.android_performance_optimization.lib.ToastStyle;
import com.hjq.toast.ToastUtils;

public class ToastTask extends AppStartTask {
    private Application application;

    public ToastTask(Application application) {
        this.application = application;
    }

    @Override
    public void run() {
        ToastUtils.init(application, new ToastStyle());
        ToastUtils.setDebugMode(AppConfig.isDebug());
        ToastUtils.setInterceptor(new ToastLogInterceptor());
    }

    @Override
    public boolean isRunOnMainThread() {
        return false;
    }
}
