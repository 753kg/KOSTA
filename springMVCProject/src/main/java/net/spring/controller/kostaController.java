package net.spring.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.model.DeptDAO;
import com.kosta.model.EmpDAO;
import com.kosta.model.UserVO;

@Controller
public class kostaController {

	// 맵핑 주소 여러개
	@RequestMapping(value= {"/sample1.do","/test/sample2.do"})
	public ModelAndView test1() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "맵핑 주소를 여러개 사용가능하다.");
		// 페이지 이름이 없다면 default로 요청 주소 이름이 사용된다.
		// ex) sample1.do      --> WEB-INF/views/sample1.jsp
		//     test/sample2.do --> WEB-INF/views/test/sample2.jsp
		return mv;
	}
	/*
																//userpass가 존재, email은 존재X
	@RequestMapping(value = "sample3.do", params = {"userid=abc", "userpass", "!email"})
	public ModelAndView test2() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "맵핑 주소에 param 사용하기");
		mv.setViewName("sample3Result");
		return mv;
	}
	*/
	
	// 요청할 때 파라미터가 넘어옴
	@RequestMapping(value = "sample3.do")
	public ModelAndView test2(
			// 넘어온 변수와 내가 사용하는 변수 이름이 다를때 @RequestParam 붙여줌. 같을 땐 안붙여도된다.
			// int는 자동으로 parseInt 됨. 숫자형 문자가 아닐 경우 오류
			@RequestParam("userid") String id, int userpass, String email,
			HttpServletRequest request,
			Map<String, Object> userinfo,
			UserVO user) { 
		
		System.out.println("id= " + id);
		System.out.println("userpass= " + userpass);
		System.out.println("email= " + email);
		System.out.println("userinfo= " + userinfo);
		System.out.println("user= " + user);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "파라미터 받기");
		mv.addObject("id", id);
		mv.addObject("userpass", userpass);
		mv.addObject("email", email);
		
		String email2 = request.getParameter("email");
		mv.addObject("email2", email2);
		
		mv.addObject("userinfo", userinfo);
		mv.addObject("user", user);
		
		mv.setViewName("sample3Result");
		return mv;
	}
	
	// return이 String : 페이지 이름이 return.. 해당 page로 forward
	// Model : page에 전달
	@RequestMapping(value = "sample4.do")
	public String test4(Model model, String myname, HttpSession session) {
		model.addAttribute("title", "page 이름 return 방법");
		System.out.println("myname= " + myname);	// 주소창에서 sample4.do?myname=
		
		UserVO user = new UserVO();
		user.setEmail("request에 저장한 이메일");
		model.addAttribute("user", user);

		UserVO user2 = new UserVO();
		user2.setEmail("세션에 저장한 이메일");
		session.setAttribute("user", user2);	// 페이지에서는 가까운 request의 user를 쓴다.
		return "sample3Result";
	}
	
	@RequestMapping(value = "sample5.do")
	public void test5(HttpServletRequest request, HttpSession session) {
		String cpath = request.getContextPath();
		System.out.println("ContextPath: " + cpath);	// /springmvcproject
		System.out.println("요청방식: " + request.getMethod());
		System.out.println("url: " + request.getRequestURL()); // http://localhost:9090/springmvcproject/sample5.do
		System.out.println("현재경로: " + session.getServletContext().getRealPath(".")); // C:\GitRepository\KOSTA\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\springMVCProject
		// return 안하면 자동으로 sample5.jsp와 연결
	}
	
	@RequestMapping(value = "sample6.do")
	@ResponseBody	// 웹페이지 body에 문자를 씀. 단순하게 문자만 쓸 때. ajax할 때 좋다.
	public String test6() {
		return "hello~";
	}
	
	@Autowired
	EmpDAO empDAO;
	
	@Autowired
	DeptDAO deptDAO;	// new DeptDAO() 해서 여기로 들어온다.
	
	@RequestMapping("emp/allmanager.do")
	public String allmanager(Model mydata) {
		mydata.addAttribute("mlist", deptDAO.selectAllManager());
		return "emp/allmanager";
	}
	
	@RequestMapping("emp/alldeptlist.do")
	public String alldeptlist(Model mydata) {
		System.out.println(deptDAO.selectAll());
		mydata.addAttribute("dlist", deptDAO.selectAll());
		return "emp/alldeptlist";
	}
	
	@RequestMapping("emp/empByDept.do")
	public String empByDept(Model mydata, int deptid) {
		mydata.addAttribute("emplist", empDAO.selectByDept(deptid));
		return "emp/emplist";
	}
	
	@RequestMapping("emp/alljoblist.do")
	public String alljoblist(Model mydata) {
		mydata.addAttribute("jlist", empDAO.selectAllJobs());
		return "emp/alljoblist";
	}
	
	@RequestMapping("emp/empByJob.do")
	public String empByDept(Model mydata, String jobid) {
		mydata.addAttribute("emplist", empDAO.selectByJob(jobid));
		return "emp/emplist";
	}
	
	@RequestMapping("emp/errorTest.do")
	public void errorTest() throws IOException {
		// 1. 연산 오류
		//int a = 10 / 0;
		//System.out.println(a);
		
		// 2. 연산 오류 아닌 기타 오류
		ClassPathResource resource = new ClassPathResource("!!!!oracledb.properties");
		System.out.println(resource.getFilename());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		String s;
		while((s = br.readLine()) != null){
			System.out.println(s);			
		}
		br.close();
	}
	
}
