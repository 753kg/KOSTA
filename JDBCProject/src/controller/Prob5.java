package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import util.DBUtil;


public class Prob5 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("조회하고자 하는 직원의 이름 일부를 입력하세요>>");
		String name = sc.next();
		new Prob5().printEmployee(name);
	}
	
	public void printEmployee(String name) {
		 Connection conn = DBUtil.getConnection();
		 PreparedStatement st = null;
		 ResultSet rs = null;
		 String sql =
				 " select employee_id, first_name, salary" +
				 " from employees" +
				 " where first_name like '%'||?||'%'";
		 try {
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			
			System.out.println("employee_id\tfirst_name\tsalary");
			int count = 0;
			while(rs.next()) {
				int employee_id = rs.getInt(1);
				String first_name = rs.getString(2);
				int salary = rs.getInt(3);
				System.out.println(employee_id + "\t\t" + first_name + "\t\t" + salary);
				count ++;
			}
			System.out.println("총 " + count + "건");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
	}
	
	
	public void printEmployee2(String name) {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		 Connection conn = null;
		 PreparedStatement st = null;
		 ResultSet rs = null;
		 String sql =
				 " select employee_id, first_name, salary" +
				 " from employees" +
				 " where first_name like '%'||?||'%'";
		 try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			
			System.out.println("직원번호\t이름\t급여");
			
			int count = 0;
			while(rs.next()) {
				int employee_id = rs.getInt(1);
				String first_name = rs.getString(2);
				int salary = rs.getInt(3);
				System.out.println(employee_id + "\t" + first_name + "\t" + salary);
				count ++;
			}
			System.out.println("총 " + count + "건");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}

/*
 * 문제5. 키보드로부터 직원의 이름 일부를 입력 받아서 employees 테이블에서 해당 사원의 사번(employee_id), 이름(first_name), 급여(salary) 를 출력하는 메소드를 작성하시오.
public void printEmployee(String name)
Driver Name : oracle.jdbc.driver.OracleDriver
URL  :  jdbc:oracle:thin:@localhost:1521:xe
User: hr
Password: hr
1.	printEmployee(String name) 메소드를 구현합니다.
2.	키보드로부터 입력 받아 읽어오는 부분은 main 메소드 내에 구현되어 있습니다.
3.	main 메소드를 포함하여 주어진 메소드의 시그니처는 변경하지 않고 그대로 사용합니다.
4.	아래의 예시는 직원이름에 “D”가 들어있는 경우의 결과를 출력한 것입니다.

 */
