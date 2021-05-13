package com.kosta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.business.EmpService;
import com.kosta.model.EmpVO;

@RestController		// @Controller + @ResponseBody
public class LoginController {
	
	@Autowired
	EmpService empService;
	
	// 객체 리턴하기 --> Jackson 라이브러리가 자동으로 json으로 바꿔줌
	// 요청 : http://localhost:9090/springmvcproject/emp/login2.do?id=100&email=SKING
	@RequestMapping(value = "/emp/login2.do")
	public EmpVO empLogin2(int id, String email) {
		EmpVO emp = empService.loginChk(id, email);
		return emp;		// responsebody에 return
	}
	
	@RequestMapping(value = "/emp/emplist2.do")
	public List<EmpVO> emplist2() {
		List<EmpVO> emplist = empService.selectAll();
		return emplist;	
	}
}
