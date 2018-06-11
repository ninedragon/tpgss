package com.zz.analysisAndDisplay.observer;

public class ObserverDemo {
    public static void main(String[] args) {     
        BeingWatched beingWatched = new BeingWatched();//受查者     
            Watcher watcher = new Watcher();//观察者
        beingWatched.addObserver(watcher);     
        beingWatched.counter(10);     
    }     
}    