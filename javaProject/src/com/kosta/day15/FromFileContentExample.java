package com.kosta.day15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileContentExample {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("./src/com/kosta/day15/linedata.txt");		//파일까지 쓰면 파일 내용을 읽음?
		Stream<String> stream;
		
		//Files.lines() 메소드 이용
		stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach( System.out :: println );
		stream.close();
		System.out.println();
		
		//BufferedReader의 lines() 메소드 이용
		File file = path.toFile();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		stream = br.lines();
		stream.forEach( System.out :: println );
		stream.close();
	}
}
