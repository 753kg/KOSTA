package com.kosta.day11;

// 다른 클래스를 상속받고있으면 Thread 상속이 불가능.
// run() 메서드를 구현해야 멀티스레드로 사용할 수 있다.
public class AlphabetThread2 extends Object implements Runnable{

	@Override
	public void run() {
		System.out.println("이름:" + Thread.currentThread().getName());
		for(char c = 'a'; c <= 'z'; c++) {
			System.out.println(Thread.currentThread().getName() + "-> " + c);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
}
