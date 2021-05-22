package step07_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toCharArray();
		int len = word.length;
		int result = 0;		// 단어 수
		int count = 0;		// 글자 수
		for(int i=1; i<len; i++) {
			char c = word[i];
			char b = word[i-1];
			if(c == 'j') {
				
				if(b == 'l' || b == 'n') {
					result++; count += 2;
				}
				
			}else if(c == '-') {
				
				if(b == 'c' || b == 'd') {
					result++; count += 2;
				}
				
			}else if(c == '=') {
				
				if(b == 'c' || b == 's') { 
					result++; count += 2;
				}else if(b == 'z') {
					result++; count += 2;
					if(i >= 2) {
						int a = word[i-2];
						if(a == 'd') {
							count++;
						}
					}
				}
				
			}
		}
		result += len - count;
		System.out.println(result);
		
	}

}
