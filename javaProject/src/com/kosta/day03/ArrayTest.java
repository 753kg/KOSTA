package com.kosta.day03;

public class ArrayTest {

	public static void main(String[] args) {
		//4장LAB(2차배열)
		
		int[][] a = new int[][] 
				{{30, 30, 30, 30},{40, 40, 40, 40},{50, 50, 50, 50}};
			
		int[][] b = new int[][] 
				{{1, 2, 3, 4},{5, 6, 7, 8},{9, 10, 11, 12}};
		
		int[][] c = new int[3][4];
		
		// 행렬의 차를 구하는 메서드 ( a - b = c)
		method1(a, b, c);
		
		// 결과 c를 출력하는 메소드
		method2(a);
		method2(b);
		method2(c);

	}

	private static void method2(int[][] c) {
		for(int i=0; i<c.length; i++) {
			for(int j=0; j<c[i].length; j++) {
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static void method1(int[][] a, int[][] b, int[][] c) {
		for(int row=0; row<a.length; row++) {
			for(int col=0; col<a[row].length; col++) {
				c[row][col] = a[row][col] - b[row][col];
			}
		}
		
	}

}