package com.kosta.day02;

public class 김채연_최대공약수 {

	public static void main(String[] args) {
		// 최대 공약수는 두 숫자를 공통된 숫자로 나누어도 
		// 나머지가  0이 되는 가장 큰 수를의미합니다.
		gcd(2, 5);
		gcd(5, 15);
		gcd(250, 30);

	}

	private static void gcd(int v1, int v2) {
		
		// 1. 작은 수 찾기
		int min = (v1 < v2)? v1 : v2;
		
		// 2. 나누어 떨어지는 가장 큰 수 찾기
		//int gcd=1;
		for(int i=min; i>0; i--) {
			if(v1 % i == 0 && v2 % i == 0) {
				//gcd = i;
				System.out.println(i);
				break;
			}
		}
		//System.out.println(gcd);
		
	}

}