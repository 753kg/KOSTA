package com.kosta.day17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class FileController {

	public static void main(String[] args) {
		String inputFileName = "src/com/kosta/day17/lineData.txt";
		String outputFileName = "src/com/kosta/day17/reverseLineData.txt";
		new FileController().reverseLine(inputFileName, outputFileName);
	}
	
	void reverseLine(String inputFileName, String outputFileName) {
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		Stack<String> st = new Stack<>();
		String line = null;
		
		try {
			fr = new FileReader(inputFileName);
			br = new BufferedReader(fr);
			
			while((line = br.readLine()) != null) {
				st.push(line);
			}
			
			fw = new FileWriter(outputFileName);
			bw = new BufferedWriter(fw);
			while(!st.isEmpty()) {
				bw.write(st.pop());
				bw.write("\n");
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(fr != null) fr.close();
				if(bw != null) bw.close();
				if(fw != null) fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
