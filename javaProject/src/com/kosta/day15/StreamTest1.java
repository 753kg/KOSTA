package com.kosta.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamTest1 {

	public static void main(String[] args) {
		method8();
	}
	
	private static void method8() {
		// 중간처리
		Student[] arr = {
				new Student("홍길동", 100),
				new Student("신용권", 80),
				new Student("김자바", 90),
		};
		List<Student> alist = Arrays.asList(arr);
								//중간처리			    최종처리
		double avg = alist.stream().
				mapToInt(Student::getScore).
				average().
				getAsDouble();
		System.out.println("평균은: " + avg);
		
		int sum=0;
		for(Student s:alist) {
			sum += s.getScore();
		}
		System.out.println(1.0 * sum / alist.size());
	}

	private static void method7() {
		Student[] arr = {
				new Student("홍길동", 100),
				new Student("신용권", 80),
				new Student("김자바", 90),
		};
		List<Student> alist = Arrays.asList(arr);
		int sum=0;
		for(Student s:alist) {
			sum += s.getScore();
		}
		System.out.println(1.0 * sum / alist.size());
	}

	private static void myPrint(Student s) {
		System.out.println(s + ":" + Thread.currentThread().getName());
	}

	private static void method6() {
		// 순차적처리
		Student[] arr = {
				new Student("홍길동", 100),
				new Student("신용권", 80),
				new Student("김자바", 90),
		};
		List<Student> alist = Arrays.asList(arr);
		Stream<Student> st = alist.stream();
//		Consumer<Student> consumer = student -> myPrint(student);
		Consumer<Student> consumer = StreamTest1::myPrint;
		st.forEach(consumer);
		
		System.out.println("-----------------------------------------------");
		Stream<Student> st2 = alist.parallelStream();
		st2.forEach(consumer);
	}

	private static void method5() {
		Student[] arr = {
				new Student("홍길동", 100),
				new Student("신용권", 80),
				new Student("김자바", 90),
		};
		
		List<Student> alist = Arrays.asList(arr);
		Stream<Student> st = alist.stream();
		Consumer<Student> consumer = student -> System.out.println(student);
		st.forEach(consumer);		// forEach는 consumer만 가능하다..
	}

	private static void method4() {
		Integer[] arr = {100, 50, 20, 100, 70};
		List<Integer> alist = Arrays.asList(arr);
		
		Stream<Integer> st = alist.stream();
		Consumer<Integer> consumer = i -> {
			System.out.println("점수는 " + i);
		};
		
		st.forEach(consumer);
	}

	private static void method3() {
		String[] arr = new String[] {"홍길동", "신용권", "김자바"};
		List<String> alist = Arrays.asList(arr);
		
		// Stream 이용
//		Stream<String> st = alist.stream();
//		st.forEach(s -> System.out.println(s));
		
		Consumer<String> consumer = s -> {
			System.out.println(s);
			System.out.println("--------------------------");
		};
		for(String str:alist) {
			consumer.accept(str);
		}
		
		System.out.println("****************************");
		Stream<String> st = alist.stream();
		st.forEach(consumer);
	}

	private static void method2() {
		String[] arr = new String[] {"홍길동", "신용권", "김자바"};
		List<String> alist = Arrays.asList(arr);
		
		// 향상 for 이용
		for(String s : alist) {
			System.out.println(s);
		}
	}

	private static void method1() {
		String[] arr = new String[] {"홍길동", "신용권", "김자바"};
		List<String> alist = Arrays.asList(arr);
		List<String> alist2 = Arrays.asList(new String[]{"홍길동", "신용권", "김자바"});
		List<String> alist3 = Arrays.asList("홍길동", "신용권", "김자바");	// 여러 건을 list로 바꿔라
		
		// 반복자 직접 사용
		Iterator<String> it = alist.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		
	}

}
