package step08_기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1712 {
	public static void main(String[] args) throws IOException {
		// 손익분기점 : 최초로 이익이 발생하는 판매량
		/*
		N대 판매
		c * N > a + b * N
		N > a/(c-b)
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());	// 고정비용
		int b = Integer.parseInt(st.nextToken());		// 가변비용
		int c = Integer.parseInt(st.nextToken());	// 노트북 판매 가격
		
		int n = 0;
		if(c <= b) System.out.println(-1);
		else {
			System.out.println(a/(c - b) + 1);
		}
		
	}
}
