package com.kosta.sbproject;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kosta.sbproject.model.Board;
import com.kosta.sbproject.persistence.BoardRepository;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class BoardTest {

	@Autowired
	BoardRepository boardrepo;
	
	// @Test
	public void repoInfo() {
		Class<?> bclass = boardrepo.getClass();
		System.out.println("bclass.getName: " + bclass.getName());
		System.out.println("bclass.getSuperclass: " + bclass.getSuperclass().getName());
		Class<?>[] interf = bclass.getInterfaces();
		Stream.of(interf).forEach(inter -> {
			System.out.println("inter.getName: " + inter.getName());
		});
	}
	
	// @Test
	public void insert() {
		Board b = new Board();
		b.setTitle("게시물의 제목2");
		b.setContent("게시물의 내용2");
		b.setWriter("작성자2");
		boardrepo.save(b);
	}
	
	// @Test
	public void insertMultiple() {
		// 1부터 100번 실행
		IntStream.range(1, 101).forEach(i -> {
			Board b = new Board();
			b.setTitle("board title" + i);
			b.setContent("board content" + i);
			b.setWriter("writer" + i%10);
			boardrepo.save(b);
		});
	}
	
	// @Test
	public void selectAll() {
		boardrepo.findAll().forEach(board -> {
			System.out.println(board);
		});
	}
	
	// @Test
	public void selectById() {
		Board b = boardrepo.findById(10L).get();
		log.info(b.toString());
	}
	
	// @Test
	public void update() {
		// boardrepo.existsById(10L)
		// 10번이 존재할 때만 update
		boardrepo.findById(10L).ifPresent(board -> {
			board.setTitle("title 수정");
			board.setContent("content 수정");
			board.setWriter("chaeyeon");
			boardrepo.save(board);
		});
	}
	
	// @Test
	public void delete() {
		long id = 10L;
		//if(boardrepo.findById(id).isPresent()) {	// true
			boardrepo.deleteById(id);			
		//}
	}
	
	@Test
	public void countBoard() {
		long cnt = boardrepo.count();
		log.info("board 건수: " + cnt);
	}
}
