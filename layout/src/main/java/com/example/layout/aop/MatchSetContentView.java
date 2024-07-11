package com.example.layout.aop;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.flyjingfish.android_aop_annotation.AopMethod;
import com.flyjingfish.android_aop_annotation.ProceedJoinPoint;
import com.flyjingfish.android_aop_annotation.anno.AndroidAopMatchClassMethod;
import com.flyjingfish.android_aop_annotation.base.MatchClassMethod;
import com.flyjingfish.android_aop_annotation.enums.MatchType;

@AndroidAopMatchClassMethod(
        targetClassName = "androidx.appcompat.app.AppCompatActivity",
        methodName = {"setContentView"},
        type = MatchType.SELF
)
public class MatchSetContentView implements MatchClassMethod {
    @Nullable
    @Override
    public Object invoke(@NonNull ProceedJoinPoint proceedJoinPoint, @NonNull String methodName) {
        Class<?> targetClass = proceedJoinPoint.getTargetClass();
        long start = System.currentTimeMillis();
        proceedJoinPoint.proceed();
        long time = System.currentTimeMillis() - start;
        Log.e("TAG", targetClass.getSimpleName() + "#" + methodName + "耗时：" + time);
        return null;
    }
}
