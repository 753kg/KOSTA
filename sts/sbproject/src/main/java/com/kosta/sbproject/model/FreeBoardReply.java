package com.kosta.sbproject.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "board")	// toString할 때 board 빼기 (양방향 관계일 때 무한루프 방지)
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "rno")
@Table(name = "tbl_free_replies")
public class FreeBoardReply {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long rno;
	
	String reply;
	String replyer;
	
	@CreationTimestamp	// create시 자동으로 들어감
	Timestamp regdate;	// regDate --> table엔 reg_date
						// Repository에서 변수이름 사용시 주의 findByRegDate (대문자시작,변수이름그대로)
	
	@UpdateTimestamp	// update시 자동으로 들어감
	Timestamp updatedate;
	
	// 여러개의 댓글은 하나의 게시글을 참조
	@ManyToOne
	FreeBoard board;	// FK, board_bno 컬럼 추가됨
}
