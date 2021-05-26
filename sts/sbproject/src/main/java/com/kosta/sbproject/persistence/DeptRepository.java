package com.kosta.sbproject.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kosta.sbproject.model.Board;
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
	
	// VO의 필드이름 쓰기
	@Query("select dept from DeptVO dept where deptid > 0 order by deptid desc ")
	public List<DeptVO> selectAll();
	
	@Query("select dept from DeptVO dept where deptid > ?1 order by deptid desc ")
	public List<DeptVO> selectById(int id);
	
	// Param
	@Query("select dept from DeptVO dept where deptid > :deptid order by deptid desc ")
	public List<DeptVO> selectByIdParam(@Param("deptid") int id);
	
	// Entity
	@Query("select dept from #{#entityName} dept where deptid > :deptid order by deptid desc ")
	public List<DeptVO> selectByIdEntity(@Param("deptid") int id);
	
	// DB SQL 문장 사용
	@Query(value = "select * from tbl_dept where deptid > ?1 order by 1 desc "
			, nativeQuery = true)
	public List<DeptVO> selectByIdSQL(int id);
	
	@Query(value = "select tbl_dept.deptid, departments.department_name "
			+ "from tbl_dept join departments on tbl_dept.deptid = departments.department_id"
			, nativeQuery = true)
	public List<Object[]> joinWithDepartments();
}
