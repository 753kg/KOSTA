package com.kosta.sbproject;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kosta.sbproject.model.MemberDTO;
import com.kosta.sbproject.model.MemberRoleEnumType;
import com.kosta.sbproject.model.ProfileDTO;
import com.kosta.sbproject.persistence.MemberRepository;
import com.kosta.sbproject.persistence.ProfileRepository;

import lombok.extern.java.Log;

@Log
@SpringBootTest
public class MemberProfileTest {

	@Autowired
	MemberRepository memberRepo;
	
	@Autowired
	ProfileRepository profileRepo;
	
	@Test
	public void countProfileByMember() {
		log.info("NativeQuery-------------------------------");
		memberRepo.countProfileByMemberNative().forEach(arr -> {
			log.info(Arrays.toString(arr));
		});
		
		log.info("JPQL--------------------------------------");
		memberRepo.countProfileByMemberJPQL().forEach(arr -> {
			log.info(Arrays.toString(arr));
		});
	}
	
	// @Test
	public void findByMember() {
		// user7의 모든 profile, member 정보 알아내기
		MemberDTO mem = MemberDTO.builder().mid("user7").build();
		profileRepo.findByMember(mem).forEach(prof -> {
			log.info(prof.toString());
			log.info(prof.getMember().getMname());
		});
	}
	
	// @Test
	public void findByFno() {
		// profile을 기준으로 member 정보를 알아냄
		profileRepo.findById(205L).ifPresent(prof -> {
			log.info(prof.toString());
			log.info(prof.getFname());
			log.info(prof.getMember().toString());
			log.info(prof.getMember().getMname());
		});
	}
	
	//@Test
	public void insertProfile() { // FK
		MemberDTO member = new MemberDTO();
		member.setMid("user7");
		IntStream.range(1, 4).forEach(i -> {
			ProfileDTO profile = new ProfileDTO();
			profile.setFname("face" + i + ".jpg");
			if(i == 1)
				profile.setCurrentYn(true);
			else
				profile.setCurrentYn(false);
			profile.setMember(member);
			profileRepo.save(profile);
		});
		
		MemberDTO member2 = new MemberDTO();
		member2.setMid("mem1");
		IntStream.range(1, 5).forEach(i -> {
			ProfileDTO profile = new ProfileDTO();
			profile.setFname("flower" + i + ".jpg");
			if(i == 1)
				profile.setCurrentYn(true);
			else
				profile.setCurrentYn(false);
			profile.setMember(member2);
			profileRepo.save(profile);
		});
	}
	
	//@Test
	public void selectAllMembers() {
		memberRepo.findAll().forEach(member -> {
			log.info(member.toString());
		});
	}
	
	// @Test
	public void insertMembers() {
		IntStream.range(1, 4).forEach(i -> {
			MemberDTO member = new MemberDTO();
			member.setMid("mem" + i);
			member.setMname("찐" + i);
			member.setMpassword("1234");
			member.setMrole(MemberRoleEnumType.ADMIN);
			memberRepo.save(member);
		});
		
		IntStream.range(4, 7).forEach(i -> {
			//MemberDTO member = MemberDTO.builder().build();		// 기본생성자
			MemberDTO member = MemberDTO.builder()
					.mid("ber" + i)
					.mname("코스타" + i)
					.mpassword("1234")
					.mrole(MemberRoleEnumType.MANAGER)
					.build();
			memberRepo.save(member);
		});
		
		IntStream.range(7, 10).forEach(i -> {
			MemberDTO member = new MemberDTO("user" + i, "연" + i, 
					"1234", MemberRoleEnumType.USER);
			memberRepo.save(member);
		});
	}
	
}
