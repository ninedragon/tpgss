package com.zz.deviceAndData.listener;

public interface EventSource {
    public final int EVENT_TIMEOUT = 1;  
    public final int EVENT_OVERFLOW = 2;  
 
    /**  
     * get an integer to identify a special event  
     * @return  
     */ 
    public int getEventType();  
}  