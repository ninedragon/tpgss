package com.zz.deviceAndData.listener;

import javax.jms.Message;
import javax.jms.MessageListener;  

import org.apache.log4j.Logger;  
import org.springframework.stereotype.Component;  
  
//以前测试服务器发送事件的，暂时无用，先保留备用
@Component("clientPushListener")  
public class ClientPushListener implements MessageListener {  
     protected static final Logger logger = Logger.getLogger(ClientPushListener.class);  
    @Override  
    public void onMessage(Message message) {
          System.out.println("hello it is ok ");
    }
}