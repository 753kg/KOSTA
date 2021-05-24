package com.kosta.sbproject.persistence;

import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
