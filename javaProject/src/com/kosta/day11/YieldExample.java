package com.kosta.day11;

public class YieldExample {

	public static void main(String[] args) {
		ThreadA t1 = new ThreadA();
		ThreadB t2 = new ThreadB();
		
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.work = false;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.work = true;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.stop = true;
		t2.stop = true;
		
	}

}
