package com.kosta.day14;

import java.util.List;

public class MyThreadA extends Thread{
	
	List<String> list;
	boolean stop = false;
	
								// 공유데이터 (여러 쓰레드가 동시에 list를 쓴다)
	public MyThreadA(String name, List<String> list) {
		super(name);
		this.list = list;
	}

	@Override
	public void run() {
		while(!stop) {
			synchronized (list) {
				for(String s:list) {
					System.out.println(s + "읽기 완료!!!");
				}
				
			}
		}
		System.out.println("A-Thread 종료");
	}
	
	
}
