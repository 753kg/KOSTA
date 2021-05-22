package com.kosta.day10;

import java.util.Comparator;
													// 기본형은 안됨
public class IntegerDescending implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		// o1 - o2 => 오름차순
		// o2 - o1 => 내림차순
		// (o1-o2)*-1
		return o2 - o1;
	}
	
}
