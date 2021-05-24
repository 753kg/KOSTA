package com.kosta.sbproject;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosta.sbproject.model.DeptVO;
import com.kosta.sbproject.persistence.DeptRepository;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class DeptTest {
	
	@Autowired
	DeptRepository drepo;
	
	//@Test
	public void insert() {
		DeptVO dept = new DeptVO();
		dept.setDepartment_name("인사부");
		dept.setLocation_id(12);
		dept.setManager_id(12);
		drepo.save(dept);
	}
	
	// @Test
	public void insertMultiple(@PathVariable String deptName) {
		IntStream.range(1, 4).forEach(i -> {
			DeptVO dept = new DeptVO();
			dept.setDepartment_name(deptName + i + "팀");
			dept.setLocation_id(i);
			dept.setManager_id(i);
			drepo.save(dept);
		});
	}
	
	
	// @Test
	public void deptlist() {
		drepo.findAll().forEach(dept -> {
			log.info(dept.toString());
		});
	}
	
	@Test
	public void deptById() {
		DeptVO dept = drepo.findById(112).get();
		log.info(dept.toString());
	}
	
	// @Test
	public void deptCount() {
		log.info("count: " + drepo.count());
	}
	
	// @Test
	public void updateDept() {
		drepo.findById(112).ifPresent(dept -> {
			String deptName = dept.getDepartment_name();
			dept.setDepartment_name(deptName + "_수정");
			drepo.save(dept);
		});
	}
	
	// @Test
	public void deleteDept() {
		drepo.deleteById(105);
	}
	
	
}
