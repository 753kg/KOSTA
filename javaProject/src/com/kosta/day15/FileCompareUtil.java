package com.kosta.day15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Stream;

public class FileCompareUtil {
	ArrayList compareFile(String fstFileName, String scdFileName) 
			throws Exception{
		FileReader fr = new FileReader(fstFileName);
		BufferedReader br = new BufferedReader(fr);
		
		FileReader fr2 = new FileReader(scdFileName);
		BufferedReader br2 = new BufferedReader(fr2);
		String line, line2;
		int i=1;
		ArrayList<String> alist = new ArrayList<String>();
		while((line = br.readLine())!=null) {
			line2 = br2.readLine();
			if(!line.equals(line2)) {
				alist.add("Line"+ i + ":" + line2);
			}
			i++;
		}
		br2.close();
		fr2.close();
		br.close();
		fr.close();
		return alist;
		
	}
    public static void main(String[] args) throws Exception {
    	String f1 = "src/com/kosta/day15/first.txt";
    	String f2 = "src/com/kosta/day15/second.txt";
    	ArrayList<String> alist = new FileCompareUtil().compareFile(f1, f2);
    	Stream<String> stream = alist.stream();
    	stream.forEach(System.out::println);
    	
    }
}



//-	fstFileName은 절대경로를 포함한 입력 파일명입니다.
//-	scdFileName은 절대경로를 포함한 출력 파일명입니다.
//-	두 텍스트 파일의 전체 라인수는 동일하다라고 간주합니다.
//-	첫번째 입력된 텍스트 파일 내용을 기준으로 두번째 입력된 텍스트 파일 태용을 라인별로 비교하고 동일할 경우 다음 라인으로 이동합니다. 다를 경우에는 해당 라인의 번호와 함께 두번째 파일의 해당 라인 내용을 결과 용도의 ArrayList에 추가합니다.
