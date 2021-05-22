package com.kosta.day11;

public class SynchronizedTest {

	public static void main(String[] args) {
		
		Account sung = new Account("112", "성춘향", 1000);
		Account lee = new Account("223", "이몽룡", 2000);
		
		ShareAccount sa = new ShareAccount(lee, sung);
		
		Thread t1 = new TransferThread(sa);
		Thread t2 = new PrintThread(sa);
		
		t1.start();
		t2.start();
	}

}
