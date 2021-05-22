package com.kosta.day10;
							// 복제 가능	// 비교(나와 Book 비교)
public class Book implements Cloneable, Comparable<Book>{
	private String title;
	private int price;
	private boolean ebook;
	
	public Book() {
		
	}
	
	public Book(String title) {
		this.title = title;
	}
	
	public Book(String title, int price, boolean ebook) {
		super();
		this.title = title;
		this.price = price;
		this.ebook = ebook;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isEbook() {
		return ebook;
	}
	public void setEbook(boolean ebook) {
		this.ebook = ebook;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [title=").append(title).append(", price=").append(price).append(", ebook=").append(ebook)
				.append("]");
		return builder.toString();
	}
	
	// Cloneable ==> clone() Override 하기
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + (ebook ? 1231 : 1237);
//		result = prime * result + price;
//		result = prime * result + ((title == null) ? 0 : title.hashCode());
//		return result;
//	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (ebook != other.ebook)
			return false;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public int compareTo(Book newBook) {
		// sort 기준 정하기 ==> 기본 sort는 가격으로 Ascending
		// 다른 걸로도 sort 하고 싶으면 따로 class 만들어야함
		// < = > Ascending
		return price - newBook.price; 
	}
	
	
}
