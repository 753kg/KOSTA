package com.kosta.day11;

public class ThreadExample {

	public static void main(String[] args) {
		Thread thread1 = new MovieThread();
		Thread thread2 = new Thread(new MusicRunnable());
		
		thread1.start();
		thread2.start();

	}

}
