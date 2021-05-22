package com.kosta.day09;

import java.util.HashSet;
import java.util.Set;

public class ObjectTest {

	public static void main(String[] args) {
		method7();
	}

	private static void method7() {
		Car car1 = new Car("그랜져", 4000);
		Car car2 = new Car("그랜져", 4000);
		System.out.println(car1.hashCode());
		System.out.println(car2.hashCode());
		
		Set<Car> shopping = new HashSet<>();
		shopping.add(car1);
		shopping.add(car2);		// 중복되면 하나만 나옴
		
		for(Car car:shopping) {
			System.out.println(car.model);
		}
		// hashcode 재정의해서 모델,가격 같으면 같은 해시코드
	}

	private static void method6() {
		// Collection를 상속한 List, Set, Map
		// Set : key로 사용됨. 중복X, 순서X
		// Set 이라는 interface를 구현한 HashSet
		// HashSet은 Hashcode가 같아야 중복?????
		Set<String> shopping = new HashSet<>();
		shopping.add("사과");
		shopping.add("바나나");
		shopping.add("오렌지");
		shopping.add("사과");
		shopping.add("사과");
		for(String s:shopping) {
			System.out.println(s);		// 중복X
		}
		String s1 = new String("사과");
		String s2 = new String("사과");
		System.out.println(s1.hashCode());	// String은 내용이 같으면 같은 hashCode() 리턴 
		System.out.println(s2.hashCode());	// Object는 객체가 같아야 같은 hashCode.
	}

	private static void method5() {
		Car car1 = new Car("그랜져", 4000);
		Car car2 = new Car("그랜져", 4000);
		System.out.println(car1.hashCode());
		System.out.println(car2.hashCode());
	}

	private static void method4() {
		Car car1 = new Car("그랜져", 4000);
		Car car2 = new Car("그랜져", 4000);
		String car3 = new String("그랜져");
		System.out.println(car1 == car2);		// 주소비교
		System.out.println(car1.equals(car2));	// 주소비교 ==> 내용이 같다로 변경
		System.out.println(car1.equals(car3));
		// == : 재정의 불가능
		// equals : 재정의 가능
	}

	private static void method3() {
		// 2개의 주사위 같은지?
		Dice d1 = new Dice(8);
		Dice d2 = new Dice(8);
		System.out.println(d1 == d2);			// 주소비교
		System.out.println(d1.equals(d2));		// equals를 재정의 안하면 주소비교
	}

	private static void method2() {
		// Object의 equals는 주소를 비교
		// String이 equals를 재정의해서 값을 비교
		String s1 = new String("자바");
		String s2 = new String("자바");
		String s3 = "자바";
		String s4 = "자바";
		
		System.out.println(s1 == s2);	// 주소
		System.out.println(s3 == s4);
		System.out.println(s1.equals(s2));	// 내용
		System.out.println(s3.equals(s4));
	}

	private static void method1() {
		int a1 = 10;
		int a2 = 10;
		System.out.println(a1 == a2);	// 기본형은 값을 비교
		
		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(obj1 == obj2);		// 객체는 주소를 비교
		System.out.println(obj1.equals(obj2));	// Object는 주소를 비교
		
		Integer a3 = 10;
		Integer a4 = 10;
		Integer b1 = new Integer(10);
		Integer b2 = new Integer(10);
		System.out.println(a3 == a4);	// 주소를 비교. 같은 리터럴을 참조함
		System.out.println(b1 == b2);	// 주소를 비교.
		System.out.println(b1.equals(b2));	// 값비교
		// == : 주소비교
		// Object >> equals : 주소비교
		// Integer >> equals : 값비교(재정의함)
		// String >>equals : 값비교
	}
}


