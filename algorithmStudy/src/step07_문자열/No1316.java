package step07_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		point:for(int i=0; i<n; i++) {
			String s = br.readLine();
			// ex) aba
			// ccc
			for(int j=1; j<s.length(); j++) {
				char ch = s.charAt(j); // j=2, ch = a
				int index = s.indexOf(ch); // index = 0
				//if(index < (j - 1)) continue point;
				if(index == j) continue;
				if(index != -1) {
					if(ch != s.charAt(j-1)) continue point;
				}
			}
			count++;
		}
		System.out.println(count);
	}

}
