package com.kosta.sbproject.persistence;

import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model.EmpVO;

public interface EmpRepository extends CrudRepository<EmpVO, Integer>{

}
