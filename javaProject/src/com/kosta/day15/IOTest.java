package com.kosta.day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Date;
import java.util.Scanner;

public class IOTest {

	public static void main(String[] args) throws IOException {
		method10();
	}
	
	private static void method10() {
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		FileReader fr = null;
		FileWriter fw = null;
		
		int data;
		String s = null;
		
		String fname = "src/com/kosta/day15/Review.java";
		String fname2 = "src/com/kosta/day15/Review_backup.txt";
		
		try {
			fr = new FileReader(fname);
			br = new BufferedReader(fr);
			
			fw = new FileWriter(fname2);
			bw = new BufferedWriter(fw);
			
			while((s = br.readLine()) != null) {
				System.out.println(s);
				fw.write(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(br != null) br.close();
					if(bw != null) bw.close();
					if(fr != null) fr.close();
					if(fw != null) fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	private static void method9() throws IOException {
		// File 정보 얻기
		String name = "src/com/kosta/day15/Student.java";
		File f = new File(name);
		System.out.println(f.exists());
		System.out.println(f.length());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.lastModified());		// long 타입
		Date d = new Date(f.lastModified());
		System.out.println(d);
		
		// 디렉토리(폴더) 만들기
		String name2 = "src/com/kosta/day15/newDir";
		File f2 = new File(name2);
		boolean b = f2.mkdir();
		System.out.println(b);
		
		String name3 = "src/com/kosta/day15/newDir/test.txt";
		File f3 = new File(name3);
		b = f3.createNewFile();
		System.out.println(b);

	}

	private static void method8() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자 입력>> " + sc.next());
		System.out.println("int 입력>> " + sc.nextInt());
		System.out.println("double 입력>> " + sc.nextDouble());		
		
		sc.nextLine();
		System.out.print("한줄 모두 읽기>> ");
		String s = sc.nextLine();
		System.out.println("입력값은 " + s);
		
		sc.close();
	}

	private static void method7() throws IOException {
		System.setIn(new FileInputStream("src/com/kosta/day15/Student.java"));
		InputStream is = System.in;		// 1byte씩 읽음
		int i;
		while((i = is.read()) != -1) {
			System.out.print((char)i);			
		}
	}

	private static void method6() throws FileNotFoundException {
		System.setOut(new PrintStream("src/com/kosta/day15/output.txt"));	// 표준출력을 파일로 하겠다.
		PrintStream out = System.out;	// 파일에 출력됨
//		PrintStream out = System.err;	// 색깔이 빨간색으로 나옴
		out.print("자바");
	}

	private static void method5() {
		InputStream is = System.in;
		InputStreamReader ir = new InputStreamReader(is);
		try {
//			int i = is.read();				// 1byte만 읽음
			int i = ir.read();				// 1byte를 2byte로 읽음
			System.out.println((char)i);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void method4() {
		FileReader fr = null;
		FileWriter fw = null;
		int data;
		String fname = "src/com/kosta/day15/Review.java";
		String fname2 = "src/com/kosta/day15/Review_backup.txt";
		try {
			fr = new FileReader(fname);
			fw = new FileWriter(fname2);
			while((data = fr.read()) != -1) {	// 2byte씩 int로 읽음
				System.out.print((char)data);	// 모니터에 출력
				fw.write(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(fr != null) fr.close();
					if(fw != null) fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	private static void method3() {
		FileReader fr = null;
		int data;
		String fname = "src/com/kosta/day15/Review.java";
		try {
			fr = new FileReader(fname);
			while((data = fr.read()) != -1) {	// 2byte씩 int로 읽음
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(fr != null) fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	private static void method2() {
		
		FileInputStream fi = null;
		InputStreamReader ir = null;
		int data;
		
		try {
			// 파일 읽을때
			fi = new FileInputStream("src/com/kosta/day15/Review.java");	// 1byte씩 ascii code로 읽는다. 'A' = 65
			ir = new InputStreamReader(fi);									// 1byte를 2byte로 바꿔준다.
			while((data = ir.read()) != -1) {	
				System.out.print((char)data);	
			}
			System.out.println();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않는다.");
		} catch (IOException e) {
			System.out.println("입출력 오류");
		} finally {
			try {
				if(ir != null) ir.close();		// 자원 반납 꼭!!!!!!!!
				if(fi != null) fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	private static void method1() {
		
		FileInputStream fi = null;
		int data;
		
		try {
			// 파일 읽을때
			fi = new FileInputStream("src/com/kosta/day15/Review.java");
			while((data = fi.read()) != -1) {	// 1byte씩 ascii code로 읽는다. 'A' = 65
				System.out.print((char)data);	
			}
			System.out.println();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않는다.");
		} catch (IOException e) {
			System.out.println("입출력 오류");
		} finally {
			try {
				if(fi != null) fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
