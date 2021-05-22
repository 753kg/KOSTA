package com.kosta.day05;

public class Student {
	//접근권한(범위):public, protected,default,private
	public String name;
	protected int[] scores;
	String major;
	private String sNo;
	//활용방법 : static, final
	public static String school;
	public final int grade=4;
	public static final String TEACHER="김교수님";
	
	//생성자의 접근권한 
	public Student(String name){this.name = name;}
	protected Student(String name,String major){
		this.name = name;
		this.major = major;
	}
	Student(){	}
	private Student(int[] scores) {}
	
	//메서드의 접근권한 
	public void study() {}
	protected void study2() {}
	void study3() {}
	private void study4() {}
	
	//메서드의 활용방법
	//1.static : class메서드 
	public static void study5() {}
	//2.final : 자식이 부모의 메서드를 재정의 불가 
	public final void study6() {}
	//3.abstract : 정의는 있고 구현은 없다. 구현은 자식이한다.
	//4.synchronized : lock걸기 ...멀티쓰레드 
	
}