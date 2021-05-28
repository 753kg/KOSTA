package com.kosta.sbproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kosta.sbproject.model2.PageMaker;
import com.kosta.sbproject.model2.PageVO;
import com.kosta.sbproject.model2.WebBoard;
import com.kosta.sbproject.service.WebBoardService;

import lombok.extern.java.Log;

@Log
@Controller
public class WebBoardController {

	@Autowired
	WebBoardService service;
	
	@GetMapping("/webboard/boardlist")
	public void selectAll(Model model, PageVO pagevo) {
		Page<WebBoard> result = service.selectAll(pagevo);
		List<WebBoard> boardlist = result.getContent();
		boardlist.forEach(b -> {
			log.info(b.toString());
		});
		log.info("한페이지의사이즈" + result.getSize());
		log.info("전체페이지" + result.getTotalPages());
		
		// return type : Page<WebBoard>
		model.addAttribute("boardResult", result);
		model.addAttribute("result", new PageMaker<>(result));
	}
	
	@GetMapping("/webboard/boarddetail")
	public void selectById(Model model, long bno) {
		model.addAttribute("board", service.selectById(bno));
	}
}
