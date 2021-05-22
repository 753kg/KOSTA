package com.kosta.day07;

public class AccountTest2 {

	public static void main(String[] args) {
		// 계좌 4개 생성 : Account, CreditLineAccount, BonusAccount, CheckingAccount
		Account[] accounts = new Account[4];
		makeAccount(accounts); 
		printAccount(accounts);
		System.out.println("-------Casting Account--------");
		castingAccount(accounts);

	}

	private static void castingAccount(Account[] accounts) {
		for(Account acc:accounts) {
			if(acc instanceof CheckingAccount) {
				// new CheckingAccount() -> Account -> CheckingAccount
				CheckingAccount cc = (CheckingAccount)acc;
				System.out.println(cc.getCardNo());
				int amount = cc.pay("8888", 100);			// acc.pay()로는 접근 불가능
				System.out.println(amount);
			}else if(acc instanceof BonusAccount) {
				BonusAccount bb = (BonusAccount)acc;
				acc.deposit(1000);	// 재정의된 메서드가 수행. 부모를 통해서 자식 메서드에 접근
				bb.deposit(2000);	// 자식의 메서드에 접근
				System.out.println(bb.bonusPoint + "포인트");
			}
		}
		
	}

	private static void printAccount(Account[] accounts) {
		for(Account acc:accounts) {			// 자동형변환
			System.out.println(acc);		// 재정의된 toString이 호출됨
			System.out.println("---------------------------------");
		}
	}

	private static void makeAccount(Account[] accounts) {
		// 자동형변환 : 부모타입 = 자식객체
		accounts[0] = new Account("111", "kim", 1000);
		accounts[1] = new CreditLineAccount("222", "park", 2000, 500);
		accounts[2] = new BonusAccount("333", "lee", 3000, 300);
		accounts[3] = new CheckingAccount("444", "jang", 4000, "8888");
		
		
	}

}
