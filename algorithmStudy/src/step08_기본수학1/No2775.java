package step08_기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2775 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[15][15];	// 0층부터 1~14호
		
		for(int j=0; j<15; j++) {
			arr[0][j] = j;
			arr[j][1] = 1;
		}
		
		for(int i=1; i<15; i++) {	// 층
			for(int j=2; j<15; j++) { // 호
				arr[i][j] = arr[i][j-1] + arr[i-1][j];
			}
		}
		
		for(int i=0; i<T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			sb.append(arr[k][n]).append("\n");
		}
		
		System.out.println(sb);
		
	}
}
