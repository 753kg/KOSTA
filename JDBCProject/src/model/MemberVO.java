package model;

import java.sql.Date;

public class MemberVO {
	String m_id;
	String m_pass;
	String m_name;
	Date birth;
	String phone;
	int borr_count = 0;
	int rsv_count = 0;
	
	public MemberVO() {
	
	}

	public MemberVO(String m_id, String m_pass, String m_name, Date birth, String phone, 
			int borr_count, int rsv_count) {
		super();
		this.m_id = m_id;
		this.m_pass = m_pass;
		this.m_name = m_name;
		this.birth = birth;
		this.phone = phone;
		this.borr_count = borr_count;
		this.rsv_count = rsv_count;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pass() {
		return m_pass;
	}

	public void setM_pass(String m_pass) {
		this.m_pass = m_pass;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getBorr_count() {
		return borr_count;
	}

	public void setBorr_count(int borr_count) {
		this.borr_count = borr_count;
	}

	
	
	public int getRsv_count() {
		return rsv_count;
	}

	public void setRsv_count(int rsv_count) {
		this.rsv_count = rsv_count;
	}

	@Override
	public String toString() {
		return "MemberVO [m_id=" + m_id + ", m_pass=" + m_pass + ", m_name=" + m_name + ", birth=" + birth + ", phone="
				+ phone + ", borr_count=" + borr_count + ", rsv_count=" + rsv_count + "]";
	}

	
	
}
