package com.zz.deviceAndData.listener;

import javax.websocket.Session;
import java.io.IOException;

/**
 * @author juntao.qiu  
 */ 
public class EventListenerTester implements EventListener{  
    private boolean loop = true;  
 
    public void execute( Session session){
        ListenerThread listenerThread = new ListenerThread(3);//初始化一个定时器
        listenerThread.setEventListener(this);//设置本类为监听器
        listenerThread.start();
          
        while(loop){
            try{
//                Thread.sleep(1000);

                System.out.println("still in while(true) loop");
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
        //将数据发到前端
        try {
            session.getBasicRemote().sendText("收到数据");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("receive data");
    }  
 
 
//实现了EventListener接口  
    public void handleEvent(EventSource event) {  
        int eType = event.getEventType();  
        switch(eType){//判断事件类型，我们可以有很多种的事件  
            case EventSource.EVENT_TIMEOUT:  
                this.loop = false;  
                break;  
            case EventSource.EVENT_OVERFLOW:  
                break;  
            default:  
                this.loop = true;  
                break;  
        }  
    }  
 
//    public static void main(String[] args){
//        EventListenerTester tester = new EventListenerTester();
//        tester.execute(session);
//    }
 
}  