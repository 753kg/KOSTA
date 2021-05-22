package step07_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().toUpperCase();
		int[] result = new int[26];
		for(int i=0; i<s.length(); i++) {
			result[s.charAt(i) - 65]++;
		}
		int max = 0;
		int index = 0;
		int count = 0;
		for(int i=0; i<result.length; i++) {
			if(result[i] > max) {
				max = result[i]; 
				index = i;
				count = 0;
			}
			else if(result[i] == max) count++;
		}
		if(count > 0) System.out.println("?");
		else System.out.println((char)(index+65));
	}

}
