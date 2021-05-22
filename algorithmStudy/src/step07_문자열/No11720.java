package step07_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11720 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int total = 0;
		for(int i=0; i<n; i++) {
			total += s.charAt(i) - '0';
		}
		System.out.println(total);

	}

}
