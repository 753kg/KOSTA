package com.kosta.day11;

public class MovieThread extends Thread{

	@Override
	public void run() {
		for(int i=0; i<3; i++) {
			System.out.println("동영상을 재생합니다.");
		}
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
