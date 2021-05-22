package com.kosta.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.kosta.util.DBUtil;

// DAO(Data Access Object) : DB�� ���� �۾��ؾ��ϴ� ����Ͻ� ����
public class EmpDAO {
	
							//아이디, 비밀번호 라고 생각...
	public EmpVO loginChk(int empid, String email) {
		EmpVO emp = null;
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from employees where employee_id = ? and email = ?";
		
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, empid);
			st.setString(2, email);
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
	
	// 1. ��� ���� ��ȸ
	public List<EmpVO> selectAll() {
		List<EmpVO> emplist = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from employees order by 1";
		
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
	
	public List<JobVO> selectAllJobs() {
		List<JobVO> joblist = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from jobs order by 1";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				JobVO job = new JobVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				joblist.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		return joblist;
	}

	// 2. �⺻Ű(Primary key)... null �Ұ�, �ʼ� �÷�, �ߺ� ����
	//    ������ȣ�� ��ȸ
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
	
	// 3. �μ���ȣ�� ��ȸ
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
	
	// 4. job_id�� ��ȸ
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
	
	// 5. �޿��� ��ȸ
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
	
	// 6. �Ի��Ϸ� ��ȸ
	public List<EmpVO> selectByDate(String sdate, String edate) {
		List<EmpVO> emplist = new ArrayList<>();
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		String sql = "select * from employees" +
					" where hire_date between ? and ?";
		
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, sdate);				// string -> date �ڵ�����ȯ
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
			st.setDate(1, sdate);				// string -> date �ڵ�����ȯ
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
	
	// 7. �̸��� Ư�����ڰ� �� ��� ��ȸ
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
	
	// 8. ���� �������� ��ȸ (�μ�, job, salary, hire_date)
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
													// 2�� ��
		
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
	
	public int insertEmp(EmpVO emp) {
		String sql = "insert into employees values(?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,?)";
		Connection conn;
		PreparedStatement st = null;
		int result = 0;
		
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, emp.getEmployee_id());
			st.setString(2, emp.getFirst_name());
			st.setString(3, emp.getLast_name());
			st.setString(4, emp.getEmail());
			st.setString(5, emp.getPhone_number());
			st.setDate(6, emp.getHire_date());
			st.setString(7, emp.getJob_id());
			st.setInt(8, emp.getSalary());
			st.setDouble(9, emp.getCommission_pct());
			if(emp.getManager_id() == 0) st.setNull(10, Types.INTEGER);
			else st.setInt(10, emp.getManager_id());
			st.setInt(11, emp.getDepartment_id());
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
	
	public int updateEmp(EmpVO emp) {
		String sql = "update employees "
				+ "set first_name=?, "
				+ "last_name=?, "
				+ "email=?, "
				+ "phone_number=?, "
				+ "hire_date=?, "
				+ "job_id=?, "
				+ "salary=?, "
				+ "commission_pct = ?, "
				+ "manager_id=?, "
				+ "department_id=? "
				+ "where employee_id = ?";
		Connection conn;
		PreparedStatement st = null;
		int result = 0;
		
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, emp.getFirst_name());
			st.setString(2, emp.getLast_name());
			st.setString(3, emp.getEmail());
			st.setString(4, emp.getPhone_number());
			st.setDate(5, emp.getHire_date());
			st.setString(6, emp.getJob_id());
			st.setInt(7, emp.getSalary());
			st.setDouble(8, emp.getCommission_pct());
			if(emp.getManager_id() == 0) st.setNull(9, Types.INTEGER);
			else st.setInt(9, emp.getManager_id());
			st.setInt(10, emp.getDepartment_id());
			st.setInt(11, emp.getEmployee_id());
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
	
	public int deleteEmp(int empid) {
		String sql = "delete from employees where employee_id = ?";
		Connection conn;
		PreparedStatement st = null;
		int result = 0;
		
		conn = DBUtil.getConnection();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, empid);
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
	

	private EmpVO makeEmp(ResultSet rs) throws SQLException {	//selectAll()�� ����ó�� ���־ ������
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(rs.getDouble("Commission_pct"));	// �÷��̸��� ��ҹ��ڱ���X
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
