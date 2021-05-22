package com.kosta.day13;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.LongToDoubleFunction;
import java.util.function.Supplier;

import com.kosta.day12.Person;

// API가 없으면 만들었겠지
interface LongToDoubleFunction2 {
	double applyAsDouble2(long num);
}

public class LambdaExample3 {

	public static void main(String[] args) {
		method11();
	}
	
	private static void method11() {
		int[] scores = {100, 30, 70, 200, 99};
		int max = 0;
//		for(int i=0; i<scores.length; i++) {
//			if(scores[i] > max) max = scores[i];
//		}
//		System.out.println("가장 높은 점수 : " + max);
		
		IntBinaryOperator f = (a, b) -> {
			if(a > b) return a;
			return b;
		};
		
		for(int i=0; i<scores.length; i++) {
			max = f.applyAsInt(max, scores[i]);
		}
		System.out.println("가장 높은 점수 : " + max);
	}

	private static void maxOrMin(IntBinaryOperator ibo) {
		int result = ibo.applyAsInt(10, 20);
		System.out.println("result=" + result);
	}
	
	private static void method10() {
		IntBinaryOperator ibo = (a, b) -> {
			return a>=b? a:b;
		};
		int result = ibo.applyAsInt(10, 20);
		System.out.println("result=" + result);
		
		// maxOrMin(ibo);	// 함수 전달
		maxOrMin( (a, b) -> { return a>=b? a:b;} );
	}

	private static void method9() {
		// T와 T를 계산
		BinaryOperator<String> bo = (a, b) -> a + b;
		String s = bo.apply("자바", "프로그램");
		System.out.println(s);
	}

	private static void method8() {
		LongToDoubleFunction ltd = a -> a * Math.PI;
		long lo = 100L;
		double result = ltd.applyAsDouble(lo);
		System.out.println(result);
		
		LongToDoubleFunction2 ltd2 = a -> a * Math.PI;
		long lo2 = 100L;
		double result2 = ltd2.applyAsDouble2(lo);
		System.out.println(result);
	}

	private static void method7() {
		// Function 함수적 인터페이스
		BiFunction<Integer, Integer, String> f = (num1, num2) -> {
			String grade = "F";
			int score = num1 + num2;
			if(score >= 90) grade = "A";
			else if(score >= 80) grade = "B";
			else if(score >= 70) grade = "C";
			else if(score >= 60) grade = "D";
			return grade;
		};
		String result = f.apply(20, 50);
		System.out.println(result);
	}
	
	private static void method6() {
		// Function 함수적 인터페이스
		Function<Integer, String> f = (score) -> {
			String grade = "F";
			if(score >= 90) grade = "A";
			else if(score >= 80) grade = "B";
			else if(score >= 70) grade = "C";
			else if(score >= 60) grade = "D";
			return grade;
		};
		String result = f.apply(85);
		System.out.println(result);
	}

	private static void method5() {
		// 공급자 interface
		BooleanSupplier supplier = () -> 10>20;
		boolean s = supplier.getAsBoolean();
		System.out.println(s);
	}
	
	private static void method4() {
		// 공급자 interface
		Supplier<String> supplier = () -> "문자를 공급합니다.";		// return만 있으면 return 생략
		String s = supplier.get();
		System.out.println(s);
	}
	
	private static void method3() {
		// 공급자 interface
		Supplier<String> supplier = () -> {
			System.out.println("파라미터는 없고 return만 있다.");
			return "문자를 공급합니다.";
		};
		String s = supplier.get();
		System.out.println(s);
	}

	private static void method2() {
		// 소비자 interface
		BiConsumer<String, Person> consumer = (a, b) -> { 		// 매개변수 1개일 땐 () 생략 가능
			System.out.println("파라미터 2개 받아서 실행한다.");
			System.out.println("받은 값1: " + a);
			System.out.println("받은 값2: " + b);
		};
		consumer.accept("자바프로그래밍", new Person("홍길동"));
	}

	private static void method1() {
		// 소비자 interface
		Consumer<String> consumer = s -> { 		// 매개변수 1개일 땐 () 생략 가능
			System.out.println("파라미터 1개 받아서 실행한다.");
			System.out.println("받은 값: " + s);
		};
		consumer.accept("자바프로그래밍");
	}

}
