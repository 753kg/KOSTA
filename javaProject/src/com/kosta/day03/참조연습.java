package com.kosta.day03;

public class 참조연습 {

	public static void main(String[] args) {
		//sample();
//		sample2();
		sample3();
	}

	private static void sample3() {
		// 참조형은 일반적으로 null로 초기화함
		// null : 정의된 바가 없다. 참조하는 값이 없다.
		String s = null;
		System.out.println(s);
		System.out.println(s == null);
		s = "이것이 자바다";
		System.out.println(s.length());	//문자열길이구하기
		
	}

	private static void sample2() {
		//지역변수는 반드시 초기화하고 사용한다.
		int a = 0;
		double d = 0.0;
		boolean b = false;
		char c = ' ';
		System.out.println(a + d);
		System.out.println(b);
		System.out.println(c);
		
	}

	private static void sample() {
		// 기본형
		int a=10;
		int b=10;
		System.out.println(a == b);
		System.out.println(++a == ++b ? "같다":"다르다");
		
		// 참조형은 주소를 비교
		String s1 = "홍길동";
		String s2 = "홍길동";
		String s3 = new String("홍길동님");
		String s4 = new String("홍길동님");
		
		System.out.println(s1 == s2);	//true. 주소가 같다.
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		
		s1 = s1 + "님";	// 문자열은 절대 변하지 않음. 변경 불가
						// "홍길동님"을 만들어서 주소를 가리킴.
		s2 = s2 + "님";
		
		System.out.println(s1 == s2);	//false. 주소가 다르다.
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		
		// 내용이 같은지 보려면
		System.out.println(s1.equals(s4)?"내용이같다":"내용이다르다"); // true
		
		
		System.out.println(s3 == s4);	//false
		
		// 주소 보기
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
	
		
	}

}