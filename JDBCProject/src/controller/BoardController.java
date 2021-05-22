package controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.BoardDAO;
import model.BoardVO;
import view.BoardView;

public class BoardController {

	public static void main(String[] args) {
		
		// 유저가 작업 선택하도록
		Scanner sc = new Scanner(System.in);
		BoardVO b = null;
		
		int user = 0;
		String pass = null;
		
		while(true) {
			System.out.println("[작업선택]");
			System.out.println("0.로그인|1.모두조회|2.번호로조회|3.입력|4.수정|5.삭제|9.종료");
			System.out.print("선택>> ");
			int work = sc.nextInt();
			
			switch (work) {
			case 0:
				System.out.print("ID>> ");
				user = sc.nextInt();
				System.out.print("PASSWORD>> ");
				pass = sc.next();
				break;
			case 1:
				selectAll();
				break;
			case 2:
				System.out.print("조회할번호>> ");
				selectById(sc.nextInt());
				break;
			case 3:
				if(!isLogin(user, pass)) break;
				insertBoard(sc, user, pass);
				break;
			case 4:
				if(!isLogin(user, pass)) break;
				updateBoard(sc, user, pass);
				break;
			case 5:
				if(!isLogin(user, pass)) break;
				deleteBoard(sc, user, pass);
				break;
			case 9:
				BoardView.print("프로그램 종료");
				System.exit(0);		// 프로그램종료
			default:
				break;
			}
			
			
		}
		
		
		/* 수업
		int id = 101;
		String password = "짱구12";
		for(int i = 0; i < 10; i++) {
			BoardVO b = new BoardVO();
			b.setBoard_title("제목"+i);
			b.setBoard_contents("게시내용"+i);
			b.setBoard_writer(id);
			b.setBoard_password(password);
			b.setBoard_image("images/logo"+i+".png");
			
			BoardDAO dao = new BoardDAO();
			int result = dao.insertBoard(b);
			BoardView.print(result > 0 ? "입력성공" : "입력실패");
		}
		*/
		
		/* 내가한거 */
		// board select
		// selectAll();
				
		// board insert
		// insertBoard();
		
		// board update
		// updateBoard();
		
		// board delete
		// deleteBoard();
		
		// board id로 select... view count 증가해야함... update set
		// selectById(12);
		
		// 회원가입 insert into member
	}
	
	private static boolean isLogin(int user, String pass) {
		if(user == 0 || pass ==  null) {
			BoardView.print("로그인 하세요");
			return false;
		}
		return true;
	}

	private static void updateBoard(Scanner sc, int id, String password) {
		//Scanner sc = new Scanner(System.in);
		System.out.print("게시글번호>> ");
		int seq = sc.nextInt();
		System.out.print("TITLE>> ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.print("CONTENTS>> ");
		String contents = sc.nextLine();
		System.out.print("IMAGE>> ");
		String image = sc.nextLine();
		//System.out.print("PASSWORD>> ");
		//String password = sc.nextLine();
		//sc.close();
		
		BoardDAO dao = new BoardDAO();
		//int result = dao.updateBoard(board_seq, board_password, board_title, board_contents, board_image);
		int result = dao.updateBoard(seq, password, title, contents, image);
		BoardView.print(result > 0 ? "수정성공" : "수정실패");
		
	}



	private static void deleteBoard(Scanner sc, int id, String password) {
		//Scanner sc = new Scanner(System.in);
		System.out.print("게시글번호>> ");
		int seq = sc.nextInt();
		//System.out.print("PASSWORD>> ");
		//sc.nextLine();
		//String password = sc.nextLine();
		//sc.close();
		
		BoardDAO dao = new BoardDAO();
		//int result = dao.deleteBoard(board_seq, board_password);
		int result = dao.deleteBoard(seq, password);
		BoardView.print(result > 0 ? "삭제성공" : "삭제실패");
	}



	private static void selectById(int board_seq) {
		BoardDAO dao = new BoardDAO();
		BoardVO b = dao.selectByNo(board_seq);
		BoardView.print(b);
	}



	private static void selectAll() {
		BoardDAO dao = new BoardDAO();
		BoardView.print(dao.selectAll());
//		List<BoardVO> boardlist = dao.selectAll();
//		BoardView.print(boardlist);
	}

	private static void insertBoard(Scanner sc, int id, String password) {
		
		//Scanner sc = new Scanner(System.in);
		//System.out.print("ID>> ");
		//int id = sc.nextInt();
		//System.out.print("PASSWORD>> ");
		//sc.nextLine();
		//String password = sc.nextLine();
		sc.nextLine();
		System.out.print("TITLE>> ");
		String title = sc.nextLine();
		System.out.print("CONTENTS>> ");
		String contents = sc.nextLine();
		System.out.print("IMAGE>> ");
		String image = sc.nextLine();
		//sc.close();
		
		//BoardVO b = new BoardVO(0, "훈이예요", "안녕하세요", 104, Date.valueOf(LocalDate.now()), 0, "훈이12", "images/logo4.png");
		// BoardVO b = new BoardVO(0, title, contents, id, Date.valueOf(LocalDate.now()), 0, password, image);
		// BoardVO b = new BoardVO(0, title, contents, id, null, 0, password, image);
		BoardVO b = new BoardVO();
		b.setBoard_title(title);
		b.setBoard_contents(contents);
		b.setBoard_writer(id);
		b.setBoard_password(password);
		b.setBoard_image(image);
		
		BoardDAO dao = new BoardDAO();
		int result = dao.insertBoard(b);
		BoardView.print(result > 0 ? "입력성공" : "입력실패");
//		if(result > 0) BoardView.print("입력성공!!"); 
//		else BoardView.print("입력실패..");
		//System.out.println(result > 0 ? "입력성공" : "입력실패");
	}

}
