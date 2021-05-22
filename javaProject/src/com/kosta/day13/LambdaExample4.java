package com.kosta.day13;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaExample4 {

	public static void main(String[] args) {
		method4();
	}

	private static void method4() {
		Student s = new Student("홍길동", "남", 90);
				// 매개타입,  리턴타입
		Function<Student, String> f1 = (a) -> a.getName();
		Function<String, Integer> f2 = (a) -> a.length();
		
		// Student --> f1 ---> String ---> f2 ---> Integer 
		Function<Student, Integer> f3 = f1.andThen(f2);		// student를 넣고 integer가 리턴
		int result = f3.apply(s);
		System.out.println("학생의 이름의 길이: " + result);
		
		Function<Student, Integer> f4 = f2.compose(f1);		// f1 먼저 하고 f2 함
		result = f4.apply(s);
		System.out.println("학생의 이름의 길이: " + result);
		
	}

	private static void method3() {
		Student s = new Student("홍길동", "남", 90);
		Consumer<Student> consumerA = (a) -> {
			System.out.println("Student를 소비한다. A");
			System.out.println("학생 이름: " + a.getName());
		};
		Consumer<Student> consumerB = (a) -> {
			System.out.println("Student를 소비한다. B");
			System.out.println("학생 점수: " + a.getScore());
		};
		
		Consumer<Student> aa = consumerA.andThen(consumerB);	// A먼저 소비하고 B를 소비
		aa.accept(s);											// Consumer는 compose 지원안됨.
		
	}

	private static void method2() {
		Student[] students = {
			new Student("홍길동", "남", 90),
			new Student("김채연", "여", 91),
			new Student("김현빈", "여", 92),
			new Student("오정훈", "남", 93),
			new Student("윤종무", "남", 94)
		};
		
		// 남자몇명?
		Predicate<Student> p = student -> {
			if(student.getGender().equals("남")) return true;
			return false;
		};
		
		boolean result = p.test(new Student("윤종무", "남", 94));
		System.out.println(result);
		
		int count = 0;
		for(Student s:students) {
			if(p.test(s)) count++;
		}
		System.out.println("남자는 " + count + "명이다.");
	}

	private static void method1() {
		// 매개값을 조사해서 boolean으로 return 
		Predicate<String> p = id -> {
			if(id.length() >= 3) return true;
			return false;
		};
		System.out.println(p.test("Hello"));
		System.out.println(p.test("Hi"));
	}

}
