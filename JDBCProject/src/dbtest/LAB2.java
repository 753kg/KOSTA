package dbtest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;

public class LAB2 {

	public static void main(String[] args) {
		// 급여를 가변으로 입력받아서 입력값 이상의 급여를 받는 직원 조회
		// 직원이름, 급여, 입사일, 부서번호 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("급여 입력>> ");
		int inputSal = sc.nextInt();
		
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = " select first_name, salary, hire_date, department_id" + 
					" from employees" + 
					" where salary >= " + inputSal;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				String fname = rs.getString("first_name");
				int salary = rs.getInt("salary");
				Date hireDate = rs.getDate("hire_date");
				int departmentId = rs.getInt("department_id");
				System.out.println(fname + "\t" + salary + "\t" + hireDate + "\t" + departmentId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
	}

}
