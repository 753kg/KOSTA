package com.kosta.day05;

//Book를 이용해서 업무로직 
public class BookMgr {
	Book[] booklist;
	public BookMgr(Book[] booklist) {
		this.booklist = booklist;
	}
	void printBookList(){
		System.out.println("=== 책 목록 ==="); 
		for(Book book :booklist) {
			System.out.println(book.getTitle());
		}			 
	}
	void printTotalPrice(){
		System.out.println("=== 책 가격의 총합 ===");
		int total = 0;
		for(Book book :booklist) {
			total += book.getPrice();
		}	
		System.out.println("전체 책 가격의 합 :" + total);

	}
}