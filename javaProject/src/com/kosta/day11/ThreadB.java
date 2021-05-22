package com.kosta.day11;

public class ThreadB extends Thread{
	// 플래그
	public boolean stop = false;
	public boolean work = true;

	@Override
	public void run() {
		while(!stop) {	
			if(work) {	//true
				System.out.println(getClass().getSimpleName() + "작업내용");
			}else {
				yield();	// 다른 스레드에게 양보
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(getClass().getSimpleName() + "작업 종료");
	}
	
}
