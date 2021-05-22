package com.kosta.day04;

public class Account19 {
	
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	
	private int balance;
	
	void setBalance(int balance) {
		if(balance < MIN_BALANCE || balance > MAX_BALANCE) {
			return;
		}else {
			this.balance = balance;
		}
	}
	
	int getBalance() {
		return this.balance;
	}
	

}
