package com.kosta.day09;

public class ExceptionTest {

	public static void main(String[] args) {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();
		method8();
		System.out.println("main END");
	}

	// 오류가 발생하지 않도록 업무로직 중간에 값을 체크
	// 업무로직과 오류처리로직이 섞인다... 좋은코드아니다
	// Exception 사용 : 업무로직, 오류처리로직 분리한다.
	//				   오류발생시 "프로그램이 비정상적으로 종료되지않게"하려고
	private static void method1() {
		int a = 10;
		int b = 0;
		if(b == 0) {
			System.out.println("0으로 나눌 수 없다.");
			return;		// 호출한 곳으로 돌아간다.
		}
		System.out.println(a/b);
	}
	
	private static void method2() {
		int a = 10;
		int b = 0;
		try {	// 예외발생 가능성이있는 문장들, 업무로직
			System.out.println(a/b);			
		} catch(ArithmeticException e) { // 예외처리로직
			System.out.println("0으로 나눌 수 없다!!");
		}
	}
	
	private static void method3() {
		// Exception 종류 : 컴파일체크예외, 실행예외(Runtime Exception)
		// 동적 로딩이란 : 어떠한 클래스가 로딩 될지 모르기 때문에 Class 클래스의 forName()함수를 이용해서 해당 클래스를 메모리로 로드 하는 것입니다.
		try {
			Class.forName("com.kosta.day09.Button");	// Button을 메모리에 올려라
			System.out.println("load 성공");
		} catch (ClassNotFoundException e) {	// 클래스가 없을 수도 있다는 오류
			System.out.println("class load 실패");
			e.printStackTrace();	// 예외사항이 문자열로 출력됨
		}	
		
	}
	
	private static void method4() {
		try {
			String s = "자바";
			System.out.println(s.length() + "글자");
			s = null;
			System.out.println(s.length() + "글자");	
		} catch(NullPointerException e) {
			System.out.println("null은 참조 불가");
		}
	}
	
	private static void method5() {
		int[] arr = new int[5];		// 자동으로 0으로 초기화
		try {			
			System.out.println(arr[5]);
		} catch(ArrayIndexOutOfBoundsException e) {	// 예외 객체가 e로 들어옴
			System.out.println(e.getMessage());	// 에러 메시지 출력
			//e.printStackTrace();	// 예외가 나는 과정을 다 보여줌
		}
	}
	
	private static void method6() {
		String s = new String("자바");
		Object s2 = new String("자바");	// 자동형변환
		try {
			String s3 = (String)s2;		// Object는 String에 못들어감, 강제형변환
			Integer i = (Integer)s2;	// s2의 본래 인스턴스는 String이라 Integer로 형변환 불가능
		} catch(ClassCastException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void method7() {
		// 예외처리
		// 1) 내가한다. : try-catch-finally
		// 2) 떠넘긴다. : throws
		try {
			System.out.println("예외가 발생할 가능성이 있는 문장들");
			int a = 10/10;
			System.out.println("이 문장은 수행이 안된다.");
		} catch (Exception e) {
			// ArithmeticException -> RuntimeException -> Exception
			System.out.println("예외 발생시 수행한다.");
		} finally {
			// 자원 반납 코드를 한다 => DB닫기, File닫기
			System.out.println("항상 수행. 예외 발생 여부에 관계 없음. 생략 가능");
		}
	}
	
	
	private static void method8() {
		try {
			int a = 10 / 0;
			int[] arr = new int[5];
			arr[4] = 100;
			String s = "자바";
			System.out.println(s.length());		// 문자열의 길이를 구해라
			Object obj = new String("java");
			Integer i = (Integer)obj;
			
			// 다중 catch 문장
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없다.");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("index 범위를 벗어났다.");
		} catch(NullPointerException e) {
			System.out.println("null 참조 불가");
		} catch(ClassCastException e) {
			System.out.println("형변환 오류");
		} catch(Exception e) {
			// 상위 Exception은 마지막에 기술한다.
			System.out.println("기타 예외" + e.getMessage());
		} finally {
			System.out.println("반드시 수행한다.");
		}
	}
	
}
