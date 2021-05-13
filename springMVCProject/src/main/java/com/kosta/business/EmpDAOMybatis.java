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

@Repository()
public class EmpDAOMybatis implements EmpDAOInterface{
	
	@Autowired
	SqlSession sqlsession;
	
	String namespace = "com.kosta.emp.";

	@Override
	public EmpVO loginChk(int empid, String email) {
		Map<String, Object> empInfo = new HashMap<>();
		empInfo.put("employee_id", empid);
		empInfo.put("email", email);
		EmpVO emp = sqlsession.selectOne(namespace + "loginChk", empInfo);
		return emp;
	}

	@Override
	public List<EmpVO> selectAll() {
		List<EmpVO> emplist = sqlsession.selectList(namespace + "selectAll");
		System.out.println("EmpDAOMybatis...");
		System.out.println(emplist.size() + " 건");
		return emplist;
	}

	@Override
	public List<JobVO> selectAllJobs() {
		List<JobVO> joblist = sqlsession.selectList(namespace + "selectAllJobs");
		System.out.println(joblist.size() + " 건의 job");
		return joblist;
	}

	@Override
	public EmpVO selectById(int empid) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + "selectById", empid);
	}

	@Override
	public List<EmpVO> selectByDept(int deptid) {
		List<EmpVO> emplist = sqlsession.selectList(namespace + "selectByDept", deptid);
		System.out.println("selectByDept >> " + emplist.size() + "건");
		return emplist;
	}

	@Override
	public List<EmpVO> selectByJob(String jobid) {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace + "selectByJob", jobid);
	}

	@Override
	public List<EmpVO> selectBySalary(int minsal, int maxsal) {
		Map<String, Integer> map = new HashMap<>();
		map.put("minsal", minsal);
		map.put("maxsal", maxsal);
		List<EmpVO> emplist = sqlsession.selectList(namespace + "selectBySalary", map);
		System.out.println("selectBySalary >> " + emplist.size() + "건");
		return emplist;
	}

	@Override
	public List<EmpVO> selectByDate(String sdate, String edate) {
		Map<String, String> map = new HashMap<>();
		map.put("sdate", sdate);
		map.put("edate", edate);
		List<EmpVO> emplist = sqlsession.selectList(namespace + "selectByDate", map);
		System.out.println("selectByDate >> " + emplist.size() + "건");
		return emplist;
	}

	@Override
	public List<EmpVO> selectByDate2(Date sdate, Date edate) {
		Map<String, Date> map = new HashMap<>();
		map.put("sdate", sdate);
		map.put("edate", edate);
		List<EmpVO> emplist = sqlsession.selectList(namespace + "selectByDate2", map);
		System.out.println("selectByDate2 >> " + emplist.size() + "건");
		return emplist;
	}

	@Override
	public List<EmpVO> selectByName(String str) {
		List<EmpVO> emplist = sqlsession.selectList(namespace + "selectByName", "%"+str+"%");
		System.out.println("selectByName >> " + emplist.size() + "건");
		return emplist;
	}
	
	// 동적 SQL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
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
		int result = sqlsession.insert(namespace + "empInsert", emp);
		System.out.println(result + "건 입력됨..");
		return result;
	}

	@Override
	public int updateEmp(EmpVO emp) {
		int result = sqlsession.update(namespace + "empUpdate", emp);
		System.out.println(result + "건 수정됨..");
		return result;
	}

	@Override
	public int deleteEmp(int empid) {
		int result = sqlsession.delete(namespace + "empDelete", empid);
		System.out.println(result + "건 삭제됨..");
		return result;
	}

	@Override
	public List<EmpVO> selectByDeptMany(List<Integer> deptidlist) {
		List<EmpVO> emplist = sqlsession.selectList(namespace + "selectByDeptMany", deptidlist);
		System.out.println("selectByDeptMany >> " + emplist.size() + "건");
		return emplist;
	}

}
