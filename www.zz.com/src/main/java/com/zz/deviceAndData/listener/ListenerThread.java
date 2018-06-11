package com.zz.deviceAndData.listener;

/**  
 * @author juntao.qiu  
 */ 
public class ListenerThread extends Thread{
    private EventListener listener;  
    private int sleepSeconds;  
 
    public ListenerThread(int seconds){
        this.sleepSeconds = seconds;  
    }  
 
    public void setEventListener(EventListener listener){  
        this.listener = listener;  
    }  
      
    public void run(){  //
        for(int i = sleepSeconds;i>0;i--){  
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException ex) {  
                System.err.println(ex.getMessage());  
            }  
        }  
          
        raiseTimeoutEvent();//raise一个TimeOut事件给监听器  
    }  
 
    private void raiseTimeoutEvent(){  
        this.listener.handleEvent(new ShortIEvent());
    }  
}  