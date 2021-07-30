package step12_정렬;

import java.io.*;
import java.util.*;

public class No2750 {

	public static void main(String[] args) throws IOException{
		// 수 정렬하기. O(n^2)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 삽입정렬
		for(int i=1; i<N; i++) {
			int n1 = arr[i];
			
			for(int j=i-1; j>=0; j--) {
				int n2 = arr[j];
				
				if(n1 < n2) {
					int temp = n1;
					
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
		
		
	}

}
