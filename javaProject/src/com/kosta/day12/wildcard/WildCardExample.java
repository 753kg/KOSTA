package com.kosta.day12.wildcard;

import java.util.Arrays;

public class WildCardExample {

	public static void main(String[] args) {
		Course<Person> a = makePerson();
		Course<Student> b = makeStudent();
		Course<HighStudent> c = makeHighStudent();
		Course<Worker> d = makeWorker();
		
		registerPersonCourse(a);
		registerPersonCourse(b);
		registerPersonCourse(c);
		registerPersonCourse(d);
		
//		registerStudentCourse(a);
		registerStudentCourse(b);
		registerStudentCourse(c);
//		registerStudentCourse(d);
		
		registerWorkerCourse(a);
//		registerWorkerCourse(b);
//		registerWorkerCourse(c);
		registerWorkerCourse(d);
	}
	
													// Worker부터 위로 가능
	private static void registerWorkerCourse(Course<? super Worker> course) {
		System.out.println(course.getCourseName());
		String s = Arrays.toString(course.getStudents());
		System.out.println(s);
		System.out.println("----------------------------------------");
	}
	
													// Student와 Student를 상속받은 것만 올 수 있다.
	private static void registerStudentCourse(Course<? extends Student> course) {
		System.out.println(course.getCourseName());
		String s = Arrays.toString(course.getStudents());
		System.out.println(s);
		System.out.println("----------------------------------------");
	}
	
	// (Course<Person> course) ==> Person밖에 못온다.
	private static void registerPersonCourse(Course<?> course) {
		System.out.println(course.getCourseName());
		String s = Arrays.toString(course.getStudents());
		System.out.println(s);
		System.out.println("----------------------------------------");
	}

	private static Course<Worker> makeWorker() {
		// 과정 만들어서 학생 넣기
		Course<Worker> pCourse = new Course<Worker>("직장인과정", 4);
		pCourse.add(new Worker("직장인1"));
		
//		String s = Arrays.toString(pCourse.getStudents());
//		System.out.println(s);
		return pCourse;
	}
	
	private static Course<HighStudent> makeHighStudent() {
		// 과정 만들어서 학생 넣기
		Course<HighStudent> pCourse = new Course<HighStudent>("고등학생과정", 4);
		pCourse.add(new HighStudent("고등학생1"));
		
//		String s = Arrays.toString(pCourse.getStudents());
//		System.out.println(s);
		return pCourse;
	}
	
	private static Course<Student> makeStudent() {
		// 과정 만들어서 학생 넣기
		Course<Student> pCourse = new Course<Student>("학생과정", 4);
		pCourse.add(new Student("학생1"));
		pCourse.add(new HighStudent("고등학생1"));
		
//		String s = Arrays.toString(pCourse.getStudents());
//		System.out.println(s);
		return pCourse;
	}

	private static Course<Person> makePerson() {
		// 과정 만들어서 학생 넣기
		Course<Person> pCourse = new Course<Person>("일반인과정", 4);
		pCourse.add(new Person("일반인1"));
		pCourse.add(new Student("학생1"));
		pCourse.add(new HighStudent("고등학생1"));
		pCourse.add(new Worker("직장인1"));
		
//		String s = Arrays.toString(pCourse.getStudents());
//		System.out.println(s);
		return pCourse;
	}

}
