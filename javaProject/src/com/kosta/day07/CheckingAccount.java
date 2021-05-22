package com.kosta.day07;

public class CheckingAccount extends Account {
	// 1. Field
	private String cardNo;
	
	// 2. Constructor
	public CheckingAccount() {
		
	}
	
	public CheckingAccount(String accNo, String ownerName, int balance, String cardNo) {
		super(accNo, ownerName, balance);	// 부모(Account)가 먼저 생성됨
		this.cardNo = cardNo;
//		private이라 불가능 -> super 쓰기
//		this.accNo = accNo;
//		this.ownerName = ownerName;
//		this.balance = balance;
	}

	// 3. Method
	public int pay(String cardNo, int amount) {
		if(!cardNo.equals(this.cardNo))	{	//내가 가진 카드번호와 같지 않으면
			System.out.println("카드번호 오류..... 지불 불가");
			return 0;
		}
		return withdraw(amount);	// 상속받은 메서드
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo, int creditLine) {
		this.cardNo = cardNo;
	}

	@Override
	public String toString() {
		// 부모의 메서드 호출
		String s = "부모: " + super.toString();
		// 재정의 로직
		return s + " \n자식: CheckingAccount [cardNo=" + cardNo + "]";
	}

	
	
	
}
