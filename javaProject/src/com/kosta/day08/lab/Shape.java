package com.kosta.day08.lab;

public abstract class Shape {
	// 변수는 private으로 막는게 좋다.
	private int numSides;		// 변의 수
	
	public Shape(int numSides){
		this.numSides = numSides;
	}
	
	// getter는 return값이 있다.
	// 외부에서 접근해야하니까 public
	public int getNumSides(){
		return numSides;
	}
	
	// abstract : 정의는 있고 구현은 없다.
	// 외부에서 접근해서 재정의해야하니까 public
	public abstract double getArea();			// 넓이
	public abstract double getPerimeter();		// 둘레
}
