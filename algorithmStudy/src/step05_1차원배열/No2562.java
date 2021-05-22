package step05_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2562 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE;
		int maxidx = 0;
		for(int i=1; i<=9; i++) {
			int num = Integer.parseInt(br.readLine());
			max = Math.max(max, num);
			if(max == num) maxidx = i;
		}
		System.out.printf("%d\n%d", max, maxidx);
	}

}
