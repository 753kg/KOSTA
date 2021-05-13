package com.kosta.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.business.EmpService;
import com.kosta.model.EmpVO;

@RestController		// @Controller + @ResponseBody
@RequestMapping("/emp2")
public class EmpTestRestController {
	
	@Autowired
	EmpService empService;
	
	Logger logger = LoggerFactory.getLogger(EmpTestRestController.class);
	
	@RequestMapping(value = "/emplist.do", produces = {"text/html;charset=UTF-8"})
	public String test1() {
		return "<h1>직원리스트입니다.</h1>";
	}
	
	// JSON(JavaScript Object Notation) : javascript object 형태의 문자열 {"키":"값"}
	@RequestMapping(value = "/emp.do")
	public EmpVO test2() {	
		EmpVO emp = empService.selectById(100);
		return emp;
	}
	
	// List 객체 전달하기... AJAX
	@RequestMapping(value = "/emplist3.do")
	public List<EmpVO> test3() {	
		List<EmpVO> emp = empService.selectAll();
		return emp;
	}

	// Map 객체 전달하기... AJAX
	@RequestMapping(value = "/emplist4.do")
	public Map<Integer, EmpVO> test4() {
		List<EmpVO> emplist = empService.selectAll();
		Map<Integer, EmpVO> map = new HashMap<>();
		emplist.forEach(emp -> {
			map.put(emp.getEmployee_id(), emp);
		});
		return map;
	}
	
	// 요청 URL에 매개변수?
	@RequestMapping(value = "/emp5.do/{empid}", method = RequestMethod.GET)
	public EmpVO test5(@PathVariable("empid") int empid) {	
		EmpVO emp = empService.selectById(empid);
		return emp;
	}
	
	// Jackson 라이브러리 : @ResponseBody로 보내기, @RequestBody로 받기 지원
	// @ResponseBody 생략 대신 @RestController 사용
	// @ResponseBody ( Java Object -> JSON )
	// @RequestBody는 JSON 받을 때 사용 ( JSON -> Java Object로 변함 )
	@RequestMapping(value = "/empinsert.do", method=RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String empinsert(@RequestBody EmpVO emp) {
		logger.info(emp.toString());
		int result = empService.insertEmp(emp);
		return result>0?"입력성공":"입력실패";
	}

}
