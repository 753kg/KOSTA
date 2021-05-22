package step04_while;

import java.util.ArrayList;
import java.util.Scanner;

public class No1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int copy = n;
		int cycle = 0;
		while(true) {
			int sum = (copy/10) + (copy%10);
			copy = (copy%10)*10 + (sum%10);
			cycle++;
			if(copy == n) break;
		}
		System.out.println(cycle);
	}

}
/*
public class No1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int fnum1 = n / 10;		// 10의자리
		int fnum2 = n % 10;		// 1의자리
		int n1 = fnum1;
		int n2 = fnum2;
		int sum = n1 + n2;
		int cycle = 0;
		while(true) {
			n1 = n2;
			n2 = sum % 10;
			sum = n1 + n2;
			cycle++;
			if(n1 == fnum1 && n2 == fnum2) break;
		}
		System.out.println(cycle);
	}

}
*/