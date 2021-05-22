package com.kosta.day11;

public class MultiThreadProcessTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " 시작");
		
		// Multi Thread 사용하기
		// 1. Thread 상속받은 Class 이용... 대문자 출력
		// 2. Runnable 인터페이스를 구현한 Class 이용... 소문자 출력
		
		Thread t1 = new AlphabetThread();
		Runnable r = new AlphabetThread2();		// ==> thread가 아님
		Thread t2 = new Thread(r);
		Thread t3 = new AlphabetThread();

		t1.setName("대문자1");
		t2.setName("소문자");
		t3.setName("대문자2");
		
		
		t1.start();		// run()이 자동실행
		t2.start();
		t3.start();
		
		// main... 숫자 출력
		for(int i = 1; i <= 26; i++) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println(Thread.currentThread().getName() + " 끝");
	}

}
