package com.molruexception.singleton;

import org.jetbrains.annotations.NotNull;

public class ChocolateBoiler {

    private boolean empty;
    private boolean boiled;
    private volatile static ChocolateBoiler uniqueInstance;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
        System.out.println("Creating unique instance of Chocolate Boiler");
    }

    public static  ChocolateBoiler getInstance() {
        if (uniqueInstance == null) {
            synchronized (ChocolateBoiler.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new ChocolateBoiler();
                }
            }
        }
        return uniqueInstance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            ChocolateLogger.getInstance().logEvent(String.format(
                    "[%s] fill the boiler with a milk/chocolate mixture",
                    Thread.currentThread().getName()
            ));
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            empty = true;
            ChocolateLogger.getInstance().logEvent(String.format(
                    "[%s] drain the boiled milk and chocolate",
                    Thread.currentThread().getName()
            ));
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
            ChocolateLogger.getInstance().logEvent(String.format(
                    "[%s] bring the contents to a boil",
                    Thread.currentThread().getName()
            ));
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
