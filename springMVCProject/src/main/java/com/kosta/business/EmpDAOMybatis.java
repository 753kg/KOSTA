package com.kosta.business;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.model.EmpVO;
import com.kosta.model.JobVO;

@Repository("empDAO_mybatis")
public class EmpDAOMybatis implements EmpDAOInterface{
	
	@Autowired
	SqlSession sqlsession;
	
	String namespace = "com.kosta.emp.";

	@Override
	public EmpVO loginChk(int empid, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpVO> selectAll() {
		System.out.println("EmpDAOMybatis...");
		return sqlsession.selectList(namespace + "selectAll");
	}

	@Override
	public List<JobVO> selectAllJobs() {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace + "selectAllJobs");
	}

	@Override
	public EmpVO selectById(int empid) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + "selectById", empid);
	}

	@Override
	public List<EmpVO> selectByDept(int deptid) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + "selectByDept", deptid);
	}

	@Override
	public List<EmpVO> selectByJob(String jobid) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + "selectByJob", jobid);
	}

	@Override
	public List<EmpVO> selectBySalary(int minsal, int maxsal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpVO> selectByDate(String sdate, String edate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpVO> selectByDate2(Date sdate, Date edate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpVO> selectByName(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpVO> selectByCondition(int deptid, String jobid, int sal, Date hdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertEmp(EmpVO emp) {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace + "insertEmp", emp);
	}

	@Override
	public int updateEmp(EmpVO emp) {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + "updateEmp", emp);
	}

	@Override
	public int deleteEmp(int empid) {
		// TODO Auto-generated method stub
		return sqlsession.delete(namespace + "deleteEmp", empid);
	}

}
