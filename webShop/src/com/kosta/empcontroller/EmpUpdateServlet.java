package com.kosta.empcontroller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.EmpDAO;
import com.kosta.model.EmpVO;
import com.kosta.util.ConvertUtil;

/**
 * Servlet implementation class EmpUpdateServlet
 */
@WebServlet("/emp/empUpdate")
public class EmpUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		
		EmpVO emp = new EmpVO();
		emp.setEmployee_id(ConvertUtil.convertInt(request.getParameter("employee_id")));
		emp.setFirst_name(request.getParameter("first_name"));
		emp.setLast_name(request.getParameter("last_name"));
		emp.setEmail(request.getParameter("email"));
		emp.setPhone_number(request.getParameter("phone_number"));
		emp.setHire_date(ConvertUtil.convertDate(request.getParameter("hire_date")));
		emp.setJob_id(request.getParameter("job_id"));
		emp.setSalary(ConvertUtil.convertInt(request.getParameter("salary")));
		emp.setCommission_pct(ConvertUtil.convertDouble(request.getParameter("commission_pct")));
		emp.setManager_id(ConvertUtil.convertInt(request.getParameter("manager_id")));
		emp.setDepartment_id(ConvertUtil.convertInt(request.getParameter("department_id")));
		
		EmpDAO dao = new EmpDAO();
		int result = dao.updateEmp(emp);
		String message = result>0?"수정성공":"수정실패";
		request.setAttribute("message", message);
		
		// 응답문서의 header 정보 변경하기
		// response.setHeader("refresh", "3;url=emplist");
		
		// 위임은 주소창 안바뀜
		//RequestDispatcher rd = request.getRequestDispatcher("emp_result.jsp");
		//rd.forward(request, response);
		
		// 주소창이 변경된다. (요청 재지정)
		// result는 못보고 바로 list로 감
		request.setAttribute("info", "요청재지정시 request는 전달안됨");
		response.sendRedirect("emplist");
		
		// request(공유자원영역)에 데이터를 저장해놓음
		// request.setAttribute
	}
	

}
