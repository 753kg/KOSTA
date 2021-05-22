package com.kosta.day11;

public class BathRoom {
	boolean first = true;
	// synchronized : 락을 건다, 임계 영역을 준다.
	public void use(String name) {
		
		synchronized(this) {
			if(first && name.equals("박씨")) {	// 김씨가 제일 먼저 시작될 일은 절대로 없음
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			first = false;
			System.out.println("=====================");
			System.out.println(name + " 입장");
			System.out.println(name + " 사용");
			System.out.println(name + " 퇴장");
			notifyAll();
		}
	}
	
}
