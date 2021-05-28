package com.kosta.sbproject.lastproject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;

import com.kosta.sbproject.model2.PageVO;
import com.kosta.sbproject.model2.WebBoard;
import com.kosta.sbproject.model2.WebBoardReply;
import com.kosta.sbproject.persistence2.WebBoardRepository;
import com.querydsl.core.types.Predicate;

import lombok.extern.java.Log;

@Commit
@Log
@SpringBootTest
public class WebBoardTest {

	@Autowired
	WebBoardRepository repo;
	
	@Test
	public void pagingTest() {
		Pageable paging = PageRequest.of(0, 3, Direction.DESC, "bno");
		Page<WebBoard> result = repo.findByWriter("writer2", paging);
		List<WebBoard> blist = result.getContent();
		
		repo.findAll(paging);
	}
	
	// @Test
	public void paging() {
		Predicate p = repo.makePredicate(null, null);	// 동적 조건 조회
		
		//Pageable pageable = PageRequest.of(0, 3);
		PageVO pvo = new PageVO();
		Pageable pageable = pvo.makePaging(0, "bno");	// bno로 desc
		
		Page<WebBoard> result = repo.findAll(p, pageable); // QuerydslPredicateExecutor의 findAll()
		List<WebBoard> boardlist = result.getContent();
		boardlist.forEach(b -> {
			log.info(b.toString());
		});
		log.info("한페이지의사이즈" + result.getSize());
		log.info("전체페이지" + result.getTotalPages());
	}
	
	// @Test
	public void conditionRetrieve() {
		Predicate p = repo.makePredicate(null, null);
		Pageable pageable = PageRequest.of(0, 3);
		
		Page<WebBoard> result = repo.findAll(p, pageable); // QuerydslPredicateExecutor의 findAll()
		List<WebBoard> boardlist = result.getContent();
		boardlist.forEach(b -> {
			log.info(b.toString());
		});
		log.info("한페이지의사이즈" + result.getSize());
		log.info("전체페이지" + result.getTotalPages());
	}
	
	// @Transactional // 직접 join한 경우 안써도됨
	// @Test
	public void countBoardReply() {
		repo.getBoardReplyCount().forEach(arr -> {
			log.info(Arrays.toString(arr));
		});
	}
	
	@Transactional
	// @Test
	public void countBoardReplyByBno() {
		repo.findById(477L).ifPresent(board -> {
			log.info("댓글수: " + board.getReplies().size());
		});
	}
	
	@Transactional
	// @Test
	public void insertReply() {
		repo.findById(477L).ifPresent(board -> {
			board.setTitle("금요일좋아");
			
			// cascade
			List<WebBoardReply> replies = board.getReplies(); // lazy이므로 transactional&commit
			IntStream.range(1, 4).forEach(i -> {
				WebBoardReply wreply = WebBoardReply.builder()
						.reply("댓걸"+i)
						.replyer("writer"+i)
						.board(board)
						.build();
				replies.add(wreply);
			});
			repo.save(board);
		});
	}
	
	//@Test
	public void insertBoard() {
		IntStream.range(1, 51).forEach(i -> {
			WebBoard board = WebBoard.builder()
					.title("비" + i)
					.content("비가그침" + i)
					.writer("작성자" + i%3)
					.build();
			repo.save(board);
		});
	}
}
