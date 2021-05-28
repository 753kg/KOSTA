package com.kosta.sbproject.persistence2;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model2.QWebBoard;
import com.kosta.sbproject.model2.WebBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

// interface : 상수 + 추상메서드 
// static메서드(재정의불가능), default메서드
// QuerydslPredicateExecutor<T> : 동적SQL사용시
public interface WebBoardRepository 
	extends CrudRepository<WebBoard, Long>, QuerydslPredicateExecutor<WebBoard> {

	//public List<WebBoard> findByWriter(String writer, Pageable paging);
	public Page<WebBoard> findByWriter(String writer, Pageable paging);
	public Page<WebBoard> findAll(Pageable paging);
	
	// JPQL 문법
	@Query("select b.bno, count(r) "
			+ " from WebBoard b left outer join b.replies r "
			+ " group by b.bno order by b.bno")
	public List<Object[]> getBoardReplyCount();  
	
	// 조건 검색
	public default Predicate makePredicate(String type, String keyword) {
		BooleanBuilder builder = new BooleanBuilder();
		QWebBoard board = QWebBoard.webBoard;	// 객체 생성
		
		// 고정 조건
		builder.and(board.bno.gt(0));	// where bno > 0
		
		if(type == null) return builder;
		
		// 동적 조회
		switch (type) {
		case "title":
			builder.and(board.title.like("%" + keyword + "%")); // and title like '%?%'
			break;
		case "content":
			builder.and(board.content.like("%" + keyword + "%")); // and content like '%?%'
			break;
		case "writer":
			builder.and(board.writer.like("%" + keyword + "%")); // and writer like '%?%'
			break;
		default:
			break;
		}
		
		return builder;		// BooleanBuilder는 Predicate의 하위 class
	}
}
