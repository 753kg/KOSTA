package step11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2231 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i=1; i<=N; i++) {
			int j = i;
			int sum = j;
			while(j > 0) {
				sum += j % 10;
				j = j / 10;
			}
			if(sum == N) {
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
}
