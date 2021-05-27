package com.kosta.sbproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosta.sbproject.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	EmpService service;
	
	@RequestMapping("emp/emplist")
	public void emplist(Model model) {
		model.addAttribute("emplist", service.selectAll());
	}
	
	@RequestMapping("emp/empDetail")
	public void emplist(Model model, int empid) {
		model.addAttribute("emp", service.selectById(empid));
	}
}
