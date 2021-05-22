package com.kosta.day17;

public class Prob1 {
	public static void main(String[] args) {
		String[] array={"황남기85점","조성호89점","한인성88점","독고정진77점"};
		printMaxScore(array);
	}	
	private static void printMaxScore(String[] array){
		// 구현하세요.
		
		
		int maxScore = 0;
		String maxName = "";
		
		for(String s:array) {
			String strScore = "", name = "";
			
			for(int i=0; i<s.length(); i++) {
				char ch = s.charAt(i);
				if(Character.isDigit(ch)) {
					strScore += ch;
				}else {
					name += ch;
				}
			}
			int score = Integer.parseInt(strScore);
			name = name.substring(0, name.length()-1);
			
			if(maxScore < score) {
				maxScore = score;
				maxName = name;
			}
		}
		System.out.println("최고점수는 " + maxName + "님 " + maxScore + "점 입니다.");
		 
	}	
}
