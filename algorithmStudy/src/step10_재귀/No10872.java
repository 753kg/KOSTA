package step10_재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10872 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = factorial(n);
		System.out.println(result);
	}
	
	public static int factorial(int n) {
		if(n <= 1) {
			return 1;
		}
		return n * factorial(n-1);
	}

}
