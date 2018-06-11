package com.zz.analysisAndDisplay.socket;



import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

//ws://127.0.0.1:8087/Demo1/ws/张三

/**
 * Created by 90807 on 2018/6/6.
 */
@ServerEndpoint("/ws1/{user}")
public class WSServer {
    private String currentUser;
    public static boolean loop = true;
    public static boolean isOpen = false;
    public static String data = "event did not occur";
    public static Session tmpSession = null;

    //连接打开时执行
    @OnOpen
    public void onOpen(@PathParam("user") String user, Session session) {
        currentUser = user;
        System.out.println("Connected ... " + session.getId());
        //【1】连接打开后，通知前端
        try {
            session.getBasicRemote().sendText("Connected Success！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        isOpen = true;
        //【2】某一事件发生后，发送消息给前端对应的data
        //【2.1】建一个线程处理事件
        //【2.2】将session给tmpSession，原因是新建的线程不知道为什么无法获取该原始session；
        tmpSession = session;
        new Thread() {
            public void run() {
                while (isOpen) {
                    while (loop&&(isOpen)) {
                        try {
//                    Timer timer = new Timer();
//                    timer.schedule(new TimerTask(), 1000, 2000);
                            Thread.sleep(500);
                            Thread t = Thread.currentThread();
                            String name = t.getName();
                            System.out.println("threading ... " + tmpSession.getId() + "Thread name=" + name);
                            System.out.println("session is open  ... " + tmpSession.isOpen());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        tmpSession.getBasicRemote().sendText(data);
                        // 重置事件和data
                        WSServer.loop = true;
                        WSServer.data = "event event did not occur !";
                    } catch (Exception e) {
                        System.out.println("session cause not  problem");
                        e.printStackTrace();
                    }
                }
            }
        }.start();//开启线程
        System.out.println("push to front ... " + session.getId());
    }

    //收到消息时执行
    @OnMessage
    public String onMessage(String message, Session session) {
        System.out.println(currentUser + "：" + message);
//            session.getBasicRemote().sendText("this is the first message");
        return currentUser + "：" + message;
    }

    //连接关闭时执行
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        isOpen = false;
        System.out.println(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }

    //连接错误时执行
    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }
}