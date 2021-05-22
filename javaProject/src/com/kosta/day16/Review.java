package com.kosta.day16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Review {

	public static void main(String[] args) {
		fileCopy();
	}

	private static void fileCopy() {
		// \t : tab		 \n : new line		\\ : \
		// 폴더 이름 구분시 / or \\ 모두 가능
		String originalFile = "src\\com\\kosta/day15/IOTest.java";
		String targetFile = "src/com/kosta/day16/IOTest.txt";
		
		FileReader fr = null;			// Reader : 2byte씩 읽음, Stream : 1byte
		BufferedReader br = null;		// line 단위로 읽기
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		String line = null;
		
		try {
			fr = new FileReader(originalFile);
			br = new BufferedReader(fr);
			fw = new FileWriter(targetFile);
			bw = new BufferedWriter(fw);
			
			// EOF(End Of File) : 파일이 끝날때까지
			while((line = br.readLine()) != null) {
				bw.write(line);		// 파일에 쓰기
				bw.newLine();		// line 바꾸기
				System.out.println(line);	// 콘솔에 출력하고 줄 바꾸기
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
				try {
					if(br != null) br.close();
					if(fr != null) fr.close();
					if(bw != null) bw.close();
					if(fw != null) fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
