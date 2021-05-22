package com.kosta.day02;

public class ForTest2 {
	
	// break : 중단, switch, for, while, do-while
	// 가장 가까운 반복문 빠져나가기
	// 중첩 반복문을 빠지려면 라벨 이름을 준다.
	
	public static void test2() {
		// countinue 문장 연습
		AA:for(int j = 1; j <= 3; j++) {
			for(int i = 1; i <= 5; i++) {
				if(i == 3) continue AA;	// 아래 문장들을 무시하고 반복문 계속 수행
				
				System.out.println(i + ", "+ j);
				System.out.println("**********");
				
			}
		}
	}
	
	public static void main(String[] args) {
		
		test2();
		System.out.println("=======================");
		
		AA:for(int dan = 2; dan <= 9; dan++) {
			System.out.println(dan+"단-----");
			//if(dan == 4) break;				//4단일 때 중지
			//System.out.println("oo");
			for(int gop = 1; gop <=9; gop++) {
//				if(dan == 4) break;				//4단일 때만 skip
				if(dan == 4) break AA;			//4단일 때 중지
				System.out.println(dan+"*"+gop);
			}
		}
		System.out.println("for end");

	}

}