package com.kosta.day12;

import java.util.Arrays;

public class WildCardExample {

	public static void main(String[] args) {
		Course<Person> persons = makePerson();
		Course<Student> students = makeStudent();
		Course<HighStudent> hstudents = makeHighStudent();
		Course<Worker> workers = makeWorker();
		
		registerCourse(persons);
		registerCourse(students);
		registerCourse(hstudents);
		registerCourse(workers);
		System.out.println("======================================================");
//		registerCourse2(persons);
		registerCourse2(students);
		registerCourse2(hstudents);
//		registerCourse2(workers);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		registerCourse3(persons);
		registerCourse3(students);
//		registerCourse3(hstudents);
//		registerCourse3(workers);
		System.out.println("###################################################");
		registerCourse4(persons);
//		registerCourse4(students);
//		registerCourse4(hstudents);
		registerCourse4(workers);
		
	}
	// Worker와 Worker 위로만 가능 : Worker, Person 가능
	public static void registerCourse4(Course<? super Worker> course) {
		System.out.println("*****"+course.getName() + " 과정******");
		String s = Arrays.toString(course.getStudents());
		System.out.println(s);
		System.out.println("-----------------------------------");
	}
	
												// Student와 Student 위로만 가능 : Student, Person 가능
	public static void registerCourse3(Course<? super Student> course) {
		System.out.println("*****"+course.getName() + " 과정******");
		String s = Arrays.toString(course.getStudents());
		System.out.println(s);
		System.out.println("-----------------------------------");
	}
	
												// Student와 Student를 상속받은 것만 올 수 있다.
	public static void registerCourse2(Course<? extends Student> course) {
		System.out.println("*****"+course.getName() + " 과정******");
		String s = Arrays.toString(course.getStudents());
		System.out.println(s);
		System.out.println("-----------------------------------");
	}
	
										// ? : Person, Worker, Student, HighStudent 다 올 수 있다.
	public static void registerCourse(Course<?> course) {
		System.out.println("*****"+course.getName() + " 과정******");
		String s = Arrays.toString(course.getStudents());
		System.out.println(s);
		System.out.println("-----------------------------------");
	}
	
	private static Course<Worker> makeWorker() {
		// 과정 생성
		Course<Worker> pCourse = new Course<Worker>("직장인과정", 2);
		pCourse.add(new Worker("직장인1"));
		pCourse.add(new Worker("직장인2"));
		
//		Object[] ps = pCourse.getStudents();
//		myPrint(ps);
		return pCourse;
	}
	
	private static Course<HighStudent> makeHighStudent() {
		// 과정 생성
		Course<HighStudent> pCourse = new Course<HighStudent>("고등학생과정", 2);
		pCourse.add(new HighStudent("고등학생1"));
		pCourse.add(new HighStudent("고등학생2"));
		
//		Object[] ps = pCourse.getStudents();
//		myPrint(ps);
		return pCourse;
	}
	
	private static Course<Student> makeStudent() {
		// 과정 생성
		Course<Student> pCourse = new Course<Student>("학생과정", 4);
		pCourse.add(new Student("학생1"));
		pCourse.add(new Student("학생2"));
		pCourse.add(new HighStudent("고등학생1"));
		pCourse.add(new HighStudent("고등학생2"));
		
		//Object[] ps = pCourse.getStudents();
		//myPrint(ps);
		return pCourse;
	}

	private static Course<Person> makePerson() {
		// 과정 생성
		Course<Person> pCourse = new Course<Person>("일반인과정", 8);
		pCourse.add(new Person("일반인1"));
		pCourse.add(new Person("일반인2"));
		pCourse.add(new Worker("직장인1"));
		pCourse.add(new Worker("직장인2"));
		pCourse.add(new Student("학생1"));
		pCourse.add(new Student("학생2"));
		pCourse.add(new HighStudent("고등학생1"));
		pCourse.add(new HighStudent("고등학생2"));
		
//		Object[] ps = pCourse.getStudents();
		//myPrint(ps);
		return pCourse;
	}
	
	private static void myPrint(Object[] ps) {
		for(Object p:ps) {
			System.out.println(p);
		}
		System.out.println("---------------------------------");
	}

}
