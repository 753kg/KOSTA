package com.kosta.day15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromDirectoryExample {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("./src/com/kosta/day15");		// 폴더이름을 주면 path가 만들어짐
		Stream<Path> stream = Files.list(path);				// 파일의 list를 얻음
		stream.forEach( p -> {
			System.out.println("파일이름>> " + p.getFileName());			// 파일의 이름을 얻음
			System.out.println("파일경로포함>> " + p);
		});
	}
}
