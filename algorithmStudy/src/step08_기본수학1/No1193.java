package step08_기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		int line = 1;
		int first = 0;
		int end = 0;
		int sub = 0;
		while(true) {
			max += line;
			if(N <= max) {
				sub = max - N;
				if(line % 2 == 0) {
					first = line - sub;
					end = 1 + sub;
				}else {
					first = 1 + sub;
					end = line - sub;
				}
				sb.append(first).append("/").append(end);
				System.out.println(sb);
				break;
			}
			line++;
		}
	}

}
