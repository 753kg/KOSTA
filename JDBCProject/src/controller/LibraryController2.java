package controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import model.BookVO;
import model.BorrowVO;
import model.LibraryDAO;
import model.MemberVO;
import view.LibraryView;

public class LibraryController2 {
	
	static String userID = null;
	static String userPW = null;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		while(true) {
			System.out.print("LIBRARY PROGRAM =========================");
			if(isLogin()) System.out.println(" " + userID + "님 로그인중");
			else System.out.println("=============");
			System.out.println("1.회원가입|2.로그인|3.도서 검색|4.대출/반납/예약|5.마이페이지|6.종료");
			System.out.println("======================================================");
			System.out.print("작업을 선택하세요 >> ");
			int work = sc.nextInt();
			switch (work) {
			case 1:
				signUp();
				break;
			case 2:
				if(isLogin()) { LibraryView.print("이미 로그인이 되어있습니다."); break;}
				logIn();
				break;
			case 3:
				search_main();
				break;
			case 4:
				if(!isLogin()) { LibraryView.print("로그인이 필요한 작업입니다."); break;}
				brr_main();
				break;
			case 5:
				if(!isLogin()) { LibraryView.print("로그인이 필요한 작업입니다.");break;}
				myPage();
				break;
			case 6:
				LibraryView.print("프로그램이 종료되었습니다.");
				sc.close();
				System.exit(0);
			default:
				LibraryView.print("유효하지 않은 작업입니다.");
				break;
			}
		}
		
	}
	
	private static boolean isLogin() {
		if(userID == null || userPW ==  null) 
			return false;
		return true;
	}
	
	private static void signUp() {
		MemberVO member = new MemberVO();
		System.out.print("아이디 >> ");
		member.setM_id(sc.next());
		System.out.print("비밀번호 >> ");
		member.setM_pass(sc.next());
		System.out.print("이름 >> ");
		member.setM_name(sc.next());
		System.out.print("생년월일 [ex)2000-01-01] >> ");
		member.setBirth(Date.valueOf(sc.next()));
		System.out.print("전화번호 [ex)010-0000-0000] >> ");
		member.setPhone(sc.next());
		
		LibraryDAO dao = new LibraryDAO();
		int result =  dao.signUp(member);
		LibraryView.print(result>0 ? "회원가입 되었습니다." : "회원가입에 실패하였습니다.");
		
		userID = member.getM_id();
		userPW = member.getM_pass();
	}
	
	private static void logIn() {
		System.out.print("ID >> ");
		userID = sc.next();
		System.out.print("PW >> ");
		userPW = sc.next();
		LibraryDAO dao = new LibraryDAO();
		int result =  dao.logIn(userID, userPW);
		if(result == 0) {
			userID = null; userPW = null;
			LibraryView.print("로그인에 실패하였습니다.");
		} else LibraryView.print("로그인 되었습니다.");
	}
	
	private static void search_main() {
		boolean run = true;
		while(run) {
			System.out.println("1)도서명으로 검색 2)작가명으로 검색 3)전체 도서 조회 4)카테고리별 조회 5)뒤로가기");
			System.out.print("선택 >> ");
			int num = sc.nextInt();
			aa : switch (num) {
			case 1:
				while(true) {
					System.out.print("도서명을 입력하세요 >> ");
					sc.nextLine();
					selectByBookName(sc.nextLine());
					
					System.out.println("(1)도서명 다시 검색하기 (2)뒤로가기");
					System.out.print("선택 >> ");
					int num2 = sc.nextInt();
					if(num2 == 1) continue;
					break aa;
				}
			case 2:
				while(true) {
					System.out.print("작가명을 입력하세요 >> ");
					sc.nextLine();
					selectByAuthor(sc.nextLine());
					
					System.out.println("(1)작가명 다시 검색하기 (2)뒤로가기");
					System.out.print("선택 >> ");
					int num2 = sc.nextInt();
					if(num2 == 1) continue;
					break aa;
				}
			case 3:
				selectAll();
				break;
	
			case 4:
				while(true) {
					System.out.println("1)소설 2)에세이 3)어린이");
					System.out.print("선택 >> ");
					int num3 = sc.nextInt();
					switch (num3) {
					case 1: selectByCategory("소설"); break;
					case 2: selectByCategory("에세이"); break;
					case 3: selectByCategory("어린이"); break;
					default: break;
					}
					System.out.println("(1)카테고리 다시 검색하기 (2)뒤로가기");
					System.out.print("선택 >> ");
					int num2 = sc.nextInt();
					if(num2 == 1) continue;
					break aa;
				}
				
			case 5:
				run = false;
				break;
			}
		}
	}

	
	private static void brr_main() {
		boolean run = true;
		while(run) {
			System.out.println("1)대출 2)반납 3)예약 4)예약도서대출/반납 5)뒤로가기");
			System.out.print("선택 >> ");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				borrowBook();
				break;
			case 2:
				returnBook();
				break;
			case 3:
				rsvBook();
				break;
			case 4:
				System.out.println("(1)예약도서 대출 (2)예약도서 반납");
				System.out.print("선택>> ");
				int num2 = sc.nextInt();
				switch (num2) {
				case 1:
					rsvBookBorrow();
					break;
				case 2:
					rsvBookReturn();
				default:
					break;
				}
				break;
			case 5:
				run = false;
				break;
			default:
				LibraryView.print("유효하지 않은 작업입니다.");
				break;
			}
		}
		
	}

	private static void rsvBookBorrow() {
		LibraryDAO dao = new LibraryDAO();
		String message = dao.rsvBookBorrow(userID);
		if(message != null) LibraryView.print(message);
		else LibraryView.print("XX대출실패XX : ERROR");
	}

	private static void rsvBookReturn() {
		selectBorrowing();
		LibraryDAO dao = new LibraryDAO();
		System.out.print("반납할 예약 도서의 코드 입력 >> ");
		int b_code = sc.nextInt();
		String message = dao.rsvBookReturn(b_code, userID);
		if(message != null) LibraryView.print(message);
		else LibraryView.print("XX반납실패XX : ERROR");
		
	}

	private static void rsvBook() {
		System.out.print("예약할 책의 코드 입력 >> ");
		int b_code = sc.nextInt();
		LibraryDAO dao = new LibraryDAO();
		String message = dao.rsvBook(b_code, userID);
		if(message != null) LibraryView.print(message);
		else LibraryView.print("XX예약실패XX : ERROR");
	}

	private static void myPage() {
		boolean run = true;
		while(run) {
			System.out.println("1)개인정보수정 2)대출조회/기간연장 3)대출이력조회 4)예약도서조회 5)로그아웃 6)회원탈퇴 7)뒤로가기");
			System.out.print("선택 >> ");
			int num2 = sc.nextInt();
			switch (num2) {
			case 1:
				updateMember();
				break;
			case 2:
				selectBorrowing();
				System.out.println("(1)기간연장하기 (2)뒤로가기");
				System.out.print("선택 >> ");
				int num3 = sc.nextInt();
				switch(num3) {
				case 1:
					extendsDate(); break;
				case 2: break;
				}
				break;
			case 3:
				selectBorrHistory();
				break;
			case 4:
				selectRsvBook();
				break;
			case 5:
				userID = null; userPW = null;
				LibraryView.print("로그아웃 되었습니다.");
				run = false;
				break;
			case 6:
				if(quitMembers()) {
					userID = null; userPW = null;
					run = false;
				}
				break;
			case 7: run = false; break;
			default: LibraryView.print("유효하지 않은 작업입니다."); break;
			}
		}
		
	}

	private static void selectRsvBook() {
		LibraryDAO dao = new LibraryDAO();
		BorrowVO borr = dao.selectRsvBook(userID);
		LibraryView.printBorrows(borr);
	}

	private static boolean quitMembers() {
		LibraryDAO dao = new LibraryDAO();
		System.out.print("비밀번호 확인 >> ");
		int result = dao.quitMembers(userID, sc.next());
		if(result>0) {
			LibraryView.print("회원 탈퇴가 완료되었습니다.");
			return true;
		}
		else{
			LibraryView.print("탈퇴할 수 없습니다.");
			return false;
		}
	}

	private static void extendsDate() {
		// TODO Auto-generated method stub
		System.out.print("기간연장할 책의 코드를 입력하세요>> ");
		LibraryDAO dao = new LibraryDAO();
		int result = dao.extendsDate(sc.nextInt(), userID);
		LibraryView.print(result>0 ? "기간이 연장되었습니다." : "연장할 수 없습니다.");
	}

	private static void updateMember() {
		System.out.print("변경할 비밀번호 >> ");
		String pw = sc.next();
		System.out.print("변경할 전화번호 >> ");
		String phone = sc.next();
		LibraryDAO dao = new LibraryDAO();
		int result = dao.updateMember(pw, phone, userID);
		LibraryView.print(result>0 ? "변경이 완료되었습니다." : "변경할 수 없습니다.");
		
	}

	private static void selectBorrHistory() {
		LibraryDAO dao = new LibraryDAO();
		List<BorrowVO> borrlist = dao.selectBorrHistory(userID);
		LibraryView.printBorrows(borrlist);
	}

	private static void returnBook() {
		selectBorrowing();
		LibraryDAO dao = new LibraryDAO();
		System.out.print("반납할 책의 코드 입력 >> ");
		int borr_code = sc.nextInt();
		String message = dao.returnBook(borr_code, userID);
		if(message != null) LibraryView.print(message);
		else LibraryView.print("XX반납실패XX : ERROR");
	}
	
	private static void selectBorrowing() {
		LibraryDAO dao = new LibraryDAO();
		List<BorrowVO> borrlist = dao.selectBorrowing(userID);
		LibraryView.printBorrows(borrlist);
	}

	
	private static void borrowBook() {
		System.out.print("대출할 책의 코드 입력 >> ");
		int b_code = sc.nextInt();
		LibraryDAO dao = new LibraryDAO();
		String message = dao.borrowBook(b_code, userID);
		if(message != null) LibraryView.print(message);
		else LibraryView.print("XX대출실패XX : ERROR");
	}

	private static void selectByCategory(String category) {
		LibraryDAO dao = new LibraryDAO();
		List<BookVO> booklist = dao.selectByCategory(category);
		LibraryView.printBooks(booklist);
	}


	private static void selectByAuthor(String author) {
		LibraryDAO dao = new LibraryDAO();
		List<BookVO> booklist = dao.selectByAuthor(author);
		LibraryView.printBooks(booklist);
	}

	private static void selectByBookName(String bookName) {
		LibraryDAO dao = new LibraryDAO();
		List<BookVO> booklist = dao.selectByBookName(bookName);
		LibraryView.printBooks(booklist);
	}

	private static void selectAll() {
		LibraryDAO dao = new LibraryDAO();
		List<BookVO> booklist = dao.selectAll();
		LibraryView.printBooks(booklist);
		
	}
	
}
