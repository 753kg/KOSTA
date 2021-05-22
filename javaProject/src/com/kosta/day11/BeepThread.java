package com.kosta.day11;

import java.awt.Toolkit;

// run() 재정의하기 !!!
public class BeepThread extends Thread{
	
	public BeepThread(String name) {
		setName(name);
	}

	@Override
	public void run() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();	// return Toolkit
		
		for(int i=1; i<=5; i++) {
			toolkit.beep();
			System.out.println(getName()+"...");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
