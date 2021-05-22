package com.kosta.day05;

public class AccountTest2 {

	public static void main(String[] args) {
		//계좌가 여러개있다.
		//1.배열생성 
		Account[] arr = new Account[3];
		//2.객체생성
		for(int i=0; i<arr.length; i++) {
			arr[i] = new Account(i+1+"계좌");
		}
		//3.객체접근 
		for(Account acc:arr) {
			acc.save(10);
		}
		
		

	}

}