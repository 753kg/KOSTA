package com.kosta.day06.lab20;
/**
 * 
 * @author KOSTA
 * View : Account 정보 display한다.
 * 출력. 어떻게 보여줄것인지
 * static ==> AccountView.method() 사용
 */

public class AccountView {
	public static void print(AccountDTO account) {
		System.out.println("==계좌정보 출력==");
		System.out.println(account);
	}
	
	public static void print(AccountDTO[] accounts) {
		System.out.println("==계좌정보 여러건 출력==");
		for(AccountDTO a:accounts) {
			if(a == null) break;
			System.out.println(a);
		}
	}
	
	public static void print(String message) {
		System.out.println(message);
	}
}
