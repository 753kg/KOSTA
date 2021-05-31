package com.kosta.sbproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.sbproject.model2.WebBoard;
import com.kosta.sbproject.model2.WebBoardReply;
import com.kosta.sbproject.service.WebBoardReplyService;

import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/replies/*")
public class WebBoardReplyController {
	
	@Autowired
	WebBoardReplyService service;

	
	/* 이거는 됨
	@GetMapping("/{bno}")
	public void selectAll(@PathVariable long bno) {
		WebBoard board = WebBoard.builder().bno(bno).build();
		List<WebBoardReply> list = service.selectAll(board);
		list.forEach(reply -> {
			log.info(reply.toString());
		});
	}
	*/
	
	// bno 게시글의 댓글 모두 조회
	@GetMapping("/board/{bno}")
	public ResponseEntity<List<WebBoardReply>> selectAll(@PathVariable long bno) {
		WebBoard board = WebBoard.builder().bno(bno).build();
		// HttpStatus.OK : 조회가 잘 끝났는지 상태값 return
		return new ResponseEntity<>(service.selectAll(board), HttpStatus.OK);
	}
	
	//특정 댓글 조회
	@GetMapping("/{rno}")
	public ResponseEntity<WebBoardReply> viewReply(@PathVariable Long rno) {
		return new ResponseEntity<>(service.selectById(rno), HttpStatus.OK);
	}
	
	// 댓글 입력
	@PostMapping("/{bno}")
	public ResponseEntity<List<WebBoardReply>> addReply(@PathVariable long bno,
			@RequestBody WebBoardReply reply) {
		WebBoard board = WebBoard.builder().bno(bno).build();
		reply.setBoard(board);
		service.updateOrInsert(reply);
		
		// 다시 조회
		return new ResponseEntity<>(service.selectAll(board), HttpStatus.CREATED);
	}

	// 수정
	@PutMapping("/{bno}")
	public ResponseEntity<List<WebBoardReply>> update(@PathVariable long bno, 
			@RequestBody WebBoardReply reply) {
		WebBoard board = WebBoard.builder().bno(bno).build();
		//reply.setRno(rno);
		reply.setBoard(board);
		service.updateOrInsert(reply);
		return new ResponseEntity<>(service.selectAll(board), HttpStatus.OK);
	}

	@DeleteMapping("/{bno}/{rno}")
	public ResponseEntity<List<WebBoardReply>> deleteByRno(@PathVariable long rno, 
			@PathVariable long bno) {
		service.delete(rno);
		WebBoard board = WebBoard.builder().bno(bno).build();
		return new ResponseEntity<>(service.selectAll(board), HttpStatus.OK);
	}
	
}
