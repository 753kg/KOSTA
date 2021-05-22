package step04_while;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No10952 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()); 
			int v2 = Integer.parseInt(st.nextToken());
			if(v1 == 0 && v2 == 0) break;
			sb.append(v1+v2).append("\n");
			//bw.write((v1+v2) + "\n");
		}
		System.out.println(sb);
		//bw.flush();
	}

}
