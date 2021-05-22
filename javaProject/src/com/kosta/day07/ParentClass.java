package com.kosta.day07;

public class ParentClass {
	String nation;
	
	ParentClass(){
		this("대한민국");	// 부모 생성자 호출 X ,다른 생성자 호출
		System.out.println("2. Parent() call");
	}
	
	ParentClass(String nation){
		super();		// 0. Object 생성자 호출
		this.nation = nation;
		System.out.println("1. Parent(String nation) call");
	}
}
