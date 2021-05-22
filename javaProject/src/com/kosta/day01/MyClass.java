package com.kosta.day01;

/**
 * document 주석
 * @author KOSTA
 *
 */

/* 
 1. MyClass.java 생성
 2. javac.exe로 컴파일 (jdk\bin 안에 있다)
 	>javac MyClass.java
 3. .class 파일이 생성됨
 4. JVM(자바가상머신..OS마다 다르다)이 java.exe가 .class를 실행
 5. >java MyClass ===> main 시작된다.
 */

// public class는 .java파일 이름과 같은 클래스에만 가능
// 하나의 .java 에는 여러 클래스가 있을 수 있음.
// public class는 반드시 하나만 가능.
// main method가 없으면 자체 실행 불가
public class MyClass {
	
	public static void test() {
		System.out.println("MyClass의 test");
	}
	
	public static void main(String[] args) {
		
		ATest a = new ATest();	// 객체 생성
		a.method1();
		
		test();
	}
}

// MyClass 에서만 쓰려고 만든 클래스
class ATest{

	public void method1() {
		System.out.println("ATest의 method1");
		
	}
	
}

class BClass{
	
}