package com.kosta.day09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//예외발생
//1) 자동발생... 실행시, 컴파일시
//2) 강제로 예외를 발생시킴 ... throw 예외이름
//예외처리
//1) 내가한다. : try-catch-finally, try만 읽으면 됨
//2) 나를 호출한 곳으로 떠넘긴다. : throws
public class ExceptionTest4 {

	public static void main(String[] args) {	// 던지면 프로그램 중단됨
		try {
			method6();
		} catch (MyException e) {
			System.out.println(e.getMessage());
			System.out.println(e.message2);
			e.print();
		}
	}
	
	private static void method6() throws MyException {
		System.out.println("method6() start");
		
		int score = 70;
		if(score <= 70) throw new MyException("70점 이상만 가능하다.");	
		
		System.out.println("method6() end");
	}

	private static void method5() throws IOException{	//RuntimeException은 컴파일 시엔 에러 발생 안함
		int score = 70;
		if(score <= 70) throw new IOException("70점 이상만 가능하다.");	
		System.out.println("method5 end");	// throw하면 여기까지 안내려오고 함수 나감
	}

	private static void method4() {
		int score = 70;
		try {	// 예외를 일으키고 예외처리를 함
			if(score <= 70) throw new RuntimeException("70점 이상만 가능하다.");	
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("method4 end");	// 예외발생해도 예외처리를했기때문에 실행됨
	}

	private static void method3(){
		int score = 70;
		if(score <= 70) throw new RuntimeException("70점 이상만 가능하다.");	
		// 예외를 발생시키고, 처리는 하지않음 -> 프로그램 중단됨
		System.out.println("method3 end");	// 예외발생하면 실행안됨 예외처리를안해서
	}

	private static void method2() {
		try {
			FileReader fr = new FileReader("aa.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void method1() {
		int a = 10 / 0;
	}

}
