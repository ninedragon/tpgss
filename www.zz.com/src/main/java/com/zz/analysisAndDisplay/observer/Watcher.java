package com.zz.analysisAndDisplay.observer;

public class Watcher implements java.util.Observer {
  public void update(java.util.Observable obj, Object arg) {     
    System.out.println("Update() called, count is "      
                                + ((Integer) arg).intValue());     
}     
}    