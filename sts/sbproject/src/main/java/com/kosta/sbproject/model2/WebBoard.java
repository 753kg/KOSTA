package com.kosta.sbproject.model2;

import java.sql.Timestamp;
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kosta.sbproject.model.FreeBoardReply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "replies")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_webboards")
public class WebBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long bno;
	
	String title;
	String writer;
	String content;
	
	@CreationTimestamp
	Timestamp regdate;
	
	@UpdateTimestamp
	Timestamp updatedate;
	
	// toString과 유사. JSON 만들때 무한loop방지
	@JsonIgnore	// javascript 변수로 받을 때 필요
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	List<WebBoardReply> replies;
}

// [양방향]
// mappedBy : 매여있다. 
// WebBoardReply의 board 속성이 참조하고있어서 자유롭지 못하다.
// 자식이 있으면 부모는 지울 수 없다.

// [단방향]
// 중간테이블이 생긴다. 중간테이블 안만들려면 @JoinColumn 사용

// cascade : 전파

// fetch = FetchType.EAGER : select시 연관관계 테이블도 select한다.
// fetch = FetchType.LAZY : select시 연관관계 테이블은 select 안한다.

// WebBoard를 통해서 WebBoardReply에 접근&처리할때
// 1. EAGER
// 2. LAZY: 필요할 때만 @Transactional, @Commit 쓰기
