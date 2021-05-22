package step05_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class No3052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<10; i++) {
			set.add(Integer.parseInt(br.readLine()) % 42);
		}
		System.out.println(set.size());
	}

}

/* �ߺ�üũ
public class No3052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[42];
		for(int i=0; i<10; i++) {
			int r = Integer.parseInt(br.readLine()) % 42;
			arr[r] = 1;
		}
		int count = 0;
		for(int i:arr) {
			if(i != 0) count++;
		}
		System.out.println(count);
	}

}
*/
