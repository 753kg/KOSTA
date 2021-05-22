package step07_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1152 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		System.out.println(st.countTokens());
	}
	
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] arr = s.split(" ");
		int num = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].equals("")) continue;
			num++;
		}
		System.out.println(num);
	}
	*/

}
