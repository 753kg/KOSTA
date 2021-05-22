package com.kosta.day11;

public class BeepPrintExample {

	public static void main(String[] args) {
		
		// Thread에 넣어도 되고 BeepThread에 넣어도된다.
		BeepThread t1 = new BeepThread("BeepThread");
		t1.start();
		
		for(int i=1; i<=5; i++) {
			System.out.println(Thread.currentThread().getName()+"...띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
