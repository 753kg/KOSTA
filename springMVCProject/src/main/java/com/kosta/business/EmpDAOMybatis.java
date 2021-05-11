package com.kosta.business;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map<String, Object> map = new HashMap<>();
		map.put("employee_id", empid);
		map.put("email", email);
		return sqlsession.selectOne(namespace + "loginChk", map);
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
		Map<String, Object> map = new HashMap<>();
		map.put("minsal", minsal);
		map.put("maxsal", maxsal);
		return sqlsession.selectList(namespace + "selectBySalary", map);
	}

	@Override
	public List<EmpVO> selectByDate(String sdate, String edate) {
		Map<String, Object> map = new HashMap<>();
		map.put("sdate", sdate);
		map.put("edate", edate);
		return sqlsession.selectList(namespace + "selectByDate", map);
	}

	@Override
	public List<EmpVO> selectByDate2(Date sdate, Date edate) {
		Map<String, Object> map = new HashMap<>();
		map.put("sdate", sdate);
		map.put("edate", edate);
		return sqlsession.selectList(namespace + "selectByDate2", map);
	}

	@Override
	public List<EmpVO> selectByName(String str) {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace + "selectByName", str);
	}

	@Override
	public List<EmpVO> selectByCondition(int deptid, String jobid, int sal, Date hdate) {
		Map<String, Object> map = new HashMap<>();
		map.put("department_id", deptid);
		map.put("job_id", jobid);
		map.put("salary", sal);
		map.put("hire_date", hdate);
		return sqlsession.selectList(namespace + "selectByCondition", map);
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
