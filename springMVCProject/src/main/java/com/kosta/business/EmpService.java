package com.kosta.business;

import java.sql.Date;
import java.util.List;

import com.kosta.model.EmpVO;
import com.kosta.model.JobVO;

public interface EmpService {
	public EmpVO loginChk(int empid, String email);
	public List<EmpVO> selectAll();
	public List<JobVO> selectAllJobs();
	public EmpVO selectById(int empid);
	public List<EmpVO> selectByDept(int deptid);
	public List<EmpVO> selectByJob(String jobid);
	public List<EmpVO> selectBySalary(int minsal, int maxsal);
	public List<EmpVO> selectByDate(String sdate, String edate);
	public List<EmpVO> selectByDate2(Date sdate, Date edate);
	public List<EmpVO> selectByName(String str) ;
	public List<EmpVO> selectByCondition(int deptid, String jobid, int sal, Date hdate);
	public int insertEmp(EmpVO emp) ;
	public int updateEmp(EmpVO emp);
	public int deleteEmp(int empid);
}
