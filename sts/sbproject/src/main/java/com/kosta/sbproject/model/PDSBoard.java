package com.kosta.sbproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString 
@Entity @Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "pid")
@Table(name = "tbl_pdsboard")
public class PDSBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long pid;
	String pname;
	String pwriter;
	
	// 일대다 : pdsboard가 여러개의 첨부file을 가짐
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pdsno")
	List<PDSFile> file2;
	
	/* @OneToMany : 기본적으로 중간테이블이 생긴다. (다치불가: 한 컬럼에 값 여러개 불가능) 
					tbl_pdsboard_file2이 생성됨
					@JoinColumn 속성을 주면 중간테이블 안생김
					
	   @JoinColumn(name = "pdsno") --> PDSFile 테이블에 pdsno(=pid) 컬럼이 생긴다.
									   PDSBoard 테이블은 변경사항이 없다.
	   cascade = CascadeType.ALL
	   영속전이 : 부모 또는 자식이 변경되면 연관관계 엔티티에 모두 영향을 준다.
	   board에 file이 추가되면 file table에 자동으로 pdsno 추가
	   
	   fetch = FetchType.EAGER : 즉시 실행
	   PDSBoard toString 호출 시 PDSFile의 toString도 부름
	   fetch = FetchType.LAZY : 지연 실행(default)
	   PDSBoard toString 호출 못함. PDSFile을 안만들기 때문에 실패
	   --> JPQL 이용한 메서드 만들면 (쿼리 직접 작성) LAZY여도 실행가능
	*/
}
