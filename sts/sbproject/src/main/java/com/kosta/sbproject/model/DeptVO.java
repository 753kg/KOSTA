package com.kosta.sbproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(exclude = "emplist")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity		// JPA가 관리함을 의미
@Table(name = "tbl_dept",													
	uniqueConstraints = {@UniqueConstraint(name="unique2", 	// 제약조건 이름
						columnNames = {"manager_id", "location_id"})}	// DB컬럼이름. 두 컬럼 합쳐서 unique
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
	int deptid;		// [권장] 언더바 쓰지 않기 ex)dept_id
	
	// not null(default)
	@Column(name = "dept_name", unique = true, nullable = false, length = 30)
	String deptname;
	
	@Column(name = "manager_id", nullable = true)
	int managerid;
	
	@Column(name = "location_id", nullable = true)
	int locationid;
	
	// 하나의 부서에는 여러명의 직원이 있다.
	// mappedBy = "department" --> EmpVO의 department에 매여있다.
	// fetch = FetchType.LAZY --> lazy(default) : 부서정보를 가져올 때 직원정보는 안가져옴
	@OneToMany(mappedBy = "department", 
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)	
	List<EmpVO> emplist;
}
