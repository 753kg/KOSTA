package com.kosta.day05;

class Singleton{
	int score=100;
	static int score2=200;
	static Singleton aa;
	
	private Singleton(){		
	}
	static Singleton getInstance(){
		if(aa == null) 	aa = new Singleton();
		return aa;
	}
	
}
public class SingletonTest {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance(); 
		Singleton s2 = Singleton.getInstance(); 
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.score); //instance ���� 
		System.out.println(s1.score2);
		System.out.println(Singleton.score2); //static���� ���� 
	}

}
