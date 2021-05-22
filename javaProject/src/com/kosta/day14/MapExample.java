package com.kosta.day14;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapExample {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name = null;		// 최고 점수를 받은 아이디 저장
		int maxScore = 0;		// 최고 점수 저장
		int totalScore = 0;		// 점수 합계 저장
		
		for(String key:map.keySet()) {
			int score = map.get(key);
			totalScore += score;
			if(maxScore < score) {
				maxScore = score;
				name = key;
			}
		}
		
//		for(Entry<String, Integer> entry : map.entrySet()) {
//			int score = entry.getValue();
//			totalScore += score;
//			if(maxScore < score) {
//				maxScore = score;
//				name = entry.getKey();
//			}
//		}
		
		//평균점수
		int avg = totalScore / map.size();
		System.out.println("평균점수:" + avg);
		
		// 최고점수
		System.out.println("최고점수:" + maxScore);
		
		// 최고 점수를 얻은 아이디
		System.out.println("최고점수를 받은 아이디:" + name);

	}

}
