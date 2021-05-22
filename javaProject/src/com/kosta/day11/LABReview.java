package com.kosta.day11;

public class LABReview {

	public static void main(String[] args) {
		String s = "everyday we have is one more than we deserve";
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				int sNum = s.charAt(i) + 3;
				if (sNum >= 'x' + 3) {
					sNum = s.charAt(i) - 'x' + 'a';
				}
				sb.append((char) sNum);
			} else {
				sb.append(' ');
			}
		}
		
		System.out.println("암호화 할 문자열: " + s.toString());
		System.out.println("암호화 된 문자열: " + sb.toString());
	}

}
