package com.kosta.sbproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.sbproject.model.EmpVO;
import com.kosta.sbproject.persistence.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository repo;
	
	public List<EmpVO> selectAll(){
		return (List<EmpVO>)repo.findAll();
	}
	
	public EmpVO selectById(int empid) {
		return repo.findById(empid).get();
	}
}
