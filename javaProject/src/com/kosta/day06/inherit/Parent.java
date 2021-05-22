package com.kosta.day06.inherit;

// 부모는 자식을 모른다.
public class Parent {
	
	int a = 10;
	Parent(){
		System.out.println("부모의 생성자");
	}
	void method1() {
		System.out.println("부모의 메서드");
	}
}
