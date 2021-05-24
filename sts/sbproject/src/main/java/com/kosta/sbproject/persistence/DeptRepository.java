package com.kosta.sbproject.persistence;

import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model.DeptVO;

public interface DeptRepository extends CrudRepository<DeptVO, Integer> {

}
