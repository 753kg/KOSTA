package com.kosta.day13.model;

import java.util.List;

// 사용자요청 --> Controller --> Service(업무로직) --> DAO(Data Access Object) --> DB
//	응답	   <--			 <--				 <--					 	 <--
public class CustomerService {
	
	// CustomerService를 생성하면 CustomerDAO도 생성된다.
	CustomerDAO dao = new CustomerDAO();
	
	public List<CustomerDTO> selectAll() {
		// 모든 고객정보를 조회한다.
		// DB 가는 로직은 DAO 호출
		return dao.selectAll();
	}
	
	public CustomerDTO selectById(int custID) {
		// 특정 ID로 조회
		return dao.selectById(custID);
	}
	
	public CustomerDTO selectByPhone(String phone) {
		// 전화번호로 고객조회
		return dao.selectByPhone(phone);
	}
	
	public int insert(CustomerDTO cust) {
		// 고객 정보 입력
		return dao.insert(cust);
	}
	
	public int update(CustomerDTO cust) {
		// 고객 정보 입력
		return dao.update(cust);
	}
	
	public int delete(int custID) {
		// 고객 정보 입력
		return dao.delete(custID);
	}
}
