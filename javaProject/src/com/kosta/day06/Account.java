package com.kosta.day06;

public class Account {
	
	private int balance;
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		if(balance >= MIN_BALANCE && balance <= MAX_BALANCE) {
			this.balance = balance;
		}
		/*
		if(balance < MIN_BALANCE || balance > MAX_BALANCE) {
			return;		//생략가능
		}
		else {			
			this.balance = balance;
		}*/
	}
	
	
	
}
