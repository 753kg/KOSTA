package com.kosta.business;
//import ==> ctrl+shift+o
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.model.DeptVO;
import com.kosta.model.LocationVO;
import com.kosta.model.ManagerVO;
import com.kosta.util.DBUtil;

// bean으로 등록
@Repository("deptDAO_jdbc")	// bean의 이름
public class DeptDAO implements DeptDAOInterface{
	
	// 1. 생성자로 injection
	// 2. setter로 injection
	// 3. Autowired로 injection = type이 똑같은거
	@Autowired
	DataSource dataSource;
	
	public List<DeptVO> findAll() {
		List<DeptVO> deptlist = new ArrayList<>();
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from departments order by 1";
		
		try {
			conn = dataSource.getConnection();
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
	
	public DeptVO findById(int deptid) {
		DeptVO dept = null;
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from departments where department_id = ?";
		
		try {
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, deptid);
			rs = st.executeQuery();
			while(rs.next()) {
				dept = new DeptVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return dept;
	}
	
	public List<LocationVO> findAllLocation() {
		List<LocationVO> loclist = new ArrayList<>();
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from locations order by 1";
		
		try {
			conn = dataSource.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				LocationVO vo = new LocationVO();
				vo.setLocation_id(rs.getInt(1));
				vo.setCity(rs.getString("city"));
				loclist.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return loclist;
	}
	
	public List<ManagerVO> findAllManager() {
		List<ManagerVO> mlist = new ArrayList<>();
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = 
				" select employee_id, first_name||' '||last_name fullname" +
				" from EMPLOYEES" +
				" where employee_id in (select distinct manager_id from employees)";
		
		try {
			conn = dataSource.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ManagerVO vo = new ManagerVO(rs.getInt(1), rs.getString(2));
				mlist.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return mlist;
	}
	
	public int insert(DeptVO dept) {
		String sql = "insert into departments values(?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;
		
		
		try {
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, dept.getDepartment_id());
			st.setString(2, dept.getDepartment_name());
			st.setInt(3, dept.getManager_id());
			st.setInt(4, dept.getLocation_id());
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

	public int update(DeptVO dept) {
		String sql = "update departments "
				+ "set department_name=?, "
				+ "manager_id=?, "
				+ "location_id = ? "
				+ "where department_id = ?";
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setString(1, dept.getDepartment_name());
			st.setInt(2, dept.getManager_id());
			st.setInt(3, dept.getLocation_id());
			st.setInt(4, dept.getDepartment_id());
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

	public int delete(int deptid) {
		String sql = "delete from departments where department_id = ?";
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			conn = dataSource.getConnection();
			st = conn.prepareStatement(sql);
			st.setInt(1, deptid);
			result = st.executeUpdate();
		} catch (SQLException e) {	
			// 에러 처리를 DAO에서 하기 때문에 xml에 등록한 에러페이지로 이동을 안함. Controller까지 에러가 와야한다.
			// RuntimeException : 컴파일 시에는 에러가 안나고 실행했을 때 에러가 남 ex) 10 / 0
			//					: 에러를 JVM이 처리하도록함
			throw new RuntimeException(e.getMessage());
		} finally {
			DBUtil.dbClose(null, st, conn);
		}
		return result;
	}
}
