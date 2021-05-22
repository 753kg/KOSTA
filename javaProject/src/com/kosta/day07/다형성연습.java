package com.kosta.day07;

public class 다형성연습 {

	public static void main(String[] args) {
		
		Account acc = new Account("111", "hong", 1000);
		// Account를 상속받은 자식 class들
		CheckingAccount acc2 = new CheckingAccount("222", "kim", 2000, "7878");
		CreditLineAccount acc3 = new CreditLineAccount("333", "park", 3000, 500);
		BonusAccount acc4 = new BonusAccount("444", "lee", 4000, 100);
		
		// 계좌 출력
		accountDisplay(acc);
		accountDisplay(acc2);
		accountDisplay(acc3);
		accountDisplay(acc4);

	}
	
	// 부모는 자식을 다 수용한다.
	public static void accountDisplay(Account acc) {
		System.out.println(acc);
		System.out.println("-------------------------");
	}

}
