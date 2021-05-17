package com.kosta.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.kosta.business.DeptDAO;
import com.kosta.business.DeptServiceInterface;
import com.kosta.business.EmpDAO;
import com.kosta.business.EmpService;
import com.kosta.model.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@Autowired
	DeptServiceInterface deptService;
	
	Logger logger = LoggerFactory.getLogger(EmpController.class);	// EmpController Class의 logger를 생성
	
	@RequestMapping("/emp/emplist.do")
	public String emplist(Model model) {	// 함수 이름은 아무거나
		
		logger.warn("[warn] emplist.do 요청...");		// info보다 high level. info하면 warn도 같이 뜸
		logger.info("[info] emplist.do 요청...");
		logger.debug("[debug] emplist.do 요청...");
		
		model.addAttribute("emplist", empService.selectAll());
		return "emp/emplist";	// view 이름
	}
	
	@RequestMapping("/emp/empInsert.do")
	public String empinsertform(Model model) {	// 함수 이름은 아무거나
		
		model.addAttribute("joblist", empService.selectAllJobs());
		model.addAttribute("deptlist", deptService.findAll());
		model.addAttribute("mlist", deptService.findAllManager());
		return "emp/emp_insert";	// view 이름
	}
	
	@RequestMapping(value="/emp/empInsert.do", method = RequestMethod.POST)
	public String empinsertPost(EmpVO emp, HttpServletRequest request) {	// 함수 이름은 아무거나
		System.out.println(emp);
		
		/* file upload 하기 전
		empService.insertEmp(emp);
		return "redirect:/emp/emplist.do";	// view 이름
		*/
		
		MultipartFile uploadfile = emp.getUploadfile(); 
		logger.info("uploadfile: " + uploadfile);
		if (uploadfile == null)  return "redirect:/emp/emplist.do"; 
		String path = request.getSession().getServletContext().getRealPath("/resources/upload"); 
		String fileName = uploadfile.getOriginalFilename(); 
		String fpath = path +"\\" + fileName ; // upload할 위치
		emp.setPhone_number(fileName); 	// 파일 경로를 전화번호에 저장
		try {
			File file = new File(fpath); 
			uploadfile.transferTo(file); 
		} catch (IOException e) { e.printStackTrace(); }   
		
		logger.info("path: " + path);
		logger.info("fileName: " + fileName);
		
		empService.insertEmp(emp);
		return "redirect:/emp/emplist.do"; //재요청

	}
	
	@RequestMapping("/emp/empDetail.do")
	public String empDetailGet(Model model, int empid) {
		model.addAttribute("emp", empService.selectById(empid));
		model.addAttribute("joblist", empService.selectAllJobs());
		model.addAttribute("deptlist", deptService.findAll());
		model.addAttribute("mlist", deptService.findAllManager());
		return "emp/emp_detail";	// forward
	}
	
	@RequestMapping("/emp/empDelete.do")
	public String empDeleteGet(int empid) {
		empService.deleteEmp(empid);
		return "redirect:/emp/emplist.do";	// redirect
	}
	
	@RequestMapping(value="/emp/empDetail.do", method = RequestMethod.POST)
	public String empDetailPost(EmpVO emp) {
		empService.updateEmp(emp);
		return "redirect:/emp/emplist.do";
	}
	
	// http://localhost:9090/springmvcproject/emp/login.do?id=100&email=SKING
	@RequestMapping(value = "/emp/login.do", produces = {"text/html;charset=utf-8"})		
	@ResponseBody							// 브라우저에 응답문서가 간다. 페이지 body에 출력
	public String empLogin(int id, String email) {
		EmpVO emp = empService.loginChk(id, email);
		String message = "<h1>존재하지않는 사용자입니다.</h1>";
		if(emp != null) message = emp.toString();
		return message;
	}
	
	
	
	@RequestMapping("/login/loginForm.do")
	public String loginFormGet() {
		return "/login/loginForm";
	}
	
	@RequestMapping(value = "/login/login3.do", method = RequestMethod.POST)
	public String loginFormPost(int userid, String userpw, HttpSession session) {
		EmpVO emp = empService.loginChk(userid, userpw);
		System.out.println(emp);
		if(emp == null) {
			return "redirect:/login/loginForm.do";
		}else {
			session.setAttribute("loginemp", emp);
			return "redirect:/emp/emplist.do";
		}
	}
	
	@RequestMapping("/emp/selectByDept.do")
	public String selectByDept(int deptid, Model model) {
		List<EmpVO> emplist = empService.selectByDept(deptid);
		model.addAttribute("emplist", emplist);
		return "emp/emplist";
	}
	
	@RequestMapping("/emp/selectBySalary.do")
	public String selectBySalary(int minsal, int maxsal ,Model model) {
		List<EmpVO> emplist = empService.selectBySalary(minsal, maxsal);
		model.addAttribute("emplist", emplist);
		return "emp/emplist";
	}
	
	@RequestMapping("/emp/selectByDate.do")
	public String selectByDate(String sdate, String edate ,Model model) {
		List<EmpVO> emplist = empService.selectByDate(sdate, edate);
		model.addAttribute("emplist", emplist);
		return "emp/emplist";
	}
	
	@RequestMapping("/emp/selectByDate2.do")
	public String selectByDate2(Date sdate, Date edate ,Model model) {
		List<EmpVO> emplist = empService.selectByDate2(sdate, edate);
		model.addAttribute("emplist", emplist);
		return "emp/emplist";
	}
	
	@RequestMapping("/emp/selectByCondition.do")
	public String selectByCondition(String deptid, String jobid, String sal, String hdate, String hdateChk, Model model) {
		System.out.println(hdateChk);
		int dept = "".equals(deptid)? 0 : Integer.parseInt(deptid);
		int salary = "".equals(sal)? 0 : Integer.parseInt(sal);
		if(hdateChk != null) hdate = null;
		Date hiredate = null;
		if(!"".equals(hdate) && hdate!=null) hiredate = Date.valueOf(hdate);
		List<EmpVO> emplist = empService.selectByCondition(dept, jobid, salary, hiredate);
		model.addAttribute("emplist", emplist);
		return "emp/emplist";
	}
	
	@RequestMapping("/emp/selectByDeptMany.do")
	public String selectByDeptMany(Model model, int[] deptlist) {
		System.out.println(Arrays.toString(deptlist));
		
		List<Integer> dlist = new ArrayList<>();
		for(Integer dept : deptlist) dlist.add(dept);
		
		List<EmpVO> emplist = empService.selectByDeptMany(dlist);
		model.addAttribute("emplist", emplist);
		return "emp/emplist";
	}
}
