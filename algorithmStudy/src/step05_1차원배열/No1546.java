package step05_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class No1546 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double[] scores = new double[n];
		double max = 0;
		
		for(int i=0; i<n; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, scores[i]);
		}
		double sum = 0;
		for(int i=0; i<n; i++) {
			scores[i] = scores[i] / max * 100;
			sum += scores[i];
		}
		System.out.println(sum / n);
	}

}

/*
public class No1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] scores = new double[n];
		double max = 0;
		for(int i=0; i<n; i++) {
			double score = sc.nextDouble();
			scores[i] = score;
			max = Math.max(max, score);
		}
		double sum = 0;
		for(int i=0; i<n; i++) {
			scores[i] = scores[i] / max * 100;
			sum += scores[i];
		}
		System.out.println(sum / n);
	}

}
*/
