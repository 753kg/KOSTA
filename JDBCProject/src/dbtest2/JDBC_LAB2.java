package dbtest2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class JDBC_LAB2 {
	
	static Connection conn;
	static PreparedStatement pst;
	static ResultSet rs;
	static String sql;

	public static void main(String[] args) throws SQLException {
//		int[] arr = {30, 50, 80, 90, 100};
//		method1(arr, 5000, 17000);
												// main : Controller
		List<EmpData> emplist = method2("r");	// Model - DAO
		myPrint(emplist);						// View
												// ==> MVC 모델
		
	}
	
	private static void myPrint(List<EmpData> emplist) {
		for(EmpData emp:emplist) {
			System.out.println(emp);
		}
	}

	private static List<EmpData> method2(String ch) throws SQLException {
		
		List<EmpData> emplist = new ArrayList<>();
		
		sql = 
				" select first_name, last_name, salary, hire_date" +
				" from employees" +
				" where first_name like '__'||?||'%'";
		
		conn = DBUtil.getConnection();
		pst = conn.prepareStatement(sql);
		pst.setString(1, ch);
		rs = pst.executeQuery();
		while(rs.next()) {
			emplist.add(new EmpData(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDate(4)));
		}
		DBUtil.dbClose(rs, pst, conn);
		return emplist;
	}

	private static void method1(int[] depts, int minSal, int maxSal) throws SQLException {
		String dept_where = " and department_id in (";
		for(int i:depts) {
			dept_where += "?,";
		}
		dept_where = dept_where.substring(0, dept_where.length()-1) + ")";
		System.out.println(dept_where);
		sql = 
			" select *" +
			" from employees" +
			" where to_char(hire_date, 'yyyy') between '2000' and '2009'" +
			dept_where +
			" and salary between ? and ?" +
			" and commission_pct is not null" +
			" order by hire_date, salary desc";
		
		// 1. connection
		conn = DBUtil.getConnection();
		// 2. prepared statement
		pst = conn.prepareStatement(sql);
//		Array arr = conn.createArrayOf("INTEGER", detps)  ==> 지원안됨.
//		pst.setArray(1, arr);
		int cnt = 1;
		for(int i:depts) {
			pst.setInt(cnt++, i);		// 사용하고 ++
		}
		pst.setInt(cnt++, minSal);
		pst.setInt(cnt++, maxSal);
		// 3. binding변수 setting
		rs = pst.executeQuery();
		while(rs.next()) {
			int empid = rs.getInt(1);
			String fname = rs.getString(2);
			Date d = rs.getDate("hire_date");
			int sal = rs.getInt("salary");
			int dept = rs.getInt("department_id");
			double comm = rs.getDouble("commission_pct");
			System.out.println(empid + fname + d + sal + dept + comm);
			
		}
		
		// 4. sql execute
		// 5. result read
		// 6. db close.
		DBUtil.dbClose(rs, pst, conn);
	}

}
