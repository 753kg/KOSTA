package step02;

import java.util.Scanner;
public class No2753 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int year = s.nextInt();
		System.out.println(((year % 4 == 0 && year % 100 != 00) || year % 400 == 0)?1:0); 
	}
}
/*
������ ������ 4�� ����̸鼭, 100�� ����� �ƴ� �� �Ǵ� 400�� ����� ���̴�.

���� ���, 2012���� 4�� ����̸鼭 100�� ����� �ƴ϶� �����̴�. 
1900���� 100�� ����̰� 400�� ����� �ƴϱ� ������ ������ �ƴϴ�. 
������, 2000���� 400�� ����̱� ������ �����̴�.

���� ==> 400�ǹ��
if((year % 4 == 0 && year % 100 != 00) || year % 400 == 0)

����X 
year % 100 == 0 && year % 400 != 0
*/