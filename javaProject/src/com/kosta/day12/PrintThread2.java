package com.kosta.day12;

public class PrintThread2 extends Thread{
	
	public PrintThread2() {
		setName(getClass().getSimpleName()+" 쓰레드");
		
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println(getName() + " 작업 실행");
				sleep(1);	// 일시정지 상태를 만들어야 interrupt 가능
			}
		}catch(InterruptedException e) {
			System.out.println("다른 쓰레드가 인터럽트 걸어서 나의 쓰레드 종료");
		}
		System.out.println(getName() + " 자원 정리...");
		System.out.println(getName() + " 실행 종료!!!");
	}

	
}
