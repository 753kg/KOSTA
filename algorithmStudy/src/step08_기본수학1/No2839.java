package step08_기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 3kg, 5kg
		// 18kg --> (X) 3kg x 6개
		//		--> (O) 5kg x 3개 + 3kg x 1개 ==> 4개
		
		// 11kg --> 5kg 1개 3kg 2개
		int result = 0;
		if(N % 5 == 0) result = N/5; 
		else {
			int a = N / 5; // 5kg 1개
			while(true) {
				int b = N - 5*a;	// 11kg-5kg =6kg
				if(b % 3 == 0) {
					result = a + b/3;
					break;
				}else if(a <= 0) {
					result = -1;
					break;
				}
				a--;
			}
		}
		System.out.println(result);
	}
}
