package com.kosta.day08;

public class MyClassTest {

	public static void main(String[] args) {
		
		// RemoteControl 타입이라 RermoteControl을 구현한 클래스 모두 들어갈 수 있다.
		MyClass myClass = new MyClass(new Television());
		MyClass myClass2 = new MyClass(new Audio());
		MyClass myClass3 = new MyClass(new SmartTelevision());
		
		myClass.methodA();	// Audio로 바뀜
		myClass2.methodA();
		myClass3.methodA();
		
		myClass.setRC(new SmartTelevision());
		myClass2.setRC(new SmartTelevision());
		myClass3.setRC(new SmartTelevision());
		
		
		System.out.println(myClass);
		System.out.println(myClass2);
		System.out.println(myClass3);
		

	}

}
