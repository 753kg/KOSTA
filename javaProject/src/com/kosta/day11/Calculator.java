package com.kosta.day11;

public class Calculator {
	// 공유 객체
	private int memory;

	public int getMemory() {
		return memory;
	}

	// 동기화 메서드... 하나의 쓰레드가 점유하는 동안에 다른 쓰레드는 못들어옴
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		
		try {
			Thread.sleep(2000);		// 2초
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " ==> " + this.memory);
	}
	
	
}
