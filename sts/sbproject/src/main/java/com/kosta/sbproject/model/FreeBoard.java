package com.kosta.sbproject.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "replies")	// toString할 때 replies 빼기 (양방향 관계일 때 무한루프 방지)
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_freeboards")
public class FreeBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long bno;
	
	String title;
	String writer;
	String content;
	
	@CreationTimestamp	// create시 자동으로 들어감
	Timestamp regdate;	// regDate --> table엔 reg_date
						// Repository에서 변수이름 사용시 주의 findByRegDate (대문자시작,변수이름그대로)
	
	@UpdateTimestamp	// update시 자동으로 들어감
	Timestamp updatedate;
	
	// 하나의 게시글은 여러개의 댓글을 가지고있음
	// mappedBy = "board" : FreeBoardReply의 board에 매여있다. 댓글이 있으면 게시글을 지울수없다.
	@OneToMany(mappedBy = "board", 
			cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)			// LAZY면 board로 reply insert가 안된다. @Transactional 적어주면 됨
	@JsonIgnore
	List<FreeBoardReply> replies;
			//fetch = FetchType.EAGER) --> 권장하지않음. 필요할때만 쓰도록
}
