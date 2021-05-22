package dbtest;

import java.sql.*;

public class ConnectionSample2 {

	public static void main(String[] args) {
		// JDBC(Java DataBase Connection)
		
//		String driverName = "oracle.jdbc.driver.OracleDriver";		// 둘다됨
		String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.172:1521:xe";
		String userid = "hr", password = "hr";
		String sql = "select * from employees";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driverName);
			System.out.println("1. class load 성공");
			conn = DriverManager.getConnection(url, userid, password);
			System.out.println("2. Connection 성공");
			st = conn.createStatement();				// 통로 만들기
			rs = st.executeQuery(sql);
			System.out.println("3. SQL 문장 실행 성공");
			while(rs.next()) {
				String fname = rs.getString(2);
				int salary = rs.getInt("salary");	// 컬럼이름주기
				Date d = rs.getDate("hire_date");
				System.out.println(fname + "\t" + salary + "\t" + d);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
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
