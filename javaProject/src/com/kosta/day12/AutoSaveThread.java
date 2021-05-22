package com.kosta.day12;

public class AutoSaveThread extends Thread{
	
	public AutoSaveThread(String name) {
		setName(name);
	}
	
	public void save() {
		System.out.println("자동 저장...");
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				save();
				sleep(1000);
			}
		}catch(InterruptedException e) {	// interrupt 메서드 --> InterruptedException 발생
			System.out.println("InterruptedException...");
		}
		
	}
}
