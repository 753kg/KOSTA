package com.kosta.day08;

public class InnerClassTest {

	public static void main(String[] args) {
//		static int a = 1;	// static은 class변수라서 main 안에 못씀
		
//		useInstanceInnerClass();
//		useStaticInnerClass();
		useLocalInnerClass();

	}

	private static void useLocalInnerClass() {
		OuterClass outter = new OuterClass();
		outter.test("가산역", "KOSTA");
		
	}

	private static void useStaticInnerClass() {
		// 2. static inner class 사용하기
		// static 필드, 메소드는 객체생성없이 접근가능
		System.out.println(OuterClass.StaticInnerClass.grade);
		OuterClass.StaticInnerClass.printGrade();
													// static은 바로접근 가능
		OuterClass.StaticInnerClass staticClass = new OuterClass.StaticInnerClass();
		System.out.println(staticClass.score);
		staticClass.printScore();
	}

	private static void useInstanceInnerClass() {
		// 1. instance inner class 사용하기
		// 1) 객체참조변수선언
		OuterClass.InnerClass inner;
		// 2) 객체 생성
				// OuterClass를 new하고 InnerClass를 new
		inner = new OuterClass().new InnerClass();
		// 3. 객체 사용
		System.out.println(inner.a);
		inner.test();
	}

}
