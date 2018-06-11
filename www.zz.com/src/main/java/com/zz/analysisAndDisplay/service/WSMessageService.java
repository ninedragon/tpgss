package com.zz.analysisAndDisplay.service;

import com.zz.analysisAndDisplay.socket.WebSocketChat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service("webSocketMessageService")
public class WSMessageService {
    public static boolean loop = true;
    public static boolean isOpen = false;
    public static String data = "event did not occur";
    private Logger logger = LoggerFactory.getLogger(WSMessageService.class);
    //声明websocket连接类
    private WebSocketChat webSocketChat = new WebSocketChat();

    /**
     * @Title: sendToAllTerminal
     * @Description: 调用websocket类给用户下的所有终端发送消息
     * @param @param userId 用户id
     * @param @param message 消息
     * @param @return 发送成功返回true，否则返回false
     */
    public Boolean sendToAllTerminal(String userId,String message){   
        logger.info("向用户{}的消息：{}",userId,message);
        if(webSocketChat.sendMessageToUser(userId,message)){
            return true;
        }else{
            return false;
        }   
    }           
}