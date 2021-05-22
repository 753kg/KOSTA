package com.kosta.day13.controller;

import java.util.List;
import java.util.Scanner;

import com.kosta.day13.model.CustomerDTO;
import com.kosta.day13.model.CustomerService;
import com.kosta.day13.view.CustomerView;

// 서버프로그램으로 작성될 예정(servlet, controller)
public class CustomerController {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<CustomerDTO> custlist = null;
		CustomerDTO cust = null;
		int result = 0;
		
		CustomerService service = new CustomerService();
		
		while(true) {
			System.out.println("1.모두조회|2.특정고객조회|3.전화번호로조회|4.입력|5.수정|6.삭제|0.종료");
			System.out.print("작업 선택>> ");
			
			int select = sc.nextInt();
			
			if(select == 0) break;
			
			switch (select) {
			case 1:
				custlist = service.selectAll();
				CustomerView.display(custlist);
				break;
			case 2:
				System.out.print("조회할 ID입력>> ");
				int custId = sc.nextInt();
				cust = service.selectById(custId);
				CustomerView.display(cust);
				break;
			case 3:
				System.out.print("조회할 전화번호 입력>> ");
				String p = sc.next();
				cust = service.selectByPhone(p);
				CustomerView.display(cust);
				break;
			case 4:
				System.out.print("신규입력(id 이름 전화번호 주소)>> ");
				cust = new CustomerDTO(sc.nextInt(), sc.next(), sc.next(), sc.next());
				result = service.insert(cust);
				CustomerView.display(result==1?"입력성공":"입력실패");
				break;
			case 5:
				System.out.print("수정정보(id 이름 전화번호 주소)>> ");
				cust = new CustomerDTO(sc.nextInt(), sc.next(), sc.next(), sc.next());
				result = service.update(cust);
				CustomerView.display(result==1?"수정성공":"수정실패");
				break;
			case 6:
				System.out.print("삭제할 id 입력>> ");
				result = service.delete(sc.nextInt());
				CustomerView.display(result==1?"삭제성공":"삭제실패");
				break;

			default:
				break;
			}
			
			
			
		}
		System.out.println("----작업 종료----");
		sc.close();
	}
}
