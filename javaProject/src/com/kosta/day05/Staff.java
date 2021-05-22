package com.kosta.day05;

public class Staff {
	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;
	
	public Staff(String name, String title, int baseSalary) {
		super();
		this.name = name;
		this.title = title + "님";
		this.baseSalary = baseSalary;
	}
	public void getTotalSalary() {
		if(title.equals("부장님")) {
			totalSalary = (int)( baseSalary + baseSalary * 0.25);
		}else if(title.equals("과장님")) {
			totalSalary = (int)( baseSalary + baseSalary * 0.15);
		}else {
			totalSalary = (int)( baseSalary + baseSalary * 0.05);
		}
		
		switch (title) {
		case "부장님":
			totalSalary = (int)( baseSalary + baseSalary * 0.25);
			break;
		case "과장님":
			totalSalary = (int)( baseSalary + baseSalary * 0.15);
			break;
		default:
			totalSalary = (int)( baseSalary + baseSalary * 0.05);
			break;
		}
		
		
		
	}
	public void print() {
		getTotalSalary();
		System.out.println(title + " 직급의 "
				+ name
				+ "씨의 본봉은 "
				+ baseSalary
				+ " 원이고 총급여는 "
				+ totalSalary
				+ " 원입니다.");
	}
 	public static void main(String[] args) {
 		Staff[] arr = new Staff[4];
 		
 		arr[0] = new Staff("이부장", "부장", 1500000);
 		arr[1] = new Staff("김과장", "과장", 1300000);
 		arr[2] = new Staff("최대리", "대리", 1200000);
 		arr[3] = new Staff("박사원", "사원", 1000000);
		
 		for(Staff emp :arr) {
 			emp.print();
 		}
		
		
	}
}
/*
부장 직급의 이부장씨의 본봉은 1500000 원이고 총급여는 1875000 원입니다.
과장 직급의 김과장씨의 본봉은 1300000 원이고 총급여는 1495000 원입니다.
대리 직급의 최대리씨의 본봉은 1200000 원이고 총급여는 1260000 원입니다.
사원 직급의 박사원씨의 본봉은 1000000 원이고 총급여는 1050000 원입니다.
*/