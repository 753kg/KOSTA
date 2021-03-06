package com.kosta.springmvcproject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.business.DeptServiceInterface;
import com.kosta.business.EmpService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	EmpService empService;
	
	@Autowired
	DeptServiceInterface deptService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/friendlist.do")
	public String test(Model model) {
		// Model, View 따로
		
		List<String> flist = new ArrayList<>();
		flist.add("수지");
		flist.add("승기");
		flist.add("현빈");
		
		model.addAttribute("flist", flist);		// 데이터 저장은 model --> frontController에서 받음
		
		// view의 이름을 return --> frontController --> viewResolver에서 jsp파일 찾아줌
		return "friendlist";
	}
	
	@RequestMapping("/friendlist2.do")
	public ModelAndView test() {
		// Model-View 같이
		
		ModelAndView mv = new ModelAndView();
		
		List<String> flist = new ArrayList<>();
		flist.add("수지2");
		flist.add("승기2");
		flist.add("현빈2");
		
		mv.addObject("flist", flist);
		mv.setViewName("friendlist");		//view 이름, 접두사 접미사는 자동으로 붙음
		return mv;
	}
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("joblist", empService.selectAllJobs());
		model.addAttribute("mlist", deptService.findAllManager());
		model.addAttribute("deptlist", deptService.findAll());
		
		model.addAttribute("serverTime", formattedDate );
		
		
		return "home";
	}
	
}
