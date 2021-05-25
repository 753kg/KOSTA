package com.kosta.sbproject.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model.DeptVO;
															// ID Type
public interface DeptRepository 
extends CrudRepository<DeptVO, Integer>, QuerydslPredicateExecutor<DeptVO>{

	public Page<DeptVO> findAll(Pageable paging);
	
	public DeptVO findByDeptname(String deptName);	// unique
	
	public List<DeptVO> findByManagerid(int managerid);
	public List<DeptVO> findByLocationid(int locationid);
	
	public List<DeptVO> findByDeptnameContaining(String str);
	public List<DeptVO> findByDeptnameStartingWith(String str);
	public List<DeptVO> findByDeptnameEndingWith(String str);
	
	@Query(value = "select tbl_dept.deptid, departments.department_name "
			+ "from tbl_dept join departments on tbl_dept.deptid = departments.department_id"
			, nativeQuery = true)
	public List<Object[]> joinWithDepartments();
}
