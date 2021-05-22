package com.kosta.day08;

// interface => 상수 + 추상메서드
// abstract class => 일반class(필드,생성자,메서드) + 추상메서드
public interface Volume {
	// interface가 가질 수 있는 것들
	// 1. 상수(대문자로)
	public static final String TITLE = "Volume";
	String TITLE2 = "Volume2";		//public static final 생략해도 상수
	
	// 2. 추상메서드
	void volumeUp(int level);
	void volumeDown(int level);
	

	// 3. default method (8버전에서 추가됨)
	// interface에 추상메서드가 추가되면 implement받은 class들에 영향을 미친다.
	// 즉, "추상메서드는 반드시 구현한다"
	// 구현한 class에서 재정의가 가능하다.
	default void close() {
		System.out.println("Volume interface를 구현한 모든 class에 적용된다.");
		// implement받은 class들에서 구현하지 않아도 된다.
	}
	
	// 4. static method (8버전에서 추가됨)
	static void volumeInfo() {
		System.out.println("Volume interface의 method");
	}
}
