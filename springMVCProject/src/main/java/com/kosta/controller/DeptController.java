package com.kosta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kosta.model.DeptDAO;
import com.kosta.model.DeptVO;

@Controller
public class DeptController {
	
	@Autowired
	DeptDAO deptDAO;
	
	@RequestMapping("dept/deptlist.do")
	public String selectAllDept(Model model) {
		model.addAttribute("deptAll", deptDAO.selectAll());
		return "dept/dept_retrieve";
	}
	
	@RequestMapping("dept/deptInsert.do")
	public String deptInsert(Model model) {
		model.addAttribute("mlist", deptDAO.selectAllManager());
		model.addAttribute("loclist", deptDAO.selectAllLocation());
		return "dept/dept_insert";
	}
	
	@RequestMapping(value="dept/deptInsert.do", method = RequestMethod.POST)
	public String deptInsertPost(DeptVO dept) {
		deptDAO.insertDept(dept);
		return "redirect:/dept/deptlist.do";
	}
	
	
	@RequestMapping("dept/deptDetail.do")
	public String deptDetail(Model model, int deptid) {
		model.addAttribute("dept", deptDAO.selectById(deptid));
		model.addAttribute("mlist", deptDAO.selectAllManager());
		model.addAttribute("loclist", deptDAO.selectAllLocation());
		return "dept/dept_detail";
	}
	
	@RequestMapping(value="dept/deptDetail.do", method = RequestMethod.POST)
	public String deptDetailPost(DeptVO dept) {
		deptDAO.updateDept(dept);
		return "redirect:/dept/deptlist.do";
	}
	
	@RequestMapping("dept/deptDelete.do")
	public String deptDelete(int deptid) {
		deptDAO.deleteDept(deptid);
		return "redirect:/dept/deptlist.do";
	}
}
