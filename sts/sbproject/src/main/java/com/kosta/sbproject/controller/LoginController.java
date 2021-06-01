package com.kosta.sbproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosta.sbproject.model.MemberDTO;
import com.kosta.sbproject.security.MemberService;

import jdk.internal.org.jline.utils.Log;

@Controller
public class LoginController {
	
	@Autowired
	MemberService service;

	@GetMapping("/guest")
	@ResponseBody
	public String greeting() {
		return "안녕하세요. 좋은 아침...";
	}
	
	@GetMapping("/auth/login")
	public void login() {
		
	}
	
	@GetMapping("/auth/joinForm")
	public void joinuser() {
		
	}
	
	@PostMapping("/auth/joinProc")
	public String joinProc(@ModelAttribute MemberDTO member) {
		System.out.println("회원가입: " + member.toString());
		service.joinUser(member);
		return "redirect:/auth/login";
	}
	
	@GetMapping("/admin")
	public void adminMethod() {
		
	}
	
	@GetMapping("/manager")
	public void managerMethod() {
		
	}
	
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
		
	}
	
	@GetMapping("/logout")
	public void logout() {
		
	}
	
	@GetMapping("/accessDenied")
	public void accessDenied() {
		
	}
}
