package com.kosta.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.DeptDAO;
import com.kosta.model.DeptVO;
import com.kosta.model.EmpDAO;
import com.kosta.model.LocationVO;

/**
 * Servlet implementation class DeptInsertServlet
 */
@WebServlet("/dept/deptInsert")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력하는 페이지 보여주기(페이지 연결)
		DeptDAO dao = new DeptDAO();
		//List<LocationVO> loclist = dao.selectAllLocation();
		//request.setAttribute("loclist", loclist);
		request.setAttribute("loclist", dao.selectAllLocation());
		request.setAttribute("mlist", dao.selectAllManager());
		RequestDispatcher rd = request.getRequestDispatcher("dept_insert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력된 부서를 DB에 입력
		request.setCharacterEncoding("utf-8");
		int deptid = convertInt(request.getParameter("department_id"));
		String dname = request.getParameter("department_name");
		int mid = convertInt(request.getParameter("manager_id"));
		int locid = convertInt(request.getParameter("location_id"));
		
		DeptVO dept = new DeptVO(deptid, dname, mid, locid);
		DeptDAO dao = new DeptDAO();
		int result = dao.insertDept(dept);
		System.out.println(result + "건 등록");
		//JSP에게 위임
		request.setAttribute("message", result + "건이 등록되었습니다.");
		RequestDispatcher rd = request.getRequestDispatcher("resultInfo.jsp");
		rd.forward(request, response);
		
		
	}
	
	private int convertInt(String str) {
		if(str == null || str.trim() == "") return 0;
		return Integer.parseInt(str);
	}

}
