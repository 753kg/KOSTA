package com.kosta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kosta.business.DeptDAO;
import com.kosta.business.DeptServiceImpl;
import com.kosta.model.DeptVO;

@Controller
public class DeptController {
	
	@Autowired	// DeptDAO deptDAO = new DeptDAO();
	DeptServiceImpl service;
	// 컨트롤러에서는 DAO에 가지 않음
	// DeptDAO deptDAO;
	
	@RequestMapping("dept/deptlist.do")
	public String selectAllDept(Model model) {
		model.addAttribute("deptAll", service.findAll());
		return "dept/dept_retrieve";
	}
	
	@RequestMapping("dept/deptInsert.do")
	public String deptInsert(Model model) {
		model.addAttribute("mlist", service.findAllManager());
		model.addAttribute("loclist", service.findAllLocation());
		return "dept/dept_insert";
	}
	
	@RequestMapping(value="dept/deptInsert.do", method = RequestMethod.POST)
	public String deptInsertPost(DeptVO dept) {
		service.insert(dept);
		return "redirect:/dept/deptlist.do";
	}
	
	
	@RequestMapping("dept/deptDetail.do")
	public String deptDetail(Model model, int deptid) {
		model.addAttribute("dept", service.findById(deptid));
		model.addAttribute("mlist", service.findAllManager());
		model.addAttribute("loclist", service.findAllLocation());
		return "dept/dept_detail";
	}
	
	@RequestMapping(value="dept/deptDetail.do", method = RequestMethod.POST)
	public String deptDetailPost(DeptVO dept) {
		service.update(dept);
		return "redirect:/dept/deptlist.do";
	}
	
	@RequestMapping("dept/deptDelete.do")
	public String deptDelete(int deptid) {
		service.delete(deptid);
		return "redirect:/dept/deptlist.do";
	}
}
