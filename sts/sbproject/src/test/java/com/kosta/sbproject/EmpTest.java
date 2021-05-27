package com.kosta.sbproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kosta.sbproject.persistence.EmpRepository;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class EmpTest {

	@Autowired
	EmpRepository repo;
	
	@Test
	public void selectAll() {
		repo.findAll().forEach(emp -> {
			log.info(emp.toString());
		});
	}
}
