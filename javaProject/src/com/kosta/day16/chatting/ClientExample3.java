package com.kosta.day16.chatting;

import java.net.*;
class ClientExample3 {
    public static void main(String[] args) {
        Socket socket = null;
        try {
        	System.out.println("서버에 접속...");
            socket = new Socket("192.168.0.129", 9001);
            System.out.println("서버 접속 성공");
            Thread thread1 = new SenderThread(socket);
            Thread thread2 = new ReceiverThread(socket);
            thread1.start();
            thread2.start();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

