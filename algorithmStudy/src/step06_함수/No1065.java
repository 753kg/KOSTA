package step06_함수;

import java.util.Scanner;

public class No1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		int count = 0;
		if(input < 100) count = input;
		else {
			count = 99;
			if(input == 1000) input = 999;
			for(int n=100; n<=input; n++) {
				int i1 = n/100 - (n/10)%10;
				int i2 = (n/10)%10 - n%10;
				if(i1 == i2) count++;
			}
		}
		System.out.println(count);
	}
}
