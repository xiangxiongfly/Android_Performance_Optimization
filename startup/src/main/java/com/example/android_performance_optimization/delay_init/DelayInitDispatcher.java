package com.example.android_performance_optimization.delay_init;

import android.os.Looper;
import android.os.MessageQueue;

import java.util.LinkedList;

public class DelayInitDispatcher {
    private DelayInitDispatcher() {
    }

    public static DelayInitDispatcher newInstance() {
        return new DelayInitDispatcher();
    }

    private LinkedList<Task> mDelayTasks = new LinkedList<>();

    private MessageQueue.IdleHandler mIdleHandler = new MessageQueue.IdleHandler() {
        @Override
        public boolean queueIdle() {
            if (mDelayTasks.size() > 0) {
                Task task = mDelayTasks.poll();
                task.run();
            }
            return !mDelayTasks.isEmpty();
        }
    };

    public DelayInitDispatcher addTask(Task task) {
        mDelayTasks.add(task);
        return this;
    }

    public void start() {
        Looper.myQueue().addIdleHandler(mIdleHandler);
    }
}
