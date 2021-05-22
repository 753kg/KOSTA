package step02;

import java.util.Scanner;

public class No2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hh = sc.nextInt();
		int mm = sc.nextInt();
		if(mm >= 45) System.out.println(hh+" "+(mm-45));
		else System.out.println((hh!=0?(hh-1):23)+" "+(mm+15));
	}

}
