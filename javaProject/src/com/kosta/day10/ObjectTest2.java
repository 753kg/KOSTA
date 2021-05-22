package com.kosta.day10;

import java.util.Objects;

public class ObjectTest2 {

	public static void main(String[] args) {
		
		// System.out : 모니터에 출력
		long start1 = System.currentTimeMillis();	// 현재시간
		long start2 = System.nanoTime();
		
		for(int i=0; i<1000000000; i++) {
			
		}
		long end1 = System.currentTimeMillis();
		long end2 = System.nanoTime();
		System.out.println("=====걸린시간=====");
		System.out.println(end1 - start1 + " 밀리세컨드");
		System.out.println(end2 - start2 + " 나노타임");
		
		
		if(method2()) {
			System.out.println("null이군요");
			// 함수빠지기 ==> return ==> main나감 = 프로그램 종료
			// 프로그램종료
			System.exit(0);	// 일반적으로 정상종료의미 : 0
		}else {
			System.out.println("null이 아니다.");
		}
		System.out.println("main end");
	}

	private static boolean method2() {
		Book b1 = null;
		System.out.println(b1 == null);
		System.out.println(Objects.isNull(b1));
		return Objects.isNull(b1);
	}

	private static void method1() {
		Book b1 = new Book("자바다", 2000, true);
		Book b2 = b1;
		
		// Objects.equals : Book 객체에서 재정의한 equals 수행
		boolean result = Objects.equals(b1, b2);	
		System.out.println(result);
	}

}
