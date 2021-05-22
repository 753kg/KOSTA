package com.kosta.day05;

public class StudentSamePackage {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student("���л�");
		Student s3 = new Student("���л�","�İ�");
		System.out.println(s3.name);
		System.out.println(s3.scores);
		System.out.println(s3.major);
		System.out.println(s3.grade);
		
		System.out.println(Student.school);
		System.out.println(Student.TEACHER);
		 
		s3.study();
		s3.study2();
		s3.study3();
		s3.study6();
		
		Student.study5();
	}
}
