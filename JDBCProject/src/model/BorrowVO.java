package model;

import java.sql.Date;

public class BorrowVO {
	// 대출코드, 책 이름, 작가, 빌린날짜, 반납날짜, 대출상태
	int borr_code;
	int b_code;
	String b_name;
	String author;
	Date borr_date;
	Date return_date;
	String borr_status;
	String rsv_member;
	
	public BorrowVO() {
		
	}

	public BorrowVO(int borr_code, int b_code, String b_name, String author, Date borr_date, Date return_date, 
			String borr_status, String rsv_member) {
		super();
		this.borr_code = borr_code;
		this.b_code = b_code;
		this.b_name = b_name;
		this.author = author;
		this.borr_date = borr_date;
		this.return_date = return_date;
		this.borr_status = borr_status;
		this.rsv_member = rsv_member;
	}

	public int getB_code() {
		return b_code;
	}

	public void setB_code(int b_code) {
		this.b_code = b_code;
	}

	public int getBorr_code() {
		return borr_code;
	}

	public void setBorr_code(int borr_code) {
		this.borr_code = borr_code;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getBorr_date() {
		return borr_date;
	}

	public void setBorr_date(Date borr_date) {
		this.borr_date = borr_date;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	public String getBorr_status() {
		return borr_status;
	}

	public void setBorr_status(String borr_status) {
		this.borr_status = borr_status;
	}

	
	
	public String getRsv_member() {
		return rsv_member;
	}

	public void setRsv_member(String rsv_member) {
		this.rsv_member = rsv_member;
	}

	@Override
	public String toString() {
		return "BorrowVO [borr_code=" + borr_code + ", b_code=" + b_code + ", b_name=" + b_name + ", author=" + author
				+ ", borr_date=" + borr_date + ", return_date=" + return_date + ", borr_status=" + borr_status
				+ ", rsv_member=" + rsv_member + "]";
	}

	
	
}
