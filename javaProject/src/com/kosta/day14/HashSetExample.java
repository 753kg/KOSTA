package com.kosta.day14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {
		
		Set<Student> set = new HashSet<>();
		
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신용권"));
		set.add(new Student(1, "조민우"));	// 학번이 같으므로 저장되지 않음
		
		Iterator<Student> it = set.iterator();
		while(it.hasNext()) {
			Student student = it.next();
			System.out.println(student.studentNum + ":" + student.name);
		}
	}

}
