package step07_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2675 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			String s = br.readLine();
			int r = s.charAt(0) - '0';
			for(int j=2; j<s.length(); j++) {
				sb.append(String.valueOf(s.charAt(j)).repeat(r));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
