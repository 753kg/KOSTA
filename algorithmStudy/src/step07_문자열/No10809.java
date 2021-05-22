package step07_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuffer sb = new StringBuffer();
		for(char c='a'; c<='z'; c++) {
			sb.append(s.indexOf(c)).append(" ");
		}
		System.out.println(sb);
		
	}

}
