package com.kosta.sbproject.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model.FreeBoard;

public interface FreeBoardRepository extends CrudRepository<FreeBoard, Long>{

	// 이름 명명규칙을 지켜야한다.
	public List<FreeBoard> findByWriter(String writer);
}
