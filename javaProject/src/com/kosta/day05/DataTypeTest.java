package com.kosta.day05;

public class DataTypeTest {
	private  int tom = -1;
	private  char marry = '9';
	private  boolean john;
	private  String sarah = "Sarah Jang";

	public static void main(String s[]) {
	    new DataTypeTest().printMyType();
	}

	public  void printMyType() {
		System.out.println("our friends..\n" +tom + ", " +
	          marry + ", " + john + " and " + sarah);
	}
}

//[Ŭ���� ������]
//our friends..
//-1, 9, false and Sarah Jang
