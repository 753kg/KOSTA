package com.kosta.sbproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity		// JPA가 관리함을 의미
@Table(name = "tbl_dept",													
	uniqueConstraints = {@UniqueConstraint(name="unique2", 	// 제약조건 이름
						columnNames = {"managerid", "locationid"})}	// 두 컬럼 합쳐서 unique
		)
public class DeptVO {
	/* JPA 설계 
	   매핑해서 자동으로 테이블 생성 
	*/
	
	@Id	// 필수, PK
	@GeneratedValue(strategy = GenerationType.AUTO)	
	// 시퀀스, 정책이 DB마다 다르다. AUTO로 하면 JPA가 알아서 설정
	// SEQUENCE : hibernate_sequence가 자동생성되어 사용된다. insert시에 hiernate_sequence.nextval 사용
	// IDENTITY : Auto_increment
	int deptid;
												// not null(default)
	@Column(name = "deptname", unique = true, nullable = false, length = 30)
	String deptname;
	
	@Column(name = "managerid", nullable = true)
	int managerid;
	
	int locationid;
}
