package com.kosta.day16;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();	
			// localhost : 127.0.0.1
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			while(true) {
				System.out.println( "[client 기다림]");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[client 들어옴] " + isa.getHostName());
			}
		} catch(Exception e) {}
		
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e1) {}
		}
	}
}