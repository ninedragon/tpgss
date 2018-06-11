package com.zz.analysisAndDisplay.utils;

/**
 * Created by 90807 on 2018/6/7.
 */
public class ThreadUtils {
    public static void printCurrentThreadname() {
        Thread t = Thread.currentThread();
        String name = t.getName();
        System.out.println("name=" + name);
    }
}
