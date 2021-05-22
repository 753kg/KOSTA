package com.kosta.day05;

public class EmployeeTest2 {

	public static void main(String[] args) {
		Employee emp = new Employee("123", "ȫ�浿", 200);
		emp.setBaseSalary(300);
		double sal = emp.getSalary(1);
		System.out.println("�޿�:" + sal);
		System.out.println(emp);
	}

}
