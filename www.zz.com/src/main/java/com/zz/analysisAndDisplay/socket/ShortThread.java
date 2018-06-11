package com.zz.analysisAndDisplay.socket;

import sun.java2d.pipe.LoopBasedPipe;

import javax.websocket.Session;
import java.io.IOException;

/**
 * Created by 90807 on 2018/6/6.
 */
public class ShortThread extends Thread{

    private Session session;
    private String data;

    @Override
    public void run() {
        try {
            session.getBasicRemote().sendText(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ShortThread(Session session,String data) {
       this.session=session;
       this.data=data;
    }
}
