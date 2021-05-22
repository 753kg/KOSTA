package com.kosta.day14;

import java.util.List;

public class MyThreadB extends Thread{
	
	List<String> list;
	
	public MyThreadB(String name, List<String> list) {
		super(name);
		this.list = list;
	}
	
	@Override
	public void run() {
		for(long i=0; i<=100; i++) {	// true : 계속
			list.add(i + "추가");
			//System.out.println(i + " 추가...");
		}
	}

}
