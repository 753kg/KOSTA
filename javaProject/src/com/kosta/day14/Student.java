package com.kosta.day14;

public class Student implements Comparable<Student>{
	int studentNum;
	String name;
	
	String id;
	int score;
	
	public Student(int studentNum, String name) {
		super();
		this.studentNum = studentNum;
		this.name = name;
	}
	
	public Student(String id, int score) {
		super();
		this.id = id;
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentNum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentNum != other.studentNum)
			return false;
		return true;
	}

	@Override
	public int compareTo(Student o) {
		return this.score - o.score;
	}
	
	
}
