package com.kosta.day05;
//다른 패키지면 imort
import com.kosta.day04.Employee;

public class EmployeeTest {
	public static void main(String[] args) {
		// main은 static이라
		// static이 아닌 class 사용할 때 new 사용
		
		Employee emp1 = new Employee();
		Employee emp2 = new Employee(2, "홍길동");
		Employee emp3 = new Employee(3, "김길동", "개발부");
		Employee emp4 = new Employee(4, "박길동", "교육부", "010-8888-9999");
		
		// 변수값 직접 바꾸기X, 함수를 통해서 수정(더 바람직)
		// emp1.phone = "010-2222-3333" (X)
		emp1.changePhone("010-2222-3333");
		emp1.print();
		emp2.changePhone("010-5555-6666");
		emp2.print();
		
		String s = emp3.getEmpInfo();
		System.out.println(s);
		String s2 = emp4.getEmpInfo();
		System.out.println(s2);
		
		String s3 = emp4.changePhone2("010-1111-1111");
		System.out.println("받은값: "+s3);
		s2 = emp4.getEmpInfo();
		System.out.println(s2);
		
		
	}
}