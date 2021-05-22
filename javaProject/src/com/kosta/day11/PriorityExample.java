package com.kosta.day11;

public class PriorityExample {

	public static void main(String[] args) {
		for(int i=0; i<9; i++) {
			Thread t = new AlphabetThread();
			if(i % 2 == 0) {
				t.setPriority(Thread.MAX_PRIORITY);
			}else {
				t.setPriority(Thread.MIN_PRIORITY);
			}
			t.start();
		}
	}

}
