package com.kosta.day17;

import java.util.Arrays;

public class Prob2 {

	public static void main(String[] args) {
		System.out.println(leftPad("Samsung",10,'#'));
		System.out.println(leftPad("SDS",5,'*'));
		System.out.println(leftPad("Multicampus",5,'@'));
		
	}

	 

	public static String leftPad(String str, int size, char fillChar){
		//구현하시오.....return값 수정할것 
		try {			
			if(str.length() > size) throw new IllegalSizeException("문자열의 길이보다 size가 큽니다.");
		} catch(IllegalSizeException e){
			System.out.println(e.getMessage());
			return "";
		}
		
		/* 방법1
		int diff = size - str.length();
		String message = "";
		for(int i=0; i<diff; i++) {
			message += fillChar;
		}
		
		return message + str;
		*/
		
		/* 방법2 */
		int diff = size - str.length();
		String[] arr = new String[diff];
		Arrays.fill(arr, fillChar+"");
		
		return Arrays.toString(arr).replaceAll("\\[|,| |\\]", "") + str;
	}

	
	
}

//구현하시오.
class IllegalSizeException extends Exception{
	 
	IllegalSizeException(String message){
		super(message);
	}
	 
}



