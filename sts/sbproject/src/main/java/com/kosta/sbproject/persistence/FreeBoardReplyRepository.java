package com.kosta.sbproject.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model.FreeBoardReply;

public interface FreeBoardReplyRepository extends CrudRepository<FreeBoardReply, Long>{

	@Query(value = "select r.board_bno, count(*) from tbl_free_replies r group by r.BOARD_BNO",
			nativeQuery = true)
	public List<Object[]> countReplyWithBoard();
}
