package com.kosta.sbproject;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.kosta.sbproject.model.Board;
import com.kosta.sbproject.model.QBoard;
import com.kosta.sbproject.persistence.BoardRepository;
import com.querydsl.core.BooleanBuilder;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class BoardQueryTest {
	
	@Autowired
	BoardRepository repo;
	
	@Test
	public void test9() {
		// 빌더 생성
		String type = "writer";	// 조회할 타입
		String keyword = "9";	// 조회조건: 9가 들어간 것
		BooleanBuilder builder = new BooleanBuilder();
		QBoard board = QBoard.board;
		if(type.equals("title")) {
			builder.and(board.title.like("%"+keyword+"%"));
		} else if(type.equals("content")) {
			builder.and(board.content.like("%"+keyword+"%"));
		} else if(type.equals("writer")) {
			builder.and(board.writer.like("%"+keyword+"%"));
		}
		builder.and(board.bno.gt(50L));		// AND 50보다 큰 것
		
		// 빌더 호출
		Pageable paging = PageRequest.of(0, 5);
		Page<Board> result = repo.findAll(builder, paging);
		List<Board> blist = result.getContent();
		blist.forEach(b -> {
			log.info(b.toString());
		});
	}

	//@Test
	public void test8() {
		Pageable paging = PageRequest.of(0, 3);
		Page<Board> result = repo.findByWriterPaging("8", paging);
		List<Board> blist = result.getContent();
		for(Board b : blist) {
			log.info(b.toString());
		}
		
		log.info("page size: " + result.getSize()); 				// 한 페이지의 크기
		log.info("total pages: " + result.getTotalPages()); 		// 전체 페이지 수
		log.info("total elements: " + result.getTotalElements());	// 총 데이터 수
		log.info("previous: " + result.previousPageable());
		log.info("next: " + result.nextPageable());
	}
	
	// @Test
	public void test7() {
		repo.selectAllEmp().forEach(arr -> {
			log.info(Arrays.toString(arr));
			log.info("직원이름: " + arr[1]);
		});
	}
	
	// @Test
	public void test6() {
		repo.findByWriter4("writer2").forEach(arr -> {
			log.info(Arrays.toString(arr));
		});
	}
	
	// @Test
	public void test5() {
		repo.findByWriter3("writer2").forEach(board -> {
			log.info(board.toString());
		});
	}
	
	// @Test
	public void test4() {
		repo.findByWriter2("2").forEach(board -> {
			log.info(board.toString());
		});
	}
	
	// @Test
	public void test3() {
		repo.findByContent("2", 70L).forEach(board -> {
			log.info(board.toString());
		});
	}
	
	// @Test
	public void test2() {
		repo.findByTitleAndBno("2", 50L).forEach(board -> {
			log.info(board.toString());
		});
	}

	//@Test
	public void test1() {
		repo.findByTitle("2").forEach(board -> {
			log.info(board.toString());
		});
	}
}
