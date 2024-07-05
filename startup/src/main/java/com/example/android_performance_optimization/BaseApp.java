package com.example.android_performance_optimization;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.aice.appstartfaster.dispatcher.AppStartTaskDispatcher;
import com.example.android_performance_optimization.aop.CostTime;
import com.example.android_performance_optimization.lib.ActivityManager;
import com.example.android_performance_optimization.lib.AppConfig;
import com.example.android_performance_optimization.lib.TitleBarStyle;
import com.example.android_performance_optimization.lib.ToastLogInterceptor;
import com.example.android_performance_optimization.lib.ToastStyle;
import com.example.android_performance_optimization.task.ActivityTask;
import com.example.android_performance_optimization.task.RefreshTask;
import com.example.android_performance_optimization.task.TitleBarTask;
import com.example.android_performance_optimization.task.ToastTask;
import com.hjq.bar.TitleBar;
import com.hjq.toast.ToastUtils;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshFooter;
import com.scwang.smart.refresh.layout.api.RefreshHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshFooterCreator;
import com.scwang.smart.refresh.layout.listener.DefaultRefreshHeaderCreator;

public class BaseApp extends Application {
    private static BaseApp instance;

    public static BaseApp getInstance() {
        return instance;
    }

    @CostTime
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

//        Debug.startMethodTracing("myTrace001"); // TraceView开始

//        Trace.beginSection("initRefresh");  // Systrace开始
//        initRefresh();
//        Trace.endSection();  // Systrace结束
//        Trace.beginSection("initTitleBar");
//        initTitleBar();
//        Trace.endSection();
//        Trace.beginSection("initToast");
//        initToast();
//        Trace.endSection();
//        Trace.beginSection("initActivites");
//        initActivites();
//        Trace.endSection();

//        Debug.stopMethodTracing();  // TraceView结束


        AppStartTaskDispatcher.create()
                .setShowLog(true)
                .addAppStartTask(new ActivityTask(instance))
                .addAppStartTask(new ToastTask(instance))
                .addAppStartTask(new TitleBarTask())
                .addAppStartTask(new RefreshTask())
                .start()
                .await();
    }

    @CostTime
    private void initActivites() {
        ActivityManager.getInstance().init(instance);
    }

    @CostTime
    private void initToast() {
        ToastUtils.init(instance, new ToastStyle());
        ToastUtils.setDebugMode(AppConfig.isDebug());
        ToastUtils.setInterceptor(new ToastLogInterceptor());
    }

    @CostTime
    private void initTitleBar() {
        TitleBar.setDefaultStyle(new TitleBarStyle());
    }

    @CostTime
    private void initRefresh() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.black, android.R.color.white);
                return new ClassicsHeader(context);
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }
}
