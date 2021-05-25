package com.kosta.sbproject;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.kosta.sbproject.model.Board;
import com.kosta.sbproject.persistence.BoardRepository;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class BoardTest2 {

	@Autowired
	BoardRepository repo;
	
	// @Test
	public void selectByWriter() {
		// writer가 "writer1"인 데이터 검색
		repo.findByWriter("writer1").forEach(data -> {
			log.info(data.toString());
		});
	}
	
	// @Test
	public void selectByTitle() {
		repo.findByTitle("board title1").forEach(data -> {
			log.info(data.toString());
		});
	}

	// @Test
	public void selectByContent() {
		repo.findByContent("board content1").forEach(data -> {
			log.info(data.toString());
		});
	}
	
	// @Test
	public void titleContaining() {
		// title에 "title2"가 들어간 데이터 조회
		// where title like '%title2%'
		repo.findByTitleContaining("title2").forEach(data -> {
			log.info(data.toString());
		});
	}
	
	// @Test
	public void titleStartingWith() {
		// where title like '게시물%'
		repo.findByTitleStartingWith("게시물").forEach(data -> {
			log.info(data.toString());
		});
	}
	
	// @Test
	public void titleEndingWith() {
		// where title like '%2'
		repo.findByTitleEndingWith("2").forEach(data -> {
			log.info(data.toString());
		});
	}
	
	// @Test
	public void TitleEndingWithAndBnoGreaterThan() {
		// where title like '%2' and bno > 50
		repo.findByTitleEndingWithAndBnoGreaterThan("2", 50L).forEach(data -> {
			log.info(data.toString());
		});
	}
	
	//@Test
	public void TitleEndingWithAndBnoGreaterThanOrderBy() {
		// where title like '%2' and bno > 50 order by bno desc
		repo.findByTitleEndingWithAndBnoGreaterThanOrderByBnoDesc("2", 50L).forEach(data -> {
			log.info(data.toString());
		});
	}
	
	//@Test
	public void BnoGreaterThanOrderBy() {
		// where bno > 50 order by bno desc
		repo.findByBnoGreaterThanOrderByBnoDesc(50L).forEach(data -> {
			log.info(data.toString());
		});
	}
	
	// @Test
	public void RegdateAfter() {
		// where regdate > ?
		Timestamp regdate = new Timestamp(System.currentTimeMillis());
		log.info(regdate.toString());
		repo.findByRegdateAfter(regdate).forEach(data -> {
			log.info(data.toString());
		});
	}
	
	// @Test
	public void paging() {
		log.info("0page -----------------------");
		Pageable paging = PageRequest.of(0, 5);
		List<Board> boardlist = repo.findByBnoGreaterThanOrderByBnoDesc(10, paging);
		boardlist.forEach(board -> {
			log.info(board.toString());
		});
		log.info("1page -----------------------");
		Pageable paging2 = PageRequest.of(1, 5);
		List<Board> boardlist2 = repo.findByBnoGreaterThanOrderByBnoDesc(10, paging2);
		boardlist2.forEach(board -> {
			log.info(board.toString());
		});
		log.info("2page -----------------------");
		paging2 = PageRequest.of(2, 5);
		boardlist2 = repo.findByBnoGreaterThanOrderByBnoDesc(10, paging2);
		boardlist2.forEach(board -> {
			log.info(board.toString());
		});
	}
	
	// @Test
	public void paging2() {
		log.info("0page -----------------------");
		Pageable paging = PageRequest.of(0, 5, Direction.DESC, "bno");
		List<Board> boardlist = repo.findByTitleEndingWithAndBnoGreaterThan("2", 10, paging);
		boardlist.forEach(board -> {
			log.info(board.toString());
		});
		log.info("1page -----------------------");
		paging = PageRequest.of(1, 5, Direction.DESC, "bno");
		boardlist = repo.findByTitleEndingWithAndBnoGreaterThan("2", 10, paging);
		boardlist.forEach(board -> {
			log.info(board.toString());
		});
	}
	
	// @Test
	public void pageInfo() {
		log.info("0page -----------------------");
		Pageable paging = PageRequest.of(0, 3);
		Page<Board> page = repo.findByTitleContaining("2", paging);
		
		log.info("page size: " + page.getSize()); 				// 한 페이지의 크기
		log.info("total pages: " + page.getTotalPages()); 		// 전체 페이지 수
		log.info("total elements: " + page.getTotalElements());	// 총 데이터 수
		log.info("previous: " + page.previousPageable());
		log.info("next: " + page.nextPageable());
		
		page.getContent().forEach(board -> {
			log.info(board.toString());
		});
	}
	
	@Test
	public void paging3() {
		log.info("0page -----------------------");
		Pageable paging = PageRequest.of(0, 3);
		Pageable paging2 = PageRequest.of(0, 3, Direction.DESC, "bno");
		Pageable paging3 = PageRequest.of(0, 3, Sort.by("bno").descending());
		
		Page<Board> page = repo.findAll(paging3);
		List<Board> boardlist = page.getContent();
		boardlist.forEach(board -> {
			log.info(board.toString());
		});
	}
}
