package com.kosta.sbproject;

import java.sql.Date;
import java.util.List;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.kosta.sbproject.model.EmpVO;
import com.kosta.sbproject.persistence.DeptRepository;

import lombok.extern.java.Log;

@Log
@Commit
@SpringBootTest
public class DeptEmpTest {

	@Autowired
	DeptRepository deptRepo;
	
	@Transactional
	@Test
	public void insertDeptEmp() {
		// 200번 부서에 직원 10명 입력하기
		// 부서테이블에서 emplist 추가하면 직원테이블에도 자동으로 추가
		deptRepo.findById(190).ifPresent(dept -> {
			List<EmpVO> emplist = dept.getEmplist();	// 주소를 알고있어서 dept.setEmplist 안해도 변경사항이 저장된다.
			IntStream.range(1, 11).forEach(i -> {
				EmpVO emp = EmpVO.builder()
						.employeeId(i+100)
						.firstName("직원" + i)
						.lastName("가산")
						.commissionPct(0.2)
						.email("aea@daum.com")
						.hireDate(new Date(System.currentTimeMillis()))
						.jobId("IT_PROG")
						.managerId(100)
						.phoneNumber("010-1234-567" + i)
						.salary(2000)
						.department(dept)	// 양방향이라서 줘야함!!
						.build();
				emplist.add(emp);
			});
			deptRepo.save(dept);
		});
	}
}
