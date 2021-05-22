package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import model.EmpDAO;
import model.EmpVO;
import view.EmpView;

public class EmpController {

	public static void main(String[] args) {
		
		//삭제
		//method12();
		
		// 수정
//		method11();
		
		// 입력 test
//		method10();
		
		// 1. 모든직원조회
		 method1();
		// 2. 기본키로 조회
		// method2(101);
		// 3. 부서번호로 조회
		// method3(60);
		// 4. job_id로 조회
		// method4("IT_PROG");
		// 5. 급여로 조회
		// method5(10000, 15000);
		// 6. 입사일로 조회- String, Date
		// method6("2004/01/01", "2004/12/31");
		// method7("2004-01-01", "2004-12-31");
		// 7. 이름에 특정문자가 들어간 사람 조회
		// method8("ex");
		// 8. 여러 조건으로 조회 (부서, job, salary, hire_date)
		// method9(60, "IT_PROG", 1000, "2005-01-01");
	}

	
	private static void method12() {
		EmpDAO dao = new EmpDAO();
		int result = dao.deleteEmp(9);
		EmpView.display(result>0?"삭제성공":"삭제실패");
	}


	private static void method11() {
		EmpDAO dao = new EmpDAO();
		EmpVO emp = makeEmp();
		int result = dao.updateEmp(emp);
		EmpView.display(result>0?"수정성공":"수정실패");
	}


	private static EmpVO makeEmp() {
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(0.7);
		emp.setDepartment_id(10);
		emp.setEmail("email수정");
		emp.setEmployee_id(135);
		emp.setFirst_name("채연_수정");
		emp.setHire_date(new Date(new java.util.Date().getTime()));
		emp.setJob_id("IT_PROG");
		emp.setLast_name("김_수정");
		emp.setManager_id(100);
		emp.setPhone_number("010-8877-6666");
		emp.setSalary(2000);
		return emp;
	}

	private static void method10() {
		EmpDAO dao = new EmpDAO();
		EmpVO emp = makeEmp();
		
		int reusult = dao.insertEmp(emp);
		EmpView.display(reusult>0?"입력성공":"입력실패");
	}




	private static void method9(int dept, String job, int sal, String dt) {
		EmpDAO dao = new EmpDAO();
		List<EmpVO> emplist = dao.selectByCondition(dept, job, sal, Date.valueOf(dt));
		EmpView.display(emplist);
	}

	private static void method8(String str) {
		EmpDAO dao = new EmpDAO();
		List<EmpVO> emplist = dao.selectByName(str);
		EmpView.display(emplist);
	}
	
	private static void method7(String sdate, String edate) {
		EmpDAO dao = new EmpDAO();
		Date d1 = Date.valueOf(sdate);	// String -> java.sql.Date
		Date d2 = Date.valueOf(edate);
//		Date d1 = new Date(Integer.parseInt(sdate.substring(0, 4))-1900, 0, 1);
//		Date d2 = new Date(Integer.parseInt(edate.substring(0, 4))-1900, 11, 31);
		List<EmpVO> emplist = dao.selectByDate2(d1, d2);
		EmpView.display(emplist);
	}
	
	private static void method6(String sdate, String edate) {
		EmpDAO dao = new EmpDAO();
		List<EmpVO> emplist = dao.selectByDate(sdate, edate);
		EmpView.display(emplist);
	}

	private static void method5(int minsal, int maxsal) {
		EmpDAO dao = new EmpDAO();
		List<EmpVO> emplist = dao.selectBySalary(minsal, maxsal);
		EmpView.display(emplist);
	}

	private static void method4(String jobid) {
		EmpDAO dao = new EmpDAO();
		List<EmpVO> emplist = dao.selectByJob(jobid);
		EmpView.display(emplist);
	}

	private static void method3(int deptid) {
		EmpDAO dao = new EmpDAO();
		List<EmpVO> emplist = dao.selectByDept(deptid);
		EmpView.display(emplist);
	}

	private static void method2(int empid) {
		EmpDAO dao = new EmpDAO();
		EmpVO emp = dao.selectById(empid);
		EmpView.display(emp);
	}

	private static void method1() {
		EmpDAO dao = new EmpDAO();
		List<EmpVO> emplist = dao.selectAll();
		EmpView.display(emplist);
	}

}
