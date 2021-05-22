package com.kosta.day11;

// 다른 클래스를 상속받고있지않아서 Thread 상속이 가능하다.
// run() 메서드를 구현해야 멀티스레드로 사용할 수 있다.
public class AlphabetThread extends Thread{

	@Override
	public void run() {
		for(char c = 'A'; c <= 'Z'; c++) {
			System.out.println(getName() + " -> " +c);
			try {
				sleep(500);	//0.5초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
