package model;

import java.sql.Date;

public class BookVO {
	int b_code;
	String b_name;
	String author;
	String pub;
	Date pub_date;
	String cover;
	//String category;
	String b_status;
	String return_date;
	String rsv_status;
	
	public BookVO() {
		
	}

	public BookVO(int b_code, String b_name, String author, String pub, Date pub_date, String cover, String b_status,
			String return_date, String rsv_status) {
		super();
		this.b_code = b_code;
		this.b_name = b_name;
		this.author = author;
		this.pub = pub;
		this.pub_date = pub_date;
		this.cover = cover;
		this.b_status = b_status;
		this.return_date = return_date;
		this.rsv_status = rsv_status;
	}

	
	
	public String getRsv_status() {
		return rsv_status;
	}

	public void setRsv_status(String rsv_status) {
		this.rsv_status = rsv_status;
	}

	public int getB_code() {
		return b_code;
	}

	public void setB_code(int b_code) {
		this.b_code = b_code;
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

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

	public Date getPub_date() {
		return pub_date;
	}

	public void setPub_date(Date pub_date) {
		this.pub_date = pub_date;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getB_status() {
		return b_status;
	}

	public void setB_status(String b_status) {
		this.b_status = b_status;
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	@Override
	public String toString() {
		return "BookVO [b_code=" + b_code + ", b_name=" + b_name + ", author=" + author + ", pub=" + pub + ", pub_date="
				+ pub_date + ", cover=" + cover + ", b_status=" + b_status + ", return_date=" + return_date
				+ ", rsv_status=" + rsv_status + "]";
	}

	
	
	
}
