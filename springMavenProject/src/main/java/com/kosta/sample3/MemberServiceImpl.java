package com.kosta.sample3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// bean 이름이 없으면 memberServiceImpl (클래스 이름에서 첫번째만 소문자)
@Service
public class MemberServiceImpl implements MemberService {
	
	// @Autowired : type이 같으면 injection
	// 1. @Autowired 위치 : field
	@Autowired
	private MemberDAO memberDAO;
	 
	public MemberServiceImpl() {
		System.out.println("MemberServiceImpl의 기본생성자...");
	}
	
	// 2. @Autowired 위치 : 생성자
	// 기본생성자는 안되고 필드 초기화해야 가능
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
		System.out.println("MemberServiceImpl의 arg1 생성자...");
	}
	
	// 3. @Autowired 위치 : setter
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
		System.out.println("MemberServiceImpl의 setMemberDAO()...");
	}

	@Override
	public void listMembers() {
		memberDAO.listMembers();
	}
}
