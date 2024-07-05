package com.example.android_performance_optimization.aop;//package com.example.android_performance_optimization.aop;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.flyjingfish.android_aop_annotation.AopMethod;
import com.flyjingfish.android_aop_annotation.ProceedJoinPoint;
import com.flyjingfish.android_aop_annotation.base.BasePointCut;


import java.util.concurrent.TimeUnit;

/**
 * 切面类
 */
public class CostTimePointcut implements BasePointCut<CostTime> {
    @Nullable
    @Override
    public Object invoke(@NonNull ProceedJoinPoint proceedJoinPoint, @NonNull CostTime costTime) {
        long startTime = System.currentTimeMillis();
        proceedJoinPoint.proceed(); // 继续执行原方法
        long time = System.currentTimeMillis() - startTime;
        Class<?> targetClass = proceedJoinPoint.getTargetClass();
        String className = targetClass.getName();
        AopMethod targetMethod = proceedJoinPoint.getTargetMethod();
        String methodName = targetMethod.getName();
        String builder = className + "#" + methodName + " [" + time + "ms" + "] ";
        Log.e("CostTime", builder);
        return null;
    }
}
