package com.kosta.day15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.stream.Stream;

public class IOTest2 {

	public static void main(String[] args) {
		method3();
	}
	
	private static void method3() {
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
			
			Stream<String> lines = br.lines();
			lines.forEach( System.out::println);
			
			lines = br.lines();
			lines.forEach( aa -> {
				System.out.println(aa);
			});
			
			
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

	private static void method2() {
		FileOutputStream fos = null;	// 파일에 저장
		ObjectOutputStream oos = null;	
		FileInputStream fis = null;		// 파일 읽기
		ObjectInputStream ois = null;
		
		try {
			// 파일에 쓰기
			fos = new FileOutputStream("src/com/kosta/day15/objecttype.data");	// 확장명 아무거나
			oos = new ObjectOutputStream(fos);
			oos.writeObject(new Student("홍길동", 100));
			oos.writeObject(new Student("김길동", 200));
			oos.writeObject(new Student("박길동", 300));
			oos.close();
			fos.close();
			
			// 파일 읽기
			fis = new FileInputStream("src/com/kosta/day15/objecttype.data");
			ois = new ObjectInputStream(fis);
			Object s;
			while(true) {
				s = ois.readObject();
				if(s == null) break;
				System.out.println(s);
			}
			ois.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("end....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("END!!!");
		
	}

	private static void method1() {
		// 자바 기본형을 파일로 저장 : byte, short, char, int, long, float, double, boolean
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fos = new FileOutputStream("src/com/kosta/day15/basictype.txt");
			dos = new DataOutputStream(fos);
			dos.writeInt(100);
			dos.writeBoolean(10 > 20);
			dos.writeDouble(3.14);
			
			dos.close();
			fos.close();
			
			fis = new FileInputStream("src/com/kosta/day15/basictype.txt");
			dis = new DataInputStream(fis);
			System.out.println(dis.readInt() + 200);
			System.out.println(dis.readBoolean()?"참":"거짓");
			System.out.println(dis.readDouble() + 100);
			
			dis.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
