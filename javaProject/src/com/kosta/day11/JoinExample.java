package com.kosta.day11;

public class JoinExample {

	public static void main(String[] args) {
		
		SumThread t = new SumThread();
		t.start();
		
		// t가 끝날때까지 main 멈추고 기다리기
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("1~100까지 합계:" + t.getSum());
		
		
	}

}
