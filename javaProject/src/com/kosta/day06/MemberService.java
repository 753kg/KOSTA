package com.kosta.day06;

//Service : business logic(업무로직)
public class MemberService {
	
	public Member login(Member member) {
		if(member.getId().equals("hong") && member.getPassword().equals("12345")) { // == : 주소비교
			member.setName("홍길동");
			member.setAge(20);
			return member;	// 로그인성공, DB정보 return
		} else {
			return null;	// 로그인실패, null return
		}
	}
	
	public void logout(String id) {
		System.out.println(id + "님 로그아웃 되었습니다.");
	}
}
