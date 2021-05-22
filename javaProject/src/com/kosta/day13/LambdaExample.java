package com.kosta.day13;

// 1. interface 구현한 class 만들기
class MyRunnableImpl implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<=10; i++) {
			System.out.println(i);
		}
	}
}

@FunctionalInterface	//람다 표현식으로 사용 가능한지 컴파일 단계에서 체크하는 어노테이션.
interface MyInterface {
	// public abstract 생략 가능
	void myFunction();
}

// 방법1. 구현 class 만들기
class MyInterfaceImpl implements MyInterface{

	@Override
	public void myFunction() {
		System.out.println("1. interface 구현 class");
	}
	
}

public class LambdaExample {

	public static void main(String[] args) {
		method6();
	}

	private static void method6() {
		// 방법3. Lambda
		MyInterface a = () -> 
			System.out.println("3. Lambda 표현식 사용");	// 한문장밖에없으면 {} 생략 가능
		a.myFunction();
	}

	private static void method5() {
		// 방법2. 익명 class
		(new MyInterface() {
			@Override
			public void myFunction() {
				System.out.println("2. 익명 class");
			}
		}).myFunction();
	}

	private static void method4() {
		MyInterface a = new MyInterfaceImpl();
		a.myFunction();
	}

	private static void method3() {
		// lambda 표현식
		// 인터페이스에 추상메서드가 "하나만" 있는 것만 가능
		Runnable a = () -> {
			for(int i=11; i<=15; i++) {
				System.out.println(i);
			}
		};
		Thread t = new Thread(a);
		t.start();
		System.out.println("method3() END");
	}

	private static void method2() {
		// 익명class 사용
		Runnable a = new Runnable() {
			@Override
			public void run() {
				for(int i=11; i<=15; i++) {
					System.out.println(i);
				}
			}
		};
		Thread t = new Thread(a);
		t.start();
		System.out.println("method2() END");
	}

	private static void method1() {
		MyRunnableImpl a = new MyRunnableImpl();
		Thread t = new Thread(a);
		t.start();
		System.out.println("method1() END");
	}

}
