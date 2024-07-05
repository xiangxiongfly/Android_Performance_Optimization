package com.example.android_performance_optimization.task;

import com.aice.appstartfaster.task.AppStartTask;
import com.example.android_performance_optimization.lib.TitleBarStyle;
import com.hjq.bar.TitleBar;

public class TitleBarTask extends AppStartTask {
    @Override
    public void run() {
        TitleBar.setDefaultStyle(new TitleBarStyle());
    }

    @Override
    public boolean isRunOnMainThread() {
        return false;
    }
}
