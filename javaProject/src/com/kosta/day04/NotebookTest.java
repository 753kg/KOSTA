package com.kosta.day04;

public class NotebookTest {

	public static void main(String[] args) {
		
		String s = new String("자바");
		System.out.println(s);			// s = s.toString(), String은 내용 출력됨
		
		System.out.println(Notebook.getCount()+"대 있음...메서드접근");
		// **private는 외부접근불가
		// System.out.println(Notebook.count + "대 있음...필드접근");
		
		Notebook n1 = new Notebook("abc12345", "gram123", 150);
		Notebook n2 = new Notebook("ggg12345", "samsung123", 250);
		Notebook n3 = new Notebook("hhh12345", "LG123", 100);
		
		System.out.println(Notebook.getCount()+"대 있음...메서드접근");
		
		System.out.println(n1.getMacAddress());
		n1.setMacAddress("ABCD12345");
		System.out.println(n1.getMacAddress());

		System.out.println(n1);				// 주소가 출력됨
		System.out.println(n1.toString());	// n1 = n1.toString()

	}

}