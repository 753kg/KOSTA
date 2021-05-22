package com.kosta.day15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

public class ScoreTest {
	
	public void printScore(String fileName) throws IOException {
		FileReader fr = null;
		BufferedReader br = null;			// 한줄씩읽음
		
		fr = new FileReader(fileName);
		br = new BufferedReader(fr);
		
		String line = br.readLine();
		System.out.println(line.replace("/", "\t") + "\t총점");
		
		/*
		while((line = br.readLine()) != null) {
			System.out.print(line.replace('/', '\t'));
			String[] arr = line.split("/");
			int sum = 0;
			for(int i=1; i<arr.length; i++) {
				sum += Integer.parseInt(arr[i]);
			}
			System.out.println("\t" + sum);
			
		}*/
		
		/* Stream 사용하기 */
		while((line = br.readLine()) != null) {
			System.out.print(line.replace('/', '\t'));
			String[] arr = line.split("/");
			Stream<String> stream = Arrays.stream(arr, 1, arr.length);
			int total = stream.mapToInt(Integer::parseInt).sum();
			System.out.println("\t"+total);
		}
		
		br.close();
		fr.close();
		
	}

	public static void main(String[] args) throws IOException {
		String fname = "src/com/kosta/day15/data.txt";
		ScoreTest sc = new ScoreTest();
		sc.printScore(fname);
	}

}
