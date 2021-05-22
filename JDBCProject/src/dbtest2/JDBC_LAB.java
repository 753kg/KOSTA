package dbtest2;

import java.sql.*;

import util.DBUtil;

public class JDBC_LAB {
	
	static Connection conn;
	static Statement st;
	static ResultSet rs;

	public static void main(String[] args) throws SQLException {
		
		// method1("john");
//		method2(60);
		method1("john");
	}
	
	private static void method3(String fname) throws SQLException {
		// method1() 효율적인 방법으로 바꾸기
		String sql = " select salary, hire_date, first_name||' '||last_name" +
					" from employees" +
					" where first_name = initcap(?) ";
		
		conn = DBUtil.getConnection();
		
		PreparedStatement pst;
		pst = conn.prepareStatement(sql);
		pst.setString(1, fname);
		
		rs = pst.executeQuery();
		
		while(rs.next()) {
			int salary = rs.getInt(1);			// select 문의 컬럼 순서. 1부터 읽음
			Date dt = rs.getDate("hire_date");	// 컬럼이름써도됨. 컬럼이름은대소문자구별X
			String first_name = rs.getString(3);
			System.out.println("이름: "+first_name);
			System.out.println("입사일: "+dt);
			System.out.println("급여: "+salary);
			System.out.println("--------------------------------");
		}
		
		DBUtil.dbClose(rs, pst, conn);
		
	}
	
	private static void method2(int did) throws SQLException {
		// 효율적인 방법
		String sql = " select salary, hire_date, first_name||' '||last_name, department_id" +
					" from employees" +
					" where department_id = ?";		// ? : 바인딩변수
		
		conn = DBUtil.getConnection();
		
		// PreparedStatement : ?(바인딩변수) 지원. Statement를 상속받은 class이다. 
		PreparedStatement pst;
		pst = conn.prepareStatement(sql);	// sql문장 먼저 준비
		pst.setInt(1, did);		// 1번째 물음표에 did 넣기
		
		rs = pst.executeQuery();
		while(rs.next()) {
			int salary = rs.getInt(1);			// select 문의 컬럼 순서. 1부터 읽음
			Date dt = rs.getDate("hire_date");	// 컬럼이름써도됨. 컬럼이름은대소문자구별X
			String first_name = rs.getString(3);
			int dept_id = rs.getInt("department_id");
			System.out.println("이름: "+first_name);
			System.out.println("부서: "+dept_id);
			System.out.println("입사일: "+dt);
			System.out.println("급여: "+salary);
			System.out.println("--------------------------------");
		}
		
		DBUtil.dbClose(rs, pst, conn);
		
	}

	private static void method1(String fname) throws SQLException {
		String sql = " select salary, hire_date, first_name||' '||last_name" +
					" from employees" +
					" where first_name = initcap('"
					+ fname
					+ "')";
		// 1. DB 연결
		conn = DBUtil.getConnection();
		// 2. DB와 대화하는 통로 만들기
		st = conn.createStatement();
		// 3. 대화하기 - SQL문 실행
		rs = st.executeQuery(sql);
		// 4. select 결과 사용하기
		// rs.next() : 읽기 위해 접근
		while(rs.next()) {
			int salary = rs.getInt(1);			// select 문의 컬럼 순서. 1부터 읽음
			Date dt = rs.getDate("hire_date");	// 컬럼이름써도됨. 컬럼이름은대소문자구별X
			String first_name = rs.getString(3);
			System.out.println("이름: "+first_name);
			System.out.println("입사일: "+dt);
			System.out.println("급여: "+salary);
			System.out.println("--------------------------------");
		}
		
		DBUtil.dbClose(rs, st, conn);
		
	}

}
