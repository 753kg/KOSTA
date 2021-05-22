package com.kosta.day05;

public class Employee { //extends Object생략되어있다. 
	private String id;
	private String name;
	private int baseSalary;
	
	//생성자
	public Employee(String id, String name, int baseSalary) {
		super();
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
	}
	//getter(읽기목적)/setter(값수정목적)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	double getSalary(double bonus) {
		double salary;
		salary = baseSalary + baseSalary * bonus ; 
		return salary;
	}
	//toString()메서드는 Object class의 이미 정의되어있다.
	//Employee class가 상속받았다. 
	//Employee class는 Object class의 toString()메서드 갖는다.
	//만약에 toString()메서드 작성한다면 재정의를 의미한다.(덮어쓰기)
	//재정의 조건 : 시그니처가 같아야한다. 
	//접근제한자가 같어나 더 넓어지는 것은 가능하지만 좁아지는 것은 불가하다. 
	public String toString() {
		return name + "(" + id + ") 사원의 기본급은 "
				+ baseSalary
				+ "원 입니다.";
	}
	
}


