package step05_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class No2577 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		Scanner sc = new Scanner(System.in);
		int total = 1;
		for(int i=0; i<3; i++) {
			total *= sc.nextInt();
		}
		*/
		int a, b, c, total;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = Integer.parseInt(br.readLine());
		b = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());
		total = a * b * c;
		
		int[] arr = new int[10];
		String t = String.valueOf(total);
		
		for(int i=0; i<t.length(); i++) {
			int j = t.charAt(i) - 48;
			arr[j]++;
		}
		
		for(int k:arr) System.out.println(k);
	}

}
// 17037300