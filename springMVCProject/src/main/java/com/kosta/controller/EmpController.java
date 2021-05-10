package com.kosta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kosta.model.DeptDAO;
import com.kosta.model.EmpDAO;
import com.kosta.model.EmpVO;

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
	
	@RequestMapping(value="/emp/empInsert.do", method = RequestMethod.POST)
	public String empinsertPost(EmpVO emp) {	// 함수 이름은 아무거나
		
		System.out.println(emp);
		empDAO.insertEmp(emp);
		return "redirect:/emp/emplist.do";	// view 이름
	}
	
	@RequestMapping("/emp/empDetail.do")
	public String empDetailGet(Model model, int empid) {
		model.addAttribute("emp", empDAO.selectById(empid));
		model.addAttribute("joblist", empDAO.selectAllJobs());
		model.addAttribute("deptlist", deptDAO.selectAll());
		model.addAttribute("mlist", deptDAO.selectAllManager());
		return "emp/emp_detail";	// forward
	}
	
	@RequestMapping("/emp/empDelete.do")
	public String empDeleteGet(int empid) {
		empDAO.deleteEmp(empid);
		return "redirect:/emp/emplist.do";	// redirect
	}
	
	@RequestMapping(value="/emp/empDetail.do", method = RequestMethod.POST)
	public String empDetailPost(EmpVO emp) {
		empDAO.updateEmp(emp);
		return "redirect:/emp/emplist.do";
	}
}
