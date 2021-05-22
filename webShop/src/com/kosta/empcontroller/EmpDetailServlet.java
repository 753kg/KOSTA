package com.kosta.empcontroller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.DeptDAO;
import com.kosta.model.EmpDAO;
import com.kosta.model.EmpVO;

/**
 * Servlet implementation class EmpDetailServlet
 */
@WebServlet("/emp/empDetail")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String obj = request.getParameter("empid");
		if(obj == null) throw new ServletException("empid가 없음");
		
		int empid = Integer.parseInt(obj);
		EmpDAO empdao = new EmpDAO();
		DeptDAO deptdao = new DeptDAO();
		request.setAttribute("emp", empdao.selectById(empid));
		request.setAttribute("joblist", empdao.selectAllJobs());
		request.setAttribute("deptlist", deptdao.selectAll());
		request.setAttribute("mlist", deptdao.selectAllManager());
		RequestDispatcher rd = request.getRequestDispatcher("emp_detail.jsp");
		rd.forward(request, response);
	}


}
