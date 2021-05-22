package com.kosta.day13.review.model;

import java.util.List;

// DTO : DB 틀
// 사용자 요청 -> Controller -> Service -> DAO -> DB
public class CustomerService {
	
	CustomerDAO dao = new CustomerDAO();
	
	public List<CustomerDTO> selectAll() {
		return dao.selectAll();
	}
	
	public CustomerDTO selectById(int custId) {
		return dao.selectById(custId);
	}
	
	public CustomerDTO selectByPhone(String phone) {
		return dao.selectByPhone(phone);
	}
	
	public int insert(CustomerDTO cust) {
		return dao.insert(cust);
	}
	
	public int update(CustomerDTO cust) {
		return dao.update(cust);
	}
	
	public int delete(int custId) {
		return dao.delete(custId);
	}
}
