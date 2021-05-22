package com.kosta.day11;

public class User1 extends Thread{
	
	private Calculator cal;
	
	public User1(String name, Calculator cal) {
		setName(name);	// Thread 이름 바꾸기
		this.cal = cal;
	}

	@Override
	public void run() {
		cal.setMemory(100);
	}
	
	
}
