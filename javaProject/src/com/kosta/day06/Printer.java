package com.kosta.day06;

/**
 * 
 * @author KOSTA
 * method의 overloading : 이름같고 매개변수사양이 다르다.
 */
public class Printer {
	
	
	public void println(int i) {
		System.out.println("정수: " + i);
		
	}
	
	public void println(boolean b) {
		System.out.println("boolean: " + b);
		
	}
	
	public void println(double d) {
		System.out.println("double: " + d);
		
	}
	
	public void println(String s) {
		System.out.println("String: " + s);
		
	}
}
