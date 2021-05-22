package com.kosta.day11;

public class BathExample {

	public static void main(String[] args) {
		BathRoom room = new BathRoom();
		
		BathThread t1 = new BathThread(room, "김씨");
		BathThread t2 = new BathThread(room, "박씨");
		BathThread t3 = new BathThread(room, "양씨");
		BathThread t4 = new BathThread(room, "정씨");
		
		t1.start();		// thread 실행은 반드시 start() -> run() 자동실행
		t2.start();		// run 을 호출하면 쓰레드가 아님
		t3.start();
		t4.start();
	}

}
