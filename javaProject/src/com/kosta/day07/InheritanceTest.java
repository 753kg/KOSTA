package com.kosta.day07;

class Parent{
	int a = 10;
	
//	Parent(){
//		System.out.println("부모의 생성자가 먼저 수행된다.");
//	}
	
	Parent(int i){
		System.out.println("arg1 부모의 생성자가 먼저 수행된다.");
	}
	
	void method1() {
		System.out.println("Parent가 만든 method1");
	}
}

class Child extends Parent{
	int b = 20;
	String a = "자바";	// 재정의, 덮어쓰기
	
	Child(String s){
//		super();		// default 호출
		super(11);		// 명시적 호출
		System.out.println("arg가 1개있는 생성자: "+s);
	}
	
	// 추가한 메서드
	void method2() {
		System.out.println("Child가 만든 method2");	
	}
	// 재정의, 덮어쓰기, 부모거는 안함
	void method1() {
		// 부모메서드 호출
		super.method1();
		System.out.println("Child가 재정의한 method1");
	}
}

public class InheritanceTest {

	public static void main(String[] args) {
		Child c = new Child("자식");
		System.out.println(c.a + c.b);
		c.method1();
		c.method2();

	}

}
