package com.kosta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosta.model.DeptDAO;
import com.kosta.model.EmpDAO;

@Controller
public class EmpController {
	
	@Autowired
	EmpDAO empDAO;
	
	@Autowired
	DeptDAO deptDAO;
	
	@RequestMapping("/emp/emplist.do")
	public String emplist(Model model) {	// 함수 이름은 아무거나
		
		model.addAttribute("emplist", empDAO.selectAll());
		return "emp/emplist";	// view 이름
	}
	
	@RequestMapping("/emp/empInsert.do")
	public String empinsertform(Model model) {	// 함수 이름은 아무거나
		
		model.addAttribute("joblist", empDAO.selectAllJobs());
		model.addAttribute("deptlist", deptDAO.selectAll());
		model.addAttribute("mlist", deptDAO.selectAllManager());
		return "emp/emp_insert";	// view 이름
	}
}
