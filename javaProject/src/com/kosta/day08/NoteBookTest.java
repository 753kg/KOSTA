package com.kosta.day08;

public class NoteBookTest {

	public static void main(String[] args) {
		NoteBook n = new NoteBook();
		//n.test();
		
		// 상위에 하위 넣음
		Volume v = new NoteBook();
//		System.out.println(v.TITLE);	// static 잘못된 사용
//		System.out.println(Volume.TITLE);	// 올바른 접근
//		v.volumeUp(100);
//		v.volumeDown(20);
		// v.test();			// NoteBook에만 있는 메서드 접근불가
//		((NoteBook)v).test();	// 강제형변환해서 접근
		
		method1(n);
		method1(v);
		method1(new Speaker());		// 스피커는 노트북으로 형변환 불가능


	}
	
	public static void method1(Volume v) {
		v.volumeUp(100);
		v.volumeDown(20);
		if(v instanceof NoteBook)
			((NoteBook)v).test();
		System.out.println(Volume.TITLE);
		v.close();
		Volume.volumeInfo();	// Volume interface의 static method. 
								//구현한 클래스를 통해서는 접근 불가
		System.out.println("===================");
	}

}
