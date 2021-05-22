package com.kosta.day13.review.model;

public class CustomerDTO {
	private int custId;
	private String custName;
	private String phone;
	private String address;
	
	public CustomerDTO() {
		super();
	}

	public CustomerDTO(int custId, String custName, String phone, String address) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.phone = phone;
		this.address = address;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDTO [custId=").append(custId).append(", custName=").append(custName).append(", phone=")
				.append(phone).append(", address=").append(address).append("]");
		return builder.toString();
	}
	
	
	
}
