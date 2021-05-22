package com.kosta.day09;

public class DiceGame {

	public static void main(String[] args) {
		DiceGame game = new DiceGame ();
		 
	 	int result1 = game.countSameEye(10);
	 	System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);
	 	
	 	try {
	 		int result2 = game.countSameEye(-10);
	 		System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);
	 	} catch(IllegalArgumentException e) {
	 		System.out.println(e.getMessage());
	 	}
	}
	
	int countSameEye(int n)  {
		 // 두 개의 주사위를 n번 던져서 같은 눈이 나오는 횟수를 return
		// RuntimeException -> 예외처리 안해도 괜찮다.
		// 이외의 Exception -> 예외처리 꼭 해야한다.
		
		// 예외 강제 발생
		if(n < 0) throw new IllegalArgumentException("횟수는 음수가 될 수 없다.");	
		Dice dice1 = new Dice(8);
		Dice dice2 = new Dice(8);
		
		int count = 0;
		for(int i=1; i<=n; i++) {
			int v1 = dice1.play();
			int v2 = dice2.play();
			System.out.print("(" + v1 + ", " + v2 + ")\t");
			if(v1 == v2) count++;
//			if(dice1.play() == dice2.play()) count++;
		}
		System.out.println();
		return count;
		
	}

}
