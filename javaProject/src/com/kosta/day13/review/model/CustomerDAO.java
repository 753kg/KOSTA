package com.kosta.day13.review.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	
	List<CustomerDTO> custlist = new ArrayList<CustomerDTO>();
	
	public CustomerDAO() {
		custlist.add(new CustomerDTO(1, "kim", "010-1111-1111", "서울"));
		custlist.add(new CustomerDTO(2, "lee", "010-2222-2222", "부산"));
		custlist.add(new CustomerDTO(3, "seo", "010-3333-3333", "여수"));
		custlist.add(new CustomerDTO(4, "park", "010-4444-4444", "인천"));
		custlist.add(new CustomerDTO(5, "jang", "010-5555-5555", "서울"));
	}
	
	public List<CustomerDTO> selectAll() {
		return custlist;
	}
	
	public CustomerDTO selectById(int custId) {
		for(CustomerDTO cust:custlist) {
			if(cust.getCustId() == custId) return cust;
		}
		return null;
	}
	
	public CustomerDTO selectByPhone(String phone) {
		for(CustomerDTO cust:custlist) {
			if(cust.getPhone().equals(phone)) return cust;
		}
		return null;
	}
	
	public int insert(CustomerDTO cust) {
		custlist.add(cust);
		return 1;
	}
	
	public int update(CustomerDTO cust) {
		for(CustomerDTO cc:custlist) {
			if(cc.getCustId() == cust.getCustId()) {
				cc.setCustName(cust.getCustName());
				cc.setPhone(cust.getPhone());
				cc.setAddress(cust.getAddress());
				return 1;
			}
		}
		return 0;
	}
	
	public int delete(int custId) {
		for(int i=0; i<custlist.size(); i++) {
			if(custlist.get(i).getCustId() == custId) {
				custlist.remove(i);
				return 1;
			}
		}
		return 0;
	}

}
