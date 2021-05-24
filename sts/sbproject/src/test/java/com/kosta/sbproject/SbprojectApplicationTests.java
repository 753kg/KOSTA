package com.kosta.sbproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.kosta.sbproject.model.CarVO;

import lombok.extern.java.Log;

//JUNIT 이용해서 TEST
@SpringBootTest
@Log
class SbprojectApplicationTests {

	// 우클릭 -> Run As -> JUnit Test
	// @Test 만 실행시킨다.
	
	@Test
	public void lombokTest2() {
		// 체인 방식
		CarVO car1 = CarVO.builder()
				.model("BMW520")			// setModel
				.price(5000)
				.company("BMW").build();
		System.out.println(car1);		// toString 자동으로 됨
		log.info(car1.toString());
	}
	
	// @Test
	public void lombokTest1() {
		CarVO car1 = new CarVO();
		CarVO car2 = new CarVO("ABC모델", 1000, "기아");
		CarVO car3 = new CarVO("DDD모델", "현대");
		CarVO car4 = new CarVO("DDD모델", "현대");
		System.out.println(car1);
		System.out.println(car2);
		System.out.println(car3);
		System.out.println(car2.getModel());
		System.out.println(car1.equals(car2));
		System.out.println(car3.equals(car4));
	}
	
	@Test
	void contextLoads() {
	}

}
