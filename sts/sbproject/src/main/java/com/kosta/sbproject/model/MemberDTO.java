package com.kosta.sbproject.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder	// AllArgs NoArgs 둘 다 없거나 둘 다 있어야 함
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"mid","mname"})	// mid와 mname 두 개가 같으면 같다. default는 다 같아야 같다.
@Entity
@Table(name = "tbl_members")	// DB 테이블 이름 설정. default는 class이름
public class MemberDTO {

	@Id
	String mid;
	String mname;
	String mpassword;
	
	@Enumerated(EnumType.STRING)
	MemberRoleEnumType mrole;
}
