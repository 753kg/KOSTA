package step06_함수;

public class No4673 {
	
	public static void main(String[] args) {
		boolean[] check = new boolean[10001];
		StringBuffer sb = new StringBuffer();
		
		for(int i=1; i<=10000; i++) {
			int n = d(i);
			if(n <= 10000) check[n] = true;
		}
		
		for(int i=1; i<=10000; i++) {
			if(!check[i]) sb.append(i).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int d(int n) {
		int sum = n;
		while(n != 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}

}
