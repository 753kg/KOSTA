package com.kosta.sbproject.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_boards")
public class Board {

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
}
