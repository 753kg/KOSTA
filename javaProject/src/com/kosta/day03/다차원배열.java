package com.kosta.day03;

import java.util.Arrays;

public class 다차원배열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method7();

	}
	
	// 값의 전달 = 복사
	// 7의 a와 8의 a는 다른 변수
	private static void method7() {
		int a = 100;
		System.out.println("before: "+a);
		method8(a);
		System.out.println("after: "+a);
		
	}

	private static void method8(int a) {
		a = 300;
		System.out.println(a);
		
	}

	// 주소의 전달
	private static void method5() {
		int[] arr1 = new int[] {100, 99, 70, 88, 95};
		System.out.println("before: "+Arrays.toString(arr1));
		method6(arr1);
		//int[] scores = arr1; 		주소를 넘겨주는 것과 같음. 
		System.out.println("after: "+Arrays.toString(arr1));
		
	}

	private static void method6(int[] scores) {
		scores[0] = 300;
		System.out.println(Arrays.toString(scores));
		
		
	}

	private static void method4() {
		// 배열을 복사하는 방법
		int[] arr1 = new int[] {100, 99, 70, 88, 95};
		int[] arr2 = new int[arr1.length];
		
		// 1.
		int[] arr3 = new int[arr1.length];
		System.arraycopy(arr1, 0, arr3, 0, arr1.length);
		
		// 2.
		int[] arr4 = Arrays.copyOf(arr1, arr1.length);
		
		// 3.
		for(int i=0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		arr1[0] = 200;
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		
		
	}

	private static void method3() {
		String[][] arr = new String[][] 
				{{"자바","SQL","WEB"},{"HTML5", "CSS3"}};
				
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				System.out.print(arr[row][col]+"\t");
			}
			System.out.println();
		}
		
		// 복사X, 주소를 넣는다. 같은 주소를 참조한다.
		String[][] arr2 = arr;
		arr2[0][0] = "java";
		System.out.println(arr2[0][0]);
		System.out.println(arr[0][0]);		// 둘다 바뀜
		
	}

	private static void method2() {
		String[][] arr;
		arr = new String[3][];	// 앞 배열 갯수는 필수
		
		for(int i =0; i<arr.length; i++) {
			//System.out.println(arr[i]);
			arr[i] = new String[i+4];
			
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}	
	}

	private static void method1() {
		int[][] arr;
		int arr2[][];
		int[] arr3[];
		
		arr = new int[5][7];
		arr2 = new int[2][];
		arr2[0] = new int[3];
		arr2[1] = new int[4];
		
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				System.out.print(arr[row][col]+" ");
			}
			System.out.println();
		}
		
//		System.out.println(arr[0][0]);
//		System.out.println(arr[0][1]);
//		System.out.println(arr[0][2]);
//		
//		System.out.println(arr[1][0]);
//		System.out.println(arr[1][1]);
//		System.out.println(arr[1][2]);
		
	}

}