package com.kosta.sbproject.controller;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.sbproject.model.DeptVO;
import com.kosta.sbproject.persistence.DeptRepository;

import lombok.extern.java.Log;

@Log
@RestController
public class DeptController {
	
	@Autowired
	DeptRepository drepo;
	
	@RequestMapping("/deptlist")
	public Iterable<DeptVO> deptlist() {
		return drepo.findAll();
	}
	
	@RequestMapping("/dept/{deptid}")
	public DeptVO deptById(@PathVariable int deptid) {
		return drepo.findById(deptid).get();
	}
	
	@RequestMapping("/deleteDept/{deptId}")
	public void deleteDept(@PathVariable int deptId) {
		drepo.deleteById(deptId);
	}
	
}
