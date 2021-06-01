package com.kosta.sbproject.lastproject;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kosta.sbproject.model.MemberDTO;
import com.kosta.sbproject.model.MemberRoleEnumType;
import com.kosta.sbproject.security.MemberService;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class MemberSecurityTest {

	@Autowired
	MemberService service;
	
	@Test
	public void joinUser() {
		IntStream.range(1, 4).forEach(i -> {
			MemberDTO member = MemberDTO.builder()
					.mid("admin" + i)
					.mpassword("1234")
					.mname("관리자" + i)
					.mrole(MemberRoleEnumType.ADMIN)
					.build();
			service.joinUser(member);			
		});
		
		IntStream.range(1, 4).forEach(i -> {
			MemberDTO member = MemberDTO.builder()
					.mid("manager" + i)
					.mpassword("1234")
					.mname("김매니저" + i)
					.mrole(MemberRoleEnumType.MANAGER)
					.build();
			service.joinUser(member);			
		});
		
		IntStream.range(1, 4).forEach(i -> {
			MemberDTO member = MemberDTO.builder()
					.mid("user" + i)
					.mpassword("1234")
					.mname("사용자" + i)
					.mrole(MemberRoleEnumType.USER)
					.build();
			service.joinUser(member);			
		});
	}
}
