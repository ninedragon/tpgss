package com.zz.analysisAndDisplay.controller;

import com.zz.analysisAndDisplay.service.WSMessageService;
import com.zz.analysisAndDisplay.socket.WebSocketChat;
import com.zz.common.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


@Controller
@Scope(value = "prototype")
@RequestMapping("listen")
public class MessageController extends BaseController {
    //用于监听事件的一些属性
    public static boolean loop = true;
    public static boolean isOpen = true;
    //    public static boolean isOpen = false;
    public static String data = "event did not occur";
    private Logger logger = LoggerFactory.getLogger(WSMessageService.class);

    //websocket服务层调用类
    @Autowired
    private WSMessageService wsMessageService;

    //请求入口
    @RequestMapping(value = "openListen", method = RequestMethod.POST)
    @ResponseBody
    public String openListen(String openListen) {
        if ("1".equals(openListen)) {
            listen();
            return "监听打开状态";
        } else {
            isOpen = false;
            logger.info("关闭监听");
            return "监听关闭状态";
        }

    }

    private void listen() {
        //【1】开启线程监听事件
        //【2】找到有多少用户，给每个用户的两个终端发消息（先以一个用户为例）
        Map<String, Set<WebSocketChat>> userSocket = new HashMap<>();
        List userList = new ArrayList<String>();
        while (isOpen) {
            while (loop && isOpen) {
                try {
//                    Timer timer = new Timer();
//                    timer.schedule(new TimerTask(), 1000, 2000);
                    Thread.sleep(500);
                    Thread t = Thread.currentThread();
                        String name = t.getName();
                    System.out.println("threading ... " + "Thread name=" + name);
//                            System.out.println("session isOpen = " +isOpen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!isOpen) {//连接已关闭
                logger.info("监听关闭了，不监听");
            } else {//连接未关闭，但是监听到消息了
                try {
                    userSocket = WebSocketChat.getUserSocket();
                    for (String key : userSocket.keySet()) {
                        userList.add(key);
                        System.out.println("Key = " + key);
                    }
                    for (int i = 0; i < userList.size(); i++) {
                        String user = (String) userList.get(i);
                        if (wsMessageService.sendToAllTerminal(user, data)) {
                            logger.info("用户{" + user + "发送成功");
                        } else {
                            logger.error("用户{" + user + "发送失败");
                        }
                    }
                    // 重置事件和data
                    loop = true;
                    data = "event event did not occur !";
                } catch (Exception e) {
                    System.out.println("session cause not  problem");
                    e.printStackTrace();
                }
            }
        }
    }
}
