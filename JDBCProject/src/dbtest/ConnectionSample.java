package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionSample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// DB 연결 방법
		
		// 1. Oracle Driver 준비 >> .jar
		String driverName = "oracle.jdbc.driver.OracleDriver";
		Class.forName(driverName);		// driver를 메모리에 올리기
		System.out.println("1. driver load 성공");
		
		// 2. DB 연결 : Connection Class 사용
		Connection conn = null;
		// 나의oracle->Properties->DriverProperties->ConnectionURL
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "hr", password = "hr";
		conn = DriverManager.getConnection(url, userid, password);
		System.out.println("2. Connection 성공");
		
		// 3. SQL문 실행
		String sql = 
				" select first_name, last_name, salary" +
				" from employees" +
				" where employee_id = 100";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {	// 다음게있는지확인
			String fname = rs.getString(1);
			String lname = rs.getString(2);
			int sal = rs .getInt(3);
			System.out.println(fname + "\t" + lname + "\t" + sal);
		}	
		 
			 // 자원반납... DB연결해제
			 rs.close();
			 st.close();
			 conn.close();
	}

}
