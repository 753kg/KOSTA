package com.kosta.sbproject.model2;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.kosta.sbproject.model.FreeBoard;

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
@Table(name = "tbl_web_replies")
public class WebBoardReply {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long rno;
	
	String reply;
	String replyer;
	
	@CreationTimestamp
	Timestamp regdate;
	
	@UpdateTimestamp
	Timestamp updatedate;
	
	@ManyToOne
	WebBoard board;	// FK, board_bno 컬럼 추가됨
}
