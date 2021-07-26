package step11_브루트포스;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1018 {

	public static void main(String[] args) throws IOException {
		// 체스판 다시 칠하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 원본 체스판
		String[][] original = new String[N][M];
		for(int i=0; i<original.length; i++) {
			original[i] = br.readLine().split("");
		}
		
		printArr(original);
		
		int result = 0;
		int min = getChangedNum(original, 0, 0);
		//System.out.println("result: " + result + ", min: " + min);
		
		if(N > 8) {
			result = getChangedNum(original, N-8, 0);
			if(result < min) min = result;
			//System.out.println("result: " + result + ", min: " + min);
		}
		if(M > 8) {
			result = getChangedNum(original, 0, M-8);
			if(result < min) min = result;
			//System.out.println("result: " + result + ", min: " + min);
		}
		if(N > 8 && M > 8) {
			result = getChangedNum(original, N-8, M-8);
			if(result < min) min = result;
			//System.out.println("result: " + result + ", min: " + min);
		}
		
		System.out.println(min);

	}
	
	public static String[][] deepCopy(String[][] arr){
		String[][] arr2 = new String[arr.length][];
		for(int i=0; i<arr.length; i++) {
			arr2[i] = arr[i].clone();
		}
		return arr2;
	}
	
	
	public static int getChangedNum(String[][] originalArr, int startRow, int startCol) {
		int endRow = startRow - 1 + 8;
		int endCol = startCol - 1 + 8;
		
		int min = Integer.MAX_VALUE;
		
		String[] mainColor = {"B", "W"};
		for(int k=0; k<2; k++) {
			String[][] arr = deepCopy(originalArr);
			printArr(arr);
			int count = 0;
			String subColor = "B";
			if(mainColor[k].equals("B")) subColor = "W";
			//System.out.println("mainColor: " + mainColor[k]);
			//System.out.println("subColor: " + subColor);
			
			for(int i = startRow; i < endRow; i += 2) {
				for(int j = startCol; j < endCol; j += 2) {
					
					if(!arr[i][j].equals(mainColor[k])) {
						count++;
						arr[i][j] = mainColor[k];
					}
					
					if(arr[i][j+1].equals(mainColor[k])) {
						count++;
						arr[i][j+1] = subColor;
					}
					
					if(arr[i+1][j].equals(mainColor[k])) {
						count++;
						arr[i+1][j] = subColor;
					}
					
					if(!arr[i+1][j+1].equals(mainColor[k])) {
						count++;
						arr[i+1][j+1] = mainColor[k];
					}
				}
			}
			printArr(arr);
			//System.out.println("count: " + count + ", min: " + min);
			if(count < min) min = count;
			
		}
		
		return min;
	}
	
	
	public static void printArr(String[][] arr) {
		System.out.println("============================");
		for(int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	

}
