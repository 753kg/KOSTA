package com.kosta.day16.test;

public class Prob1 {
	public static void main(String[] args) {
		String[] array={"황남기85점","조성호89점","한인성88점","독고정진77점"};
		printMaxScore(array);
	}	
	private static void printMaxScore(String[] array){
		// 구현하세요.
		int maxScore = 0;
		String maxName = null;
		String scoreStr = "";
		String name = "";
		
		for(String line : array) {
			for(int i=0; i<line.length(); i++) {
				char c = line.charAt(i);
				if(Character.isDigit(c)) {
					scoreStr += c;
				}else {
					name += c;
				}
			}
			int score = Integer.parseInt(scoreStr);
			if(score > maxScore) {
				maxScore = score;
				maxName = name.substring(0, name.length()-1);
			}
			scoreStr = "";
			name = "";
		}
		System.out.println("최고점수는 " + maxName + "님 " + maxScore + "점 입니다.");
	}	
}
