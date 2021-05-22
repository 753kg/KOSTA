package com.kosta.day07;

public class CreditLineAccount extends Account {
	private int creditLine;

	public CreditLineAccount(String accNo, String ownerName, int balance, int creditLine) {
		// 부모의 생성자를 명시적으로 호출
		super(accNo, ownerName, balance);
		// 자신의 필드는 직접 초기화
		this.creditLine = creditLine;
	}
	
	// 재정의(Override): 부모의 메서드를 수정하겠다.
	// 메서드의 선언부가 같아야한다. (return타입, method이름, 파라미터)
	// Modifier : 같거나 더 넓어져야함
	
	public int withdraw(int amount) {
		int b = getBalance();
		if(b + creditLine  < amount) {
			System.out.println("잔액부족합니다.");
			return 0;
		}
		setBalance(b - amount);
		return amount;
	}
		
	public int getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(int creditLine) {
		this.creditLine = creditLine;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreditLineAccount [creditLine=").append(creditLine).append(", getAccNo()=").append(getAccNo())
				.append(", getOwnerName()=").append(getOwnerName()).append(", getBalance()=").append(getBalance())
				.append(", toString()=").append(super.toString()).append(", getClass()=").append(getClass())
				.append(", hashCode()=").append(hashCode()).append("]");
		return builder.toString();
	}

	
	
	
	
	
	
}
