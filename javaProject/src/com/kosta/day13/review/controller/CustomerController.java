package com.kosta.day13.review.controller;

import java.util.List;
import java.util.Scanner;

import com.kosta.day13.review.model.CustomerDTO;
import com.kosta.day13.review.model.CustomerService;
import com.kosta.day13.review.view.CustomerView;

public class CustomerController {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		CustomerService service = new CustomerService();
		//List<CustomerDTO> custlist = null;
		CustomerDTO cust = null;
		int result = 0;
		
		boolean run = true;
		while(run) {
			System.out.println("1.모두조회 | 2.특정고객조회 | 3.전화번호로조회 | 4.입력 | 5. 수정 | 6. 삭제 | 7. 종료");
			System.out.print("작업선택>> ");
			
			int selectNo = sc.nextInt();
			
			switch (selectNo) {
			case 1:
				CustomerView.display(service.selectAll());
				break;
			case 2:
				System.out.print("조회할 ID>> ");
				cust = service.selectById(sc.nextInt());
				CustomerView.display(cust);
				break;
			case 3:
				System.out.print("조회할 전화번호>> ");
				cust = service.selectByPhone(sc.next());
				CustomerView.display(cust);
				break;
			case 4:
				System.out.print("신규 입력(id 이름 전화번호 주소)>> ");
				cust = new CustomerDTO(sc.nextInt(), sc.next(), sc.next(), sc.next());
				result = service.insert(cust);
				CustomerView.display(result==1?"입력성공":"입력실패");
				break;
			case 5:
				System.out.print("수정 정보(id 이름 전화번호 주소)>> ");
				cust = new CustomerDTO(sc.nextInt(), sc.next(), sc.next(), sc.next());
				result = service.update(cust);
				CustomerView.display(result==1?"입력성공":"입력실패");
				break;
			case 6:
				System.out.print("삭제할 ID>> ");
				result = service.delete(sc.nextInt());
				CustomerView.display(result==1?"입력성공":"입력실패");
				break;
			case 7:
				run = false;
				break;
				

			default:
				break;
			}
			
		}
		System.out.println("----------------작업종료-----------------");
		sc.close();
		
	}

}
