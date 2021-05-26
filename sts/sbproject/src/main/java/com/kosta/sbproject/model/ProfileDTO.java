package com.kosta.sbproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Entity
@EqualsAndHashCode(of = "fno")
@Table(name = "tbl_profile")
public class ProfileDTO {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)		// 시퀀스. 의미없는번호
	long fno;											// hibernate_sequence -> 모든 table이 공유
	
	String fname;
	boolean currentYn;
	
	// 다대일 : 여러개가 한개짜리를 참조
	@ManyToOne	// FK
	MemberDTO member;	// member를 통째로 넣으면 DB에 member_mid 컬럼이 생성됨
	
	
}
