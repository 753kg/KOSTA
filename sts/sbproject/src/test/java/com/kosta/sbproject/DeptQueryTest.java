package com.kosta.sbproject;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.kosta.sbproject.model.DeptVO;
import com.kosta.sbproject.model.QDeptVO;
import com.kosta.sbproject.persistence.DeptRepository;
import com.querydsl.core.BooleanBuilder;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class DeptQueryTest {
	
	@Autowired
	DeptRepository repo;
	
	// @Test
	public void findAllPaging() {
		Pageable paging = PageRequest.of(0, 5);
		Page<DeptVO> page = repo.findAll(paging);
		List<DeptVO> deptlist = page.getContent();
		deptlist.forEach(dept -> {
			log.info(dept.toString());
		});
	}
	
	// @Test
	public void findByDeptName() {
		DeptVO dept = repo.findByDeptname("개발부1");
		log.info(dept.toString());
	}
	
	// @Test
	public void findByDeptNameCondition() {
		//List<DeptVO> deptlist = repo.findByDeptnameContaining("개발");
		//List<DeptVO> deptlist = repo.findByDeptnameStartingWith("영업");
		List<DeptVO> deptlist = repo.findByDeptnameEndingWith("3");
		deptlist.forEach(dept -> {
			log.info(dept.toString());			
		});
	}

	// @Test
	public void findByManagerid() {
		List<DeptVO> deptlist = repo.findByManagerid(10);
		deptlist.forEach(dept -> {
			log.info(dept.toString());			
		});
	}
	
	// @Test
	public void findByLocationid() {
		List<DeptVO> deptlist = repo.findByLocationid(5);
		deptlist.forEach(dept -> {
			log.info(dept.toString());			
		});
	}
	
	// @Test
	public void queryDSL() {
		String[] types = {"deptname", "locationid"};
		String keyword = "3";
		BooleanBuilder builder = new BooleanBuilder();
		QDeptVO dept = QDeptVO.deptVO;
		for(String type : types) {
			if(type.equals("deptname")) {
				builder.and(dept.deptname.like("%" + keyword + "%"));
			}
			if(type.equals("managerid")) {
				builder.and(dept.managerid.like("%" + keyword + "%"));
			}
			if(type.equals("locationid")) {
				builder.and(dept.locationid.gt(Integer.parseInt(keyword)));
			}
		}
		
		repo.findAll(builder).forEach(d -> {
			log.info(d.toString());
		});
		
	}
	
	@Test
	public void joinWithDepartments() {
		repo.joinWithDepartments().forEach(arr -> {
			log.info(Arrays.toString(arr));
		});
	}
}
