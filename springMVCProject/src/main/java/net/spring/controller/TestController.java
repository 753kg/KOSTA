package net.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.model.DeptVO;

@Controller
@RequestMapping("hello.do")	// class level(type level) , 유저가 뭐라고 요청했는지 
public class TestController {

	@RequestMapping(method=RequestMethod.GET)	// method level
	public ModelAndView helloGet() {
		ModelAndView mv = new ModelAndView();	// view에 전달하고 싶은 데이터를 model에 모두 저장
		mv.addObject("title", "hello.do를 요청했다...Get");
		mv.addObject("dept", new DeptVO(10, "개발부", 100, 1700));
		mv.setViewName("test/helloForm");	// view의 이름도 정함
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)	// 아무것도 안쓰면 get
	public ModelAndView helloPost() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "hello.do를 요청했다...Post");
		mv.addObject("dept", new DeptVO(10, "개발부", 100, 1700));
		mv.setViewName("test/helloResult");
		return mv;
	}
}
