package com.example.memory.leak;

import java.util.ArrayList;

public class CallbackManager {
    public static ArrayList<Callback> sCallbacks = new ArrayList<>();

    public static void addCallback(Callback callback) {
        sCallbacks.add(callback);
    }

    public static void removeCallback(Callback callback) {
        sCallbacks.remove(callback);
    }
}
