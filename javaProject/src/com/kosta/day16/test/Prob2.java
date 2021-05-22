package com.kosta.day16.test;

public class Prob2 {

	public static void main(String[] args){
		System.out.println(leftPad("Samsung",10,'#'));
		System.out.println(leftPad("SDS",5,'*'));
		System.out.println(leftPad("Multicampus",5,'@'));
		
	}

	 

	public static String leftPad(String str, int size, char fillChar){
		//구현하시오.....return값 수정할것 
		
		try {
			if(str.length() > size) throw new IllegalSizeException("문자열의 길이보다 size가 큽니다.");	
			
		} catch(IllegalSizeException e) {
			return e.getMessage();
		}
		char[] arr = new char[size];
		int start = size - str.length();
		int j=0;
		for(int i=0; i<size; i++) {
			if(i < start) {
				arr[i] = fillChar;
			}
			else {
				arr[i] = str.charAt(j);
				j++;
			}
			
		}
		
		return String.valueOf(arr);
		
	}

	
	
}

//구현하시오.
class IllegalSizeException extends Exception{
	String message;
	public IllegalSizeException(String message){
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}



