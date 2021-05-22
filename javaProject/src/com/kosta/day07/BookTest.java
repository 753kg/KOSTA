package com.kosta.day07;

public class BookTest {

	public static void main(String[] args) {
		
		print(new JavaBook("이것이자바다", 30000));
		print(new SpringBook("SpringBoot", 35000));

	}
	
	public static void print(Book b) {
		b.printContents();
		b.solveExample();
		
		/* 추상이 아니면 훨씬 복잡하다.
		if(b instanceof JavaBook){
			JavaBook j = (JavaBook) b;
		 	j.printContents();
		 	j.solveExample();
		}else if(b instanceof SpringBook) {
			SpringBook s = (SpringBook) b;
			s.printContents();
			s.solveExample();
		}*/
	}

}
