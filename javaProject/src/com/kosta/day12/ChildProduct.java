package com.kosta.day12;

public class ChildProduct<T, M, C> extends Product<T, M>{
	private C company;
	
	public ChildProduct(T t, M m, int price, C company) {
		super(t, m, price);
		this.company = company;
	}

	public C getCompany() {
		return company;
	}

	public void setCompany(C company) {
		this.company = company;
	}
	
	
}
