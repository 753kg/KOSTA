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
@EqualsAndHashCode(of = {"mid"})	// mid가 같으면 같다. default는 다 같아야 같다.
@Entity
@Table(name = "tbl_members")	// DB 테이블 이름 설정. default는 class이름
public class MemberDTO {	// security에서 인증으로 사용하고자한다.

	@Id
	String mid;
	String mname;
	String mpassword;	// security를 위해 반드시 암호화되어야한다.
	
	@Enumerated(EnumType.STRING)
	MemberRoleEnumType mrole;	// 인가를 위해 필요함. 권한에 따라 접근가능
}
