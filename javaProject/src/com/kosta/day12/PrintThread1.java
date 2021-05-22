package com.kosta.day12;

public class PrintThread1 extends Thread{
	private boolean stop; 	// boolean은 false로 자동초기화

	public PrintThread1() {
		setName(getClass().getSimpleName()+" 쓰레드");
		
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println(getName() + " 작업 실행");
		}
		System.out.println(getName() + " 자원 정리...");
		System.out.println(getName() + " 실행 종료!!!");
	}

	
}
