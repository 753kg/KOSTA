package step07_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No2908 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
		
		System.out.println(a > b ? a : b);
	}
	
	/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for(int i=2; i>=0; i--) {
			sb1.append(s1.charAt(i));
			sb2.append(s2.charAt(i));
		}
		int i1 = Integer.parseInt(sb1.toString());
		int i2 = Integer.parseInt(sb2.toString());
		System.out.println(i1>i2 ? i1 : i2);
	}
	*/
}
