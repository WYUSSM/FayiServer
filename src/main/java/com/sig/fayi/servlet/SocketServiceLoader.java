package com.sig.fayi.servlet;

import com.sig.fayi.thread.SocketThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SocketServiceLoader implements ServletContextListener {
    // 定义保存所有Socket的ArrayList，并将其包装为线程安全的
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<Socket>());
    private SocketThread socketThread;
    @Override
    public void contextDestroyed(ServletContextEvent arg0){
        if(null!=socketThread && !socketThread.isInterrupted())
        {
            socketThread.closeSocketServer();
            socketThread.interrupt();
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0){
        if(socketThread==null){
            //新建线程类
            socketThread=new SocketThread(null);//启动线程
            socketThread.start();
        }
    }
}
