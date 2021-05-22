package com.kosta.day13;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class LAB6 {
	
	private static Student[] students = {
		new Student("홍길동", 90, 96),
		new Student("신용권", 95, 93)		
	};
	
	private static double avg2(ToIntFunction<Student> f) {
		double sum = 0.0;
		for(Student s:students) {
			sum += f.applyAsInt(s);
		}
		return sum / students.length;
	}
	
	private static double avg(Function<Student, Integer> f) {
		int sum = 0;
		for(Student s:students) {
			sum += f.apply(s);
		}
		return 1.0 * sum / students.length;
	}

	public static void main(String[] args) {
		double englishAvg = avg2( s -> s.getEnglishScore() );
		System.out.println("영어 평균 점수: " + englishAvg);
		
		double mathAvg = avg2( s -> s.getMathScore() );
		System.out.println("수학 평균 점수: " + mathAvg);
	}

}
