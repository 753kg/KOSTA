package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

public class DeptDAO {
	
	public List<DeptVO> selectAll() {
		List<DeptVO> deptlist = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments order by 1";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				DeptVO dept = new DeptVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return deptlist;
	}
	
	public int insertDept(DeptVO dept) {
		String sql = "insert into departments values(?, ?, ?, ?)";
		Connection conn;
		PreparedStatement st = null;
		int result = 0;
		
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, dept.getDepartment_id());
			st.setString(2, dept.getDepartment_name());
			st.setInt(3, dept.getManager_id());
			st.setInt(4, dept.getLocatoin_id());
			result = st.executeUpdate();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		
		return result;	
	}
}
