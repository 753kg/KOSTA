package com.kosta.day03;

import java.util.Scanner;

public class Excercise09_2 {

	public static void main(String[] args) {
		
		quiz09();

	}

	private static void quiz09() {
		
		boolean run = true;
		int[] scores = null;
		int studentCount = 0;

		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택> ");
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				System.out.print("학생수> ");
				studentCount = scanner.nextInt();
				
			}else if(selectNo == 2) {
				scores = new int[studentCount];
				for(int i=0; i<scores.length; i++) {
					System.out.print("scores["+i+"]> ");
					scores[i] = scanner.nextInt();
				}
				
			}else if(selectNo == 3) {
				for(int i=0; i < scores.length; i++) {
					System.out.println("scores["+i+"]: "+scores[i]);
				}
				
			}else if(selectNo == 4) {
				//최고점수
				getMaxScore(scores);
				//평균점수
				getAvg(scores, studentCount);
				
			}else if(selectNo == 5) {
				System.out.println("프로그램 종료!");
				run = false;
			}	
		}
		scanner.close();
	}
	
	private static void getMaxScore(int[] scores) {
		int max=0;
		for(int i=0; i<scores.length-1; i++) {
			if(scores[i] > max) max = scores[i];
		}
		System.out.println("최고 점수: "+max);
	}
	
	private static void getAvg(int[] scores, int studentCount) {
		int total = 0;
		for(int i=0; i<scores.length; i++) {
			total += scores[i];
		}
		double avg = total / studentCount;
		System.out.println("평균 점수: "+avg);
	}

}