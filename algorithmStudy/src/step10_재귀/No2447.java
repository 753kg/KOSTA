package step10_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2447 {
	
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		printStar(N);
		System.out.println(sb);
		/*
		
		 N의 패턴은 (N/3)x(N/3) 만큼의 공백을 (N/3)의 패턴으로 둘러싼 모양
		
		 i) N=3 --> 1x1 만큼의 공백을 1의 패턴으로 둘러쌈
		
		 ***
		 * *
		 ***
		 
		 ii) N=9 --> 3x3 만큼의 공백을 3의 패턴으로 둘러쌈
		 
		 *********
		 * ** ** *
		 *********
		 ***   ***
		 * *   * *
		 ***   ***
		 *********
		 * ** ****
		 ********* 
		 
		*/

	}
	
	public static void printStar(int N) {
		if(N == 1) {
			sb.append("*");
		}
		else {
			int K = N/3;
			int len = N*N;
			for(int i=1; i<=len; i++) {
				if(i == 5) sb.append(" ");
				else printStar(K);
				
				if(i % N == 0) sb.append("\n");
			}			
		}
	}

}


