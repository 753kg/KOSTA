package com.kosta.sbproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("pagevo", pagevo);	// keyword, type 정보
	}
	
	@GetMapping("/webboard/register")
	public void boardRegister() {
		
	}
	
	@PostMapping("/webboard/register")
	public String boardRegisterPost(WebBoard board, RedirectAttributes rttr) {
		log.info(board.toString());
		
		WebBoard result = service.insertBoard(board);
		String message = "입력성공";
		if(result == null) message = "입력실패";
		
		// redirect할 때 가져가고싶은 값
		// addFlashAttribute : 주소창에 보이지않고 전달됨
		rttr.addFlashAttribute("resultMessage", message);
		return "redirect:/webboard/boardlist";
	}
	
	@GetMapping("/webboard/boarddetail")
	public void selectById(Model model, long bno, PageVO pagevo) {
		model.addAttribute("board", service.selectById(bno));
		model.addAttribute("pagevo", pagevo);
	}
	
	@GetMapping("/webboard/delete")
	public String boardDelete(long bno) {
		int result = service.deleteBoard(bno);
		log.info(result == 1 ? "삭제성공":"삭제실패");
		return "redirect:/webboard/boardlist";
	}
	
	@PostMapping("/webboard/update")
	public String boardUpdate(WebBoard board) {
		WebBoard result = service.updateBoard(board);
		log.info(result == null ? "수정실패":"수정성공");
		return "redirect:/webboard/boardlist";
	}
}
