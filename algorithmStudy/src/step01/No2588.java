package step01;

import java.util.Scanner;

/*
public class No2588 {
 
	 public static void main(String[] args) { 
	 	Scanner sc = new Scanner(System.in);
	 	int v1 = Integer.parseInt(sc.nextLine()); 
	 	String v2 = sc.nextLine(); 
	 	for(int i=v2.length()-1; i>=0; i--) { 
	 		int a = v2.charAt(i) - '0';
			System.out.println(v1 * a); 
		} 
		System.out.println(v1 * Integer.parseInt(v2));
	 } 
}
 */

public class No2588 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		System.out.printf("%d\n%d\n%d\n%d",b%10*a,b%100/10*a,b/100*a,a*b);
	}
}
