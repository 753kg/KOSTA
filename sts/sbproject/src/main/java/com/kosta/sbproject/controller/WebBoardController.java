package com.kosta.sbproject.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

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
	
	@GetMapping("/webboard/boardlist")   //방법2 PageVO pagevo param방법
	public void selectAll(Model model,PageVO pagevo , HttpServletRequest request ) {
		
		/* 방법1 rttr getAttribute
		Map<String, ?> flashMap =RequestContextUtils.getInputFlashMap(request);
        
        if(flashMap!=null) {
            
            PageVO p =(PageVO)flashMap.get("pagevo");
            System.out.println("flashMap p:" + p);
        }
        */
		Page<WebBoard> result = service.selectAll(pagevo);
		 
		List<WebBoard> boardlist = result.getContent();
				
		model.addAttribute("boardResult", result);
		model.addAttribute("pagevo", pagevo);
		model.addAttribute("result", new PageMaker<>(result));
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
	public String boardUpdate(WebBoard board, Integer page, Integer size, String type, String keyword, RedirectAttributes rttr) {
		WebBoard result = service.updateBoard(board);
		log.info(result == null ? "수정실패":"수정성공");
		
		/* 방법1. 주소창에 안보임
		PageVO pagevo = new PageVO();
		pagevo.setPage(page);
		pagevo.setSize(size);
		pagevo.setType(type);
		pagevo.setKeyword(keyword);
		//rttr.addFlashAttribute("pagevo", pagevo);
		*/
		// 방법2. 주소창에 보임
		String param = "page=" + page + "&size=" + size + "&type=" + type + "&keyword=" + keyword;
		log.info(param);
		return "redirect:/webboard/boardlist?" + param;
	}
}
