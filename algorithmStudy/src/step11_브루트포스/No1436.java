package step11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1436 {

	public static void main(String[] args) throws IOException {
		// 영화감독 숌
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int num = 666;
		int count = 1;
		
		while(count != N) {
			num++;
			
			if(String.valueOf(num).contains("666")) {
				count++;
			}
		}
		
		System.out.println(num);
	}

}

/* 전 숫자가 666이면 1666 or 6661 -> 1666이 없으면 1666, 있으면 6661
 * 전 숫자가 1666이면 맨앞숫자 + 1
 * ...
 * 6666이면 1666 or 6661 -> 1666 있으니까 6661
 * 전 숫자가 
*/