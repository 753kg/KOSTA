package com.kosta.sbproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.kosta.sbproject.model2.PageVO;
import com.kosta.sbproject.model2.WebBoard;
import com.kosta.sbproject.persistence2.WebBoardRepository;
import com.querydsl.core.types.Predicate;

import lombok.extern.java.Log;

@Log
@Service
public class WebBoardService {

	@Autowired
	WebBoardRepository repo;
	
	public Page<WebBoard> selectAll(PageVO pvo) {
		Predicate p = repo.makePredicate(pvo.getType(), pvo.getKeyword());	// 조건
		
		//PageVO pvo = new PageVO();
		//pvo.setSize(5);
		Pageable pageable = pvo.makePaging(0, "bno");	// bno로 desc
		
		Page<WebBoard> result = repo.findAll(p, pageable); 
		return result;
		
	}
	
	public WebBoard selectById(long bno) {
		return repo.findById(bno).get(); 
	}
	
	public WebBoard insertBoard(WebBoard board) {
		return repo.save(board);
	}
	
	public WebBoard updateBoard(WebBoard board) {
		return repo.save(board);	// id가 있어야 수정된다.
	}
	
	public int deleteBoard(long bno) {
		int ret = 0;
		
		try {
			repo.deleteById(bno);		
			ret = 1;
		} catch (Exception e) {}
		return ret;
	}
}
