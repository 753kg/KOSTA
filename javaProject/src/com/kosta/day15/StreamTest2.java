package com.kosta.day15;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest2 {
	
	static Student[] arr = {
			new Student("홍길동", 100),
			new Student("신용권", 80),
			new Student("김자바", 90),
	};
	static List<Student> alist = Arrays.asList(arr);
	/*
	static List<Student> alist = null
	static { Arrays.asList(arr); }			// 문장을 쓰려면 block 필요
	 */
	public static void main(String[] args) {
		method1();
	}

	private static void method1() {
		Stream<Student> stream = alist.stream();
		
//		Function<Student, Integer> f1 = student -> student.getScore();
		ToIntFunction<Student> f2 = student -> student.getScore();
		IntStream is = stream.mapToInt(f2);
		OptionalDouble od = is.average();
		double avg = od.getAsDouble();
		System.out.println(avg);
		
		double avg2 = alist.stream()
				.mapToInt(Student::getScore)
				.average()
				.getAsDouble();
		System.out.println(avg2);
	}

}
