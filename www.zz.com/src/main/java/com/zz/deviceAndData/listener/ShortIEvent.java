package com.zz.deviceAndData.listener;

public class ShortIEvent implements EventSource{
    private int type;  
 
    public ShortIEvent(){
        this.type = EventSource.EVENT_TIMEOUT;;  
    }  
      
    public int getEventType() {  
        return this.type;  
    }  
 
}  