package com.kosta.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.business.EmpService;
import com.kosta.model.EmpVO;
import com.kosta.model.UserVO2;

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
	
	// 조회 목적이므로 GET 사용
										// REST 파라미터 형태
	@RequestMapping(value = "/login3.do/{userid}/{userpw}/{address}/{phone}",
			method = RequestMethod.GET,
			produces = "application/json;charset=utf-8")
	public EmpVO login(@PathVariable("userid") int userid, @PathVariable String userpw,
						@PathVariable String address, @PathVariable String phone) {
		
		EmpVO emp = empService.loginChk(userid, userpw);
		
		logger.info("아이디는 {} 비밀번호는 {}", userid, userpw);
		logger.info("주소는 {} 전화번호는 {}", address, phone);
		
		return emp;
	}
	
	// 목적
	// get : 조회 , post : insert , put: 수정, delete : 삭제
	// get : url 자동 인코딩
	// post : url에 정보 노출 X, 요청 문서의 body 부분에 encoding없이 간다.
	/* @RequestMapping(value = "/login3.do", method = RequestMethod.POST ,produces = "application/json;charset=utf-8")
	public EmpVO login(@RequestBody UserVO2 user) {
		
		EmpVO emp = empService.loginChk(user.getUserid(), user.getUserpw());
		
		logger.info("user: {}", user);
		
		return emp;
	}
	 */
	
	// 삭제
	// return 값에 한글이 있으면 produces 해주기
	@RequestMapping(value = "/empDelete.do/{userid}", method = RequestMethod.DELETE,
			produces = "text/plain;charset=UTF-8")
	public String delete(@PathVariable("userid") int userid) {
		
		int result = empService.deleteEmp(userid);
		
		logger.info("삭제할 아이디는 {}", userid);
		
		return result>0? "삭제완료":"삭제실패";
	}
	
	@RequestMapping(value = "/empUpdate.do", method = RequestMethod.PUT,
			produces = "text/plain;charset=UTF-8")
	public String update(@RequestBody EmpVO emp) {
		
		logger.info("수정할 아이디는 {}", emp.toString());
		int result = empService.updateEmp(emp);
		
		
		return result>0? "수정완료":"수정실패";
	}
	
	@RequestMapping(value = "/selectByDept.do/{deptid}",
			method = RequestMethod.GET,
			produces = "application/json;charset=utf-8")
	public List<EmpVO> selectByDept(@PathVariable("deptid") int deptid) {
		
		logger.info("{}번 부서의 직원 조회", deptid);
		List<EmpVO> emplist = empService.selectByDept(deptid);
		
		return emplist;
	}
	
	@RequestMapping(value = "/selectBySalary.do/{minsal}/{maxsal}",
			method = RequestMethod.GET,
			produces = "application/json;charset=utf-8")
	public List<EmpVO> selectBySalary(@PathVariable int minsal, @PathVariable int maxsal) {
		
		logger.info("minsal: {}, maxsal: {}", minsal, maxsal);
		List<EmpVO> emplist = empService.selectBySalary(minsal, maxsal);
		
		return emplist;
	}
	
	@RequestMapping(value = "/selectByDate.do/{sdate}/{edate}",
			method = RequestMethod.GET,
			produces = "application/json;charset=utf-8")
	public List<EmpVO> selectByDate(@PathVariable String sdate, @PathVariable String edate) {
		
		logger.info("sdate: {}, edate: {}", sdate, edate);
		List<EmpVO> emplist = empService.selectByDate(sdate, edate);
		
		return emplist;
	}
	
	@RequestMapping(value = "/selectByDate2.do/{sdate}/{edate}",
			method = RequestMethod.GET,
			produces = "application/json;charset=utf-8")
	public List<EmpVO> selectByDate2(@PathVariable Date sdate, @PathVariable Date edate) {
		
		logger.info("sdate: {}, edate: {}", sdate, edate);
		List<EmpVO> emplist = empService.selectByDate2(sdate, edate);
		
		return emplist;
	}
	
	@RequestMapping(value = "/selectByDynamic.do/{deptid}/{jobid}/{sal}/{hdate}/{chk}",
			method = RequestMethod.GET,
			produces = "application/json;charset=utf-8")
	public List<EmpVO> selectByDynamic(@PathVariable String deptid, @PathVariable String jobid,
			@PathVariable String sal, @PathVariable String hdate, @PathVariable boolean chk) {
		
		int dept = Integer.parseInt(deptid);
		int salary = Integer.parseInt(sal);
		if("null".equals(jobid)) jobid = null;
		if("null".equals(hdate)) hdate = null;
		// 날짜제외를 누르면
		if(chk) hdate = null;
		Date hiredate = null;
		if(hdate!=null) hiredate = Date.valueOf(hdate);
		
		logger.info("dept: *" + deptid + "*");
		logger.info("jobid: *" + jobid + "*");
		logger.info("salary: *" + sal + "*");
		logger.info("hiredate: *" + hiredate + "*");
		
		List<EmpVO> emplist = empService.selectByCondition(dept, jobid, salary, hiredate);
		
		return emplist;
	}
}
