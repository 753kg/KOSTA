package com.kosta.sbproject;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kosta.sbproject.model.DeptVO;
import com.kosta.sbproject.persistence.DeptRepository;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class DeptTest {
	
	// DI
	@Autowired
	DeptRepository drepo;
	
	// @Test
	public void insert() {
		DeptVO dept = new DeptVO();
		dept.setDeptname("인사부");
		dept.setLocationid(12);
		dept.setManagerid(12);
		drepo.save(dept);
	}
	
	@Test
	public void insertMultiple() {
		IntStream.range(1, 11).forEach(i -> {
			// 안정적으로 생성
			DeptVO dept = DeptVO.builder()
					.deptname("영업부" + i)
					.managerid(i+4)
					.locationid(i)
					.build();
			drepo.save(dept);
		});
		
		/*
		IntStream.range(21, 31).forEach(i -> {
			DeptVO dept = new DeptVO();
			dept.setDepartment_name("부서" + i);
			dept.setLocation_id(i);
			dept.setManager_id(i+10);
			drepo.save(dept);
		});
		
		for(int i=31; i<41; i++) {
			// 생성자 순서 주의
			DeptVO dept = new DeptVO(i, "개발부" + i, i, i+10);
			drepo.save(dept);
		}
		*/
	}
	
	
	// @Test
	public void deptlist() {
		// List<DeptVO> deptlist = (List<DeptVO>) drepo.findAll();
		
		drepo.findAll().forEach(dept -> {
			log.info(dept.toString());
		});
	}
	
	// @Test
	public void deptById() {
		Optional<DeptVO> dept = drepo.findById(135);
		dept.ifPresent(d -> {
			// 존재하면 출력
			log.info(d.toString());			
		});
	}
	
	// @Test
	public void updateDept() {
		drepo.findById(135).ifPresent(dept -> {
			String deptName = dept.getDeptname();
			dept.setDeptname(deptName + "_수정");
			drepo.save(dept);
		});
	}
	
	// @Test
	public void deleteDept() {
		drepo.deleteById(134);
	}
	
	// @Test
	public void existDept() {
		boolean result = drepo.existsById(134);
		log.info(result?"존재함":"존재하지않음");
	}
	
	// @Test
	public void deptCount() {
		long rowCount = drepo.count();
		log.info("count: " + rowCount);
	}
	
	
}
