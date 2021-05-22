package view;

import java.util.List;

import model.BookVO;
import model.BorrowVO;

public class LibraryView {

	public static void printBooks(List<BookVO> booklist) {
		int count = 0;
		for(BookVO book : booklist) {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.print(String.format("순번:%-10d ", count+1));
			System.out.println("책표지:" + book.getCover());
			System.out.println(String.format("도서코드:%-7d 도서명:%-20s 작가명:%-10s", book.getB_code(), book.getB_name(), book.getAuthor()));
			System.out.println(String.format("출판사:%-10s 출간일:%tF ", book.getPub(), book.getPub_date()));
			System.out.println(String.format("대출상태:%-9s 반납예정일:%-20s 예약상태:%-4s", book.getB_status(), book.getReturn_date(), book.getRsv_status()));
			
			count ++;
		}
		if(count != 0) System.out.println("총 " + count + "건 --------------------------------------------------");
		else print("검색 결과가 없습니다.");
	}
	
	public static void printBorrows(List<BorrowVO> borrlist) {
		int count = 0;
		for(BorrowVO borr : borrlist) {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println(String.format("순번:%-10d 대출코드:%-7d ", count+1, borr.getBorr_code()));
			System.out.println(String.format("도서코드:%-7d 도서명:%-20s 작가명:%-10s", borr.getB_code(), borr.getB_name(), borr.getAuthor()));
			System.out.println(String.format("대출일:%-9s 반납일:%-20s", borr.getBorr_date(), borr.getReturn_date()));
			System.out.print(String.format("대출상태:%-9s", borr.getBorr_status()));
			System.out.println("예약상태:" + (borr.getRsv_member() == null ? "-" : "예약중"));
			
			count ++;
		}
		if(count != 0) System.out.println("총 " + count + "건 --------------------------------------------------");
		else print("대출 이력이 없습니다.");
	}
	
	public static void printBorrows(BorrowVO borr) {
		if(borr == null) print("예약도서가 없습니다.");
		else {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println(String.format("도서코드:%-7d 도서명:%-20s 작가명:%-10s", borr.getB_code(), borr.getB_name(), borr.getAuthor()));
		System.out.println(String.format("대출일:%-9s 반납일:%-20s", borr.getBorr_date(), borr.getReturn_date()));
		System.out.print(String.format("대출상태:%-9s", borr.getBorr_status()));
		System.out.println("예약상태:" + (borr.getRsv_member() == null ? "-" : "예약중"));
		System.out.println("-----------------------------------------------------------------------------");
		}
	}
	
	
	public static void print(String message) {
		System.out.println("[알림]" + message);
	}
}
