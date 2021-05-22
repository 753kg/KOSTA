package com.kosta.day10;

import java.util.Arrays;

public class LAB {

	public static void main(String[] args) {
		String s = "everyday we have is one more than we deserve";
		System.out.println(s);
		char[] cc = new char[s.length()];
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == ' ') continue;
			
			c += 3;
			if(c > 'z') c -= ('z'+1)-'a';
			
			cc[i] = c;
		}
		s = String.valueOf(cc);
		System.out.println(s);
		
	
	}

}
