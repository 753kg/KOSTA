package step04_while;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String s = "";
		while((s=br.readLine())!= null) {
			//int a = s.charAt(0) - 48;
			//int b = s.charAt(2) - 48;
			//sb.append(a+b).append("\n");
			st = new StringTokenizer(s);
			sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
		}
		System.out.println(sb);
	}
}

// ���� ������ ����.
// �Է¿��� ���� �� �ִ� �����Ͱ� �������� ���� �� �ݺ��� ����
// EOF(End of File) ==> (s=br.readLine())!= null

// �Է��� ���ڸ�������, �׻� ������ ��ġ ==> charAt