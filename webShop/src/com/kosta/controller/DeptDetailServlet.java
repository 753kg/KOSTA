package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.DeptDAO;
import com.kosta.model.DeptVO;

/**
 * Servlet implementation class DeptDetailServlet
 */
@WebServlet("/dept/deptDetail")
public class DeptDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 목적: 조회(상세보기)
		String s_deptid = request.getParameter("deptid");
		int i_deptid = Integer.parseInt(s_deptid);
		DeptDAO dao = new DeptDAO();
		DeptVO dept = dao.selectById(i_deptid);
		request.setAttribute("dept", dept);
		request.setAttribute("myname", "kcy");
		//JSP에게 위임
		RequestDispatcher rd = request.getRequestDispatcher("dept_detail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 목적: 수정
		request.setCharacterEncoding("utf-8");
		int deptid = convertInt(request.getParameter("department_id"));
		String dname = request.getParameter("department_name");
		int mid = convertInt(request.getParameter("manager_id"));
		int locid = convertInt(request.getParameter("location_id"));
		
		DeptVO dept = new DeptVO(deptid, dname, mid, locid);
		DeptDAO dao = new DeptDAO();
		int result = dao.updateDept(dept);	//업데이트된건수가return됨
		System.out.println(result + "건 수정");
		//JSP에게 위임
		request.setAttribute("message", result + "건이 수정되었습니다.");
		RequestDispatcher rd = request.getRequestDispatcher("resultInfo.jsp");
		rd.forward(request, response);
		
		
	}
	
	private int convertInt(String str) {
		if(str == null) return 0;
		return Integer.parseInt(str);
	}

}
