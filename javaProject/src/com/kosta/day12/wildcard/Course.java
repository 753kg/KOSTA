package com.kosta.day12.wildcard;

public class Course<T> {
	private String courseName;
//	Person[] students;				==> 자식클래스 모두 들어올 수 있음
	private T[] students;			// ==> 정한 타입만 들어올 수 있다.
	private int i = 0;
	
	public Course(String courseName, int capacity) {
		super();
		this.courseName = courseName;
		this.students = (T[]) new Object[capacity];		// 모든 타입이 다 들어갈 수 있는 걸로
														// Person으로 해도 됨
	}

	public String getCourseName() {
		return courseName;
	}
	
	public T[] getStudents() {
		return students;
	}
	
	public void add(T student) {
		students[i++] = student;
	}
	
	
}
