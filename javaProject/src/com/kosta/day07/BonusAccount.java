package com.kosta.day07;

public class BonusAccount extends Account {
	int bonusPoint;

	public BonusAccount(String accNo, String ownerName, int balance, int bonusPoint) {
		super(accNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}

	@Override
	public void deposit(int amount) {
		// 부모의 메서드 호출
		super.deposit(amount);
		bonusPoint = (int) (bonusPoint + amount*0.001);
		//bonusPoint += amount * 0.001;		// 복합대입연산자는 자동형변환됨
	}

	@Override
	public String toString() {
		// String : 고정문자열 ...변경불가, + 연산자로 연결가능
		// StringBuilder : 가변문자열 ...변경가능, + 연산자 불가, append 사용
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("\nBonusAccount [bonusPoint=").append(bonusPoint).append("]");
		return builder.toString();
	}
	
	
}
