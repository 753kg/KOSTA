package com.kosta.sbproject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.kosta.sbproject.model.FreeBoard;
import com.kosta.sbproject.model.FreeBoardReply;
import com.kosta.sbproject.persistence.FreeBoardReplyRepository;
import com.kosta.sbproject.persistence.FreeBoardRepository;

import lombok.extern.java.Log;

@Commit
@Log
@SpringBootTest
public class FreeBoardTest {

	@Autowired
	FreeBoardRepository boardRepo;
	
	@Autowired
	FreeBoardReplyRepository replyRepo;
	
	@Test
	public void selectAllReplies() {
		// 보드 별 reply count
		replyRepo.countReplyWithBoard().forEach(arr -> {
			log.info(Arrays.toString(arr));
		});
	}
	
	// @Test
	public void selectBoardByWriter() {
		// 작성자가 writer9인 board 출력
		boardRepo.findByWriter("writer9").forEach(b -> {
			log.info(b.toString());
		});
	}
	
	// @Test
	public void selectAllBoard() {
		boardRepo.findAll().forEach(b -> {
			log.info(b.toString());		// [무한루프] board에서 reply toString <-> reply에서 board toString
		});
	}
	
	// @Test
	public void insertBoard() {
		IntStream.range(1, 201).forEach(i -> {
			FreeBoard board = FreeBoard.builder()		// 빌더패턴
					.title("FreeBoard title" + i)
					.content("FreeBoard content" + i)
					.writer("writer" + i % 10)
					.build();
			boardRepo.save(board);
		});
	}
	
	// @Transactional사용하면 종료 후 rollback한다. class level에 @Commit 필요
	@Transactional	// fetch가 LAZY(지연실행)인 경우 반드시 사용, EAGER(즉시실행)인 경우엔 미사용
	//@Test
	public void insertBoardReply() {
		boardRepo.findById(410L).ifPresent(b -> {
			List<FreeBoardReply> rlist = b.getReplies();
			IntStream.range(1, 11).forEach(i -> {
				FreeBoardReply reply = FreeBoardReply.builder()
										.reply("###댓글작성410..내용")
										.replyer("##댓글410..작성자" + i)
										.board(b)	// 양방향이라 댓글에도 보드를 넣어줘야함
										.build();
				rlist.add(reply);
			});
			boardRepo.save(b);
		});
	}
	
	@Transactional	// LAZY일 경우 써줘야 reply 결과 나옴
	// @Test
	public void getBoardInfoWithReplyCount() {
		boardRepo.findById(410L).ifPresent(b -> {
			log.info(b.getReplies().size() + "개의 댓글");
		});
	}
}
