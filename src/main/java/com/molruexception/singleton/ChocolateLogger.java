package com.molruexception.singleton;

import org.jetbrains.annotations.NotNull;

public class ChocolateLogger {

    private volatile static ChocolateLogger instance;

    public static ChocolateLogger getInstance() {
        if (instance == null) {
            synchronized (ChocolateLogger.class) {
                if (instance == null) {
                    instance = new ChocolateLogger();
                }
            }
        }
        return instance;
    }

    private ChocolateLogger() {}

    public void logEvent(@NotNull String event) {
        System.out.println(event);
    }

    public void logError(@NotNull String error) {
        System.out.println(error);
    }

}
