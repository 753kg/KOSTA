package com.kosta.sbproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.sbproject.model.Board;
import com.kosta.sbproject.model.CarVO;
import com.kosta.sbproject.persistence.BoardRepository;

@RestController
public class Sample2RestController {
	
	@Autowired
	BoardRepository brepo;

	@RequestMapping("/hello")
	public String greeting() {
		return "안녕하세요. 좋은 아침...";
	}
	
	@RequestMapping("/car")
	public CarVO getCar() {
		CarVO car = new CarVO("SM7", 4000, "삼성");
		return car;		// jackson library -> JSON으로 return됨
	}
	
	@RequestMapping("/carlist")
	public List<CarVO> getCarList() {
		CarVO car1 = new CarVO("SM7", 4000, "삼성");
		CarVO car2 = new CarVO("AA", 5000, "기아");
		List<CarVO> carlist = new ArrayList<>();
		carlist.add(car1);
		carlist.add(car2);
		return carlist;
	}
	
	@RequestMapping("/boardlist")
	public Iterable<Board> getBoardList() {
		return brepo.findAll();
	}
	
	@RequestMapping("/board/{bno}")
	public Board getBoard(@PathVariable long bno) {
		return brepo.findById(bno).get();
	}
}
