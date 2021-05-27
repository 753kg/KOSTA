package step08_기본수학1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10250 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());	// 층
			int W = Integer.parseInt(st.nextToken());	// 호
			int N = Integer.parseInt(st.nextToken());	// 몇번째손님
			
			int XX = N / H;
			if(N % H != 0) XX++;
			
			int YY = (N - H*(XX-1)) * 100;
			
			sb.append(YY+XX).append("\n");
		}
		
		System.out.println(sb);
	}
	
	/*
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());	// 층
			int W = Integer.parseInt(st.nextToken());	// 호
			int N = Integer.parseInt(st.nextToken());	// 몇번째손님
			
			int w = N / H;
			if(N % H != 0) w++;
			
			int h = N - H * (w - 1);
			
			String a = "";
			if(w / 10 == 0) a = "0";
			sb.append(h).append(a).append(w).append("\n");
		}
		
		System.out.println(sb);
	}
	*/
}
