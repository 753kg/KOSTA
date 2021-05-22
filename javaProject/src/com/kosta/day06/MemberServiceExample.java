package com.kosta.day06;

//Application, App, 서비스이용
public class MemberServiceExample {

	public static void main(String[] args) {
		
		MemberService service = new MemberService();
		Member member = new Member(null, "hong", "12345", 0);
		member = service.login(member);
		if(member != null) {	//true이면
			System.out.println("로그인 성공");
			System.out.println(member);
			System.out.println("로직수행......");
			service.logout(member.getId());
		}else {
			System.out.println("로그인 실패");
		}

	}

}
