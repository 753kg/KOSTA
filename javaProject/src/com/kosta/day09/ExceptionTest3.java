package com.kosta.day09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
// 예외발생
// 1) 자동발생... 실행시, 컴파일시
// 2) 강제로 예외를 발생시킴 ... throw 예외이름
// 예외처리
// 1) 내가한다. : try-catch-finally, try만 읽으면 됨
// 2) 나를 호출한 곳으로 떠넘긴다. : throws
public class ExceptionTest3 {

	public static void main(String[] args){
//		method1();
		// 여기서도 떠넘기면 프로그램이 비정상적으로 종료됨
		try {
			method2();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("main end");
		
	}
	
	private static void method2() throws IOException{
		
		FileReader fr = null;	// 지역변수는 반드시 초기화
		fr = new FileReader("src/com/kosta/day09/ExceptionTest3.java");
		System.out.println("파일 열기 성공!!");
		int i;
		while((i = fr.read()) != -1) {	// // read(): 2byte씩 읽음 , -1 : 파일의 끝을 나타냄
			System.out.print((char)i);
		}
		fr.close();
		System.out.println("try-catch END");
	}

	private static void method1() {
		// 파일을 열어라
		FileReader fr = null;	// 지역변수는 반드시 초기화
		try {
			fr = new FileReader("src/com/kosta/day09/ExceptionTest3.java");
			System.out.println("파일 열기 성공!!");
			int i;
			while((i = fr.read()) != -1) {	//-1 : 파일의 끝을 나타냄
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않는다...");
		} catch (IOException e) {
			System.out.println("읽기 오류...");
		}finally {
			try {
				if(fr != null) fr.close();
			} catch (IOException e) {	// 파일 열고닫을때 Exception
				e.printStackTrace();
			}
		}
		System.out.println("try-catch END");
	}

}
