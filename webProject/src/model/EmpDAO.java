package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

// DAO(Data Access Object) : DB에 가서 작업해야하는 비즈니스 로직
public class EmpDAO {
	
	// 1. 모든 직원 조회
	public List<EmpVO> selectAll() {
		List<EmpVO> emplist = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from employees";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emplist;
	}

	// 2. 기본키(Primary key)... null 불가, 필수 컬럼, 중복 없음
	//    직원번호로 조회
	public EmpVO selectById(int empid) {
		EmpVO emp = null;
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from employees where employee_id = ?";
		
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, empid);
			rs = st.executeQuery();
			while(rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emp;
	}
	
	// 3. 부서번호로 조회
	public List<EmpVO> selectByDept(int deptid) {
		List<EmpVO> emplist = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from employees where department_id = ?";
		
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, deptid);
			rs = st.executeQuery();
			while(rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emplist;
	}
	
	// 4. job_id로 조회
	public List<EmpVO> selectByJob(String jobid) {
		List<EmpVO> emplist = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from employees where job_id = ?";
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, jobid);
			rs = st.executeQuery();
			while(rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emplist;
	}
	
	// 5. 급여로 조회
	public List<EmpVO> selectBySalary(int minsal, int maxsal) {
		List<EmpVO> emplist = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from employees where salary between ? and ?";
		
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, minsal);
			st.setInt(2, maxsal);
			rs = st.executeQuery();
			while(rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emplist;
	}
	
	// 6. 입사일로 조회
	public List<EmpVO> selectByDate(String sdate, String edate) {
		List<EmpVO> emplist = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from employees" +
					" where hire_date between ? and ?";
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, sdate);				// string -> date 자동형변환
			st.setString(2, edate);
			rs = st.executeQuery();
			while(rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emplist;
	}
	
	public List<EmpVO> selectByDate2(Date sdate, Date edate) {
		List<EmpVO> emplist = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from employees" +
					" where hire_date between ? and ?";
		
		try {
			st = conn.prepareStatement(sql);
			st.setDate(1, sdate);				// string -> date 자동형변환
			st.setDate(2, edate);
			rs = st.executeQuery();
			while(rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emplist;
	}
	
	// 7. 이름에 특정문자가 들어간 사람 조회
	public List<EmpVO> selectByName(String str) {
		List<EmpVO> emplist = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from employees where first_name like ? ";
//		String sql = "select * from employees where instr(first_name, ?) > 0";
		
		try {
			st = conn.prepareStatement(sql);
//			st.setString(1, str);
			st.setString(1, "%"+str+"%");
			rs = st.executeQuery();
			while(rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emplist;
	}
	
	// 8. 여러 조건으로 조회 (부서, job, salary, hire_date)
	public List<EmpVO> selectByCondition(int deptid, String jobid, int sal, Date hdate) {
		List<EmpVO> emplist = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = " select * from employees" +
					" where department_id = ? " +
					" and job_id = ?" +
					" and salary >= ?" +
					" and hire_date between ? and add_months(?, 24)";
													// 2년 후
		
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, deptid);
			st.setString(2, jobid);
			st.setInt(3, sal);
			st.setDate(4, hdate);
			st.setDate(5, hdate);
			rs = st.executeQuery();
			while(rs.next()) {
				emplist.add(makeEmp(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return emplist;
	}
	

	private EmpVO makeEmp(ResultSet rs) throws SQLException {	//selectAll()에 예외처리 돼있어서 던졌음
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(rs.getDouble("Commission_pct"));	// 컬럼이름은 대소문자구별X
		emp.setDepartment_id(rs.getInt("Department_id"));
		emp.setEmail(rs.getString("Email"));
		emp.setEmployee_id(rs.getInt("Employee_id"));
		emp.setFirst_name(rs.getString("First_name"));
		emp.setHire_date(rs.getDate("Hire_date"));
		emp.setJob_id(rs.getString("Job_id"));
		emp.setLast_name(rs.getString("Last_name"));
		emp.setManager_id(rs.getInt("Manager_id"));
		emp.setPhone_number(rs.getString("Phone_number"));
		emp.setSalary(rs.getInt("Salary"));
		return emp;
	}
	
}
