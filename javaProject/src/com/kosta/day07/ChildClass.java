package com.kosta.day07;

public class ChildClass extends ParentClass {
	private String name;
	
	public ChildClass() {
		//this()가 있어서 super()호출 안된다.
		this("홍길동");
		System.out.println("4. Child() call");
	}
	
	public ChildClass(String name) {
		//super(); 호출
		this.name = name;
		System.out.println("3. Child(String name) call");
	}
}
