package step03;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
public class No10950 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> x = new ArrayList<>();
		List<Integer> y = new ArrayList<>();
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<n; i++) {
			x.add(sc.nextInt());
			y.add(sc.nextInt());
		}
		for(int i=0; i<n; i++) {
			System.out.println(x.get(i) + y.get(i));
		}
	}

}
*/
public class No10950 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		//for(int i=s.nextInt();i>0;i--)
		int n = s.nextInt();
		for(int i=0; i<n; i++)
			System.out.println(s.nextInt()+s.nextInt());
	}
}
