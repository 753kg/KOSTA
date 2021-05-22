package com.kosta.day11;

public class ShareAccount {
	Account lee;
	Account sung;
	
	public ShareAccount(Account lee, Account sung) {
		super();
		this.lee = lee;
		this.sung = sung;
	}
	
	// 이체 (lee -> sung)
	public synchronized void transfer() {
		int amount = lee.withdraw(100);		// 출금
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sung.deposit(amount);				// 입금
		System.out.println(amount + "를 이체 (lee -> sung)");
	}
	
	// 잔액 얻기
	public int getTotal() {
		synchronized (this) {			
			return lee.balance + sung.balance;
		}
	}
}
