package com.kosta.day08;

public class SoundableExample {

	public static void main(String[] args) {
		printSound(new Cat());
		printSound(new Dog());

	}
	
	public static void printSound(Soundable s) {
		System.out.println(s.sound());
	}

}
