package com.kosta.sample3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// DB와 관련된 것은 Repository
// default 이름 : memberDAOImpl
@Repository("mdao")
public class MemberDAOImpl implements MemberDAO {
	
	// 자동으로 car를 넣어라
	@Autowired
	Car car;
	
	public MemberDAOImpl() {
		System.out.println("MemberDAOImpl의 기본생성자...");
	}
	
	@Override
	public void listMembers() {
		System.out.println("listMembers  메서드 호출");
		System.out.println("회원정보를 조회합니다.");
		System.out.println(car);
	}
}
