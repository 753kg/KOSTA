package com.kosta.sbproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KostaController {

	@RequestMapping("/sample1")
	public void getSample1() {
		// return 안하면 요청이름과 같은 html 찾음. sample1.html
		// sample1로 forward
		System.out.println("사용자가 sample1을 요청함....");
	}
}
