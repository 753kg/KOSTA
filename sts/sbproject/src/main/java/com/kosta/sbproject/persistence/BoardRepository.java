package com.kosta.sbproject.persistence;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kosta.sbproject.model.Board;

// CrudRepository -> 기본적인 crud 자동생성
// QuerydslPredicateExecutor -> 동적 sql

public interface BoardRepository 
extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board> {
	/* 구현 클래스는 자동으로 만들어진다. */
	
	/* 기본 제공 함수
		findAll(), findById(), save(), count(), exists()....  */
	
	/* 다양한 조건으로 검색 
	 	Collection<T> findBy+컬럼명(컬럼타입 변수이름) 
	 	Collection: List, Set, Map	 				*/
	public List<Board> findByWriter(String writer);
	public List<Board> findByTitle(String title);
	public List<Board> findByContent(String content);
	
	/* LIKE */
	public List<Board> findByTitleContaining(String t);
	public List<Board> findByTitleStartingWith(String t1);
	public List<Board> findByTitleEndingWith(String title);
	
	/* AND */
	public List<Board> findByTitleEndingWithAndBnoGreaterThan(String title, long bno);
	
	/* ORDER BY */
	public List<Board> findByTitleEndingWithAndBnoGreaterThanOrderByBnoDesc(String title, long bno);
	public List<Board> findByBnoGreaterThanOrderByBnoDesc(long bno);
	
	public List<Board> findByRegdateAfter(Timestamp regdate);
	
	/* PAGING */
	public List<Board> findByBnoGreaterThanOrderByBnoDesc(long bno, Pageable paging);
	public List<Board> findByTitleEndingWithAndBnoGreaterThan(String title, long bno, Pageable paging);
	// 페이지 정보 얻기
	public Page<Board> findByTitleContaining(String title, Pageable paging);
	public Page<Board> findAll(Pageable paging);
	
	/* JPQL(Java Persistence Query Language) 
	 	-> 함수 이름은 내가 정의한다. 규칙 없음			
	 	   JPA entity를 사용	(table이름 X, entity이름 사용)	*/
	// ?1 : 첫번째 파라미터
	@Query("select b from Board b where b.title like %?1% order by b.bno desc ")
	public List<Board> findByTitle22(String title);
	
	@Query("select b from Board b where b.title like %?1%  and bno > ?2 order by b.bno desc ")
	public List<Board> findByTitleAndBno(String title, long bno);
	
	// 파라미터 : @Param 이용
	@Query("select b from Board b where b.content like %:content%  and bno > :bno order by b.bno desc ")
	public List<Board> findByContent(@Param("content") String cc, @Param("bno") long bno);

	// Entity(table) 이름 가변
	// #{#entityName} == Board
	@Query("select b from #{#entityName} b where b.writer like %?1% ")
	public List<Board> findByWriter2(String writer);
	
	// DB에 종속된 SQL문 사용 --> nativeQuery
	@Query(value = "select * from tbl_boards where writer = ?1 order by 1 ",
			nativeQuery = true)
	public List<Board> findByWriter3(String writer);
	
	// 특정 컬럼만 select할 경우 --> Object[]
	@Query(value = "select bno, substr(title, 7), concat(writer, '님') "
				+ "from tbl_boards "
				+ "where writer = ?1 order by 1 ",
			nativeQuery = true)
	public List<Object[]> findByWriter4(String writer);
	
	// 특정부서의 직원조회(직원이름, 부서이름, 급여, 입사일) JOIN
	@Query(value = "select d.department_name, e.first_name, e.salary, e.hire_date "
			+ "from employees e join departments d using(department_id)"
			, nativeQuery = true)
	public List<Object[]> selectAllEmp();

	@Query("select b from #{#entityName} b where b.writer like %?1% ")
	public Page<Board> findByWriterPaging(String writer, Pageable paging);
	
	
	
}
