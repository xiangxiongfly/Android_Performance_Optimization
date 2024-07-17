package com.example.thread.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CPUThreadPool {

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static ExecutorService sInstance;

    public static ExecutorService newCpuThreadPool() {
        int corePoolSize = CPU_COUNT + 1;
        int maximumPoolSize = CPU_COUNT * 2 + 1;
        long keepAliveTime = 30;

        return new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
    }

    public static ExecutorService getInstance() {
        if (sInstance == null) {
            sInstance = newCpuThreadPool();
        }
        return sInstance;
    }
}
