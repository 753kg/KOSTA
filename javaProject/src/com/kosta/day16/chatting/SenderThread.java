package com.kosta.day16.chatting;

import java.io.*;
import java.net.*;
class SenderThread extends Thread {
    Socket socket;
    SenderThread(Socket socket) {   
        this.socket = socket;
    }
    public void run() {
        try {
        	/*
        	InputStream is = System.in;	// 1byte
        	InputStreamReader isr = new InputStreamReader(is);	// 2byte
        	BufferedReader br = new BufferedReader(isr);	// 1줄씩 읽는 기능이있음.
        	*/
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
            PrintWriter writer = 
                new PrintWriter(socket.getOutputStream());
            while (true) {
                String str = reader.readLine();		// 키보드 입력을 한줄 읽기
                if (str.equals("bye"))
                    break;
                writer.println(str);
                writer.flush();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }   
        finally {
            try {
                socket.close();
            }
            catch (Exception ignored) {
            }
        }
    }
}
