package com.kosta.day13;

@FunctionalInterface
interface ThisTestInterface {
	void test();
}

public class UsingThis {
	int a = 10;
	String java = "outter java";
	
	
	class Inner {
		int b = 20;
		String java = "inner java";

		
		void method(int score) {		// 파라미터도 local변수
			String grade = "A학점";		// local변수
			
//			score = 80;		// local class에서 사용할 변수는 수정 불가능. "final 특성"
//			grade = "B학점";	// 수정하면 내부 class에서 사용 불가능
							// final은 생략 가능
			
			// 익명 구현 클래스를 람다식으로 표현한 것이다.
			ThisTestInterface kim = () -> {
				System.out.println("outter변수접근:" + a);
				System.out.println("outter변수접근:" + UsingThis.this.a);
				
				System.out.println("inner변수접근:" + b);
				System.out.println("inner변수접근:" + this.b);
				
				System.out.println(java);
				System.out.println(this.java);
				System.out.println(UsingThis.this.java);
				
//				score = 88;			// 내부에서도 수정 불가능.
//				grade = "C학점";
				System.out.println("score=" + score);
				System.out.println("grade=" + grade);
				
			};
			
			kim.test();
			
		}
		
	}
	
	public static void main(String[] args) {
		UsingThis.Inner inn = new UsingThis().new Inner();
		inn.method(90);
	}
	
}
