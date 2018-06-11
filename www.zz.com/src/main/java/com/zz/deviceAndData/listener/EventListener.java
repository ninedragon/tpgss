package com.zz.deviceAndData.listener;

/**
 * @author juntao.qiu  
 */ 
public interface EventListener {  
    /**  
     * handle the event when it raise  
     * @param event  
     */ 
    public void handleEvent(EventSource event);  
}  