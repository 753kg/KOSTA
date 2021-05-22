package com.kosta.day02;

public class SwitchTest {

	public static void main(String[] args) {
		
		int score = (int)(Math.random() * 101);	// 0 ~ 100점
		String grade;
		
		// 90 <= score <= 100 : "A"
		// 80 <= score <= 89 : "B"
		// break; switch문장 빠져나오기
		// 수행시간이 같음
		switch(score/10) {
		case 10:
		case 9: 
			grade = "A"; break;
		case 8: 
			grade = "B"; break;
		case 7: 
			grade = "C"; break;
		case 6: 
			grade = "D"; break;
		default: 
			grade = "F";			//마지막은 break 안해도됨
		}
		System.out.println(score + " ==> " + grade);

	}

}