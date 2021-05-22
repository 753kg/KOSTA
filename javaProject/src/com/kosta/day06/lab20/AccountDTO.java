package com.kosta.day06.lab20;
/**
 * 
 * @author KOSTA
 * DTO(Data Transfer Object) : 데이터 전송 목적
 */

public class AccountDTO {
	private String ano;
	private String owner;
	private int balance;
	
	public AccountDTO(String ano, String owner, int balance) {
		super();
		this.ano = ano;
		this.owner = owner;
		this.balance = balance;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	// @Override : 컴파일러에게 전달
	// 재정의가 맞는지 체크한다.
	@Override
	public String toString() {
		return "Account [ano=" + ano + ", owner=" + owner + ", balance=" + balance + "]";
	}
	
}
