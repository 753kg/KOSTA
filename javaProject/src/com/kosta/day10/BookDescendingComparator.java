package com.kosta.day10;

import java.util.Comparator;

public class BookDescendingComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		// descending.... 제목
		// ascending.... 가격
		int result = o2.getTitle().compareTo(o1.getTitle());	// title:문자. 문자 비교는 compareTo
		if(result == 0) {
			return o1.getPrice() - o2.getPrice();
		}
		return result;
	}

}
