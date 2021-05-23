package step08_기본수학1;

import java.io.IOException;
import java.util.Scanner;

public class No2292 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		long last = 1;
		long count = 1;
		if(n == 1) {
			System.out.println(1);
			System.exit(0);
		}
		while(true) {
			last += 6 * count;
			if(n <= last) break;
			count++;
		}
		System.out.println(count + 1);
	}

}
