package step04_while;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String s = "";
		while((s=br.readLine())!= null) {
			//int a = s.charAt(0) - 48;
			//int b = s.charAt(2) - 48;
			//sb.append(a+b).append("\n");
			st = new StringTokenizer(s);
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
		}
		System.out.println(sb);
	}
}

// 종료 조건이 없다.
// 입력에서 읽을 수 있는 데이터가 존재하지 않을 때 반복문 종료
// EOF(End of File) ==> (s=br.readLine())!= null

// 입력이 한자릿수정수, 항상 고정된 위치 ==> charAt