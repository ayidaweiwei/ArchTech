package com.mikechen.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * BIO 详解
 * @author  mikechen
 */
public class BioServer {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress("127.0.0.1", 8888));
        while(true) {
            Socket s = ss.accept(); //阻塞方法

            //新起线程来处理client端请求，让主线程可以接受下一个client的accept
            new Thread(() -> {
                handle(s);
            }).start();
        }

    }

    static void handle(Socket s) {
        try {
            byte[] bytes = new byte[1024];
            int len = s.getInputStream().read(bytes);  //阻塞方法
            System.out.println(new String(bytes, 0, len));

            s.getOutputStream().write(bytes, 0, len);  //阻塞方法
            s.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

