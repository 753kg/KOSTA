package com.kosta.sbproject.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kosta.sbproject.model.FreeBoard;
import com.kosta.sbproject.model.MemberDTO;
import com.kosta.sbproject.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bservice;
	
	@GetMapping("/expression2")
	public void expression2(Model model) {
		model.addAttribute("now", new Date());
		model.addAttribute("price", 123456789);
		model.addAttribute("title", "This is just sample");
		String[] arr = {"apple","banana","orange"};
		model.addAttribute("options", Arrays.asList(arr));
	}
	
	@GetMapping("/expression")
	public void expression(Model model, HttpSession session) {
		model.addAttribute("boardlist", bservice.selectAll());
		long bno = 240L;
		model.addAttribute("board", bservice.selectById(bno));
		MemberDTO member = MemberDTO.builder()
				.mname("Hong")
				.mpassword("1234")
				.build();
		session.setAttribute("user", member);
	}
	
	@GetMapping("/freeboard/boardList")
	public String selectAll(Model model) {
		model.addAttribute("boardlist", bservice.selectAll());
		return "freeboard/boardlist";
	}
	
	@GetMapping("/freeboard/boardDetail")
	public void selectBoard(Model model, long bno) {
		// 요청이름과 html 이름이 같으면 return 안해도 됨
		model.addAttribute("board", bservice.selectById(bno));
	}
	
	@RequestMapping("/thymeleaf1")
	public void thymeleaf1() {
		// default로 페이지에 연결됨
		// templates/thymeleaf1.html 을 찾는다.
	}
	
	@RequestMapping(value = "/thymeleaf2", method = RequestMethod.GET)
	public String thymeleaf2() {
		return "thymeleaf1";
	}
	
	// 더 간단한 문법
	@GetMapping("/thymeleaf3")
	public String thymeleaf3(Model model) {
		
		FreeBoard board = FreeBoard.builder()
				.title("제목")
				.content("오늘은 비가옵니다")
				.writer("나나")
				.build();
		
		model.addAttribute("board", board);
		model.addAttribute("greeting", "안녕하세요");
		return "thymeleaf1";
	}
	
	
}
