package com.kosta.day12;

// 교육과정
public class Course<T> {
	private String name;	// 교육과정이름
	private T[] students;
	
	public Course(String name, int capacity) {
		super();
		this.name = name;
		this.students = (T[]) new Object[capacity];		// new T[capacity] -> 가변 배열 생성 불가
														// object로 만들고 T로 형변환
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T[] getStudents() {
		return students;
	}
	public void add(T student) {
		// 배열의 빈 곳에 한 명의 학생을 추가한다.
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) {
				students[i] = student;
				break;
			}
		}
	}
	
	
}
