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

/**
 * model2(mvc2) => 유지보수를 좋게 하려고
 * Servlet 	= JAVA + HTML(X)
 * JSP 		= HTML + JAVA(X)
 * 
 * 주소창엔 deptlist로 보이지만 내용은 dept_retrieve.jsp의 내용이다.
 */
@WebServlet("/dept/deptlist")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("deptlist요청...servlet");
		// 자바코드는 servlet에. jsp에는 안하는게좋다.
		// 여기에는 자바만 쓰기. html은 쓰지말자
		// 서블릿은 코드 짧게 쓴다.
		DeptDAO dao = new DeptDAO();
		List<DeptVO> dlist = dao.selectAll();
		request.setAttribute("deptAll", dlist);	//dlist를 요청에다 deptAll로 저장
		RequestDispatcher rd = request.getRequestDispatcher("dept_retrieve.jsp"); // jsp와 연결. servlet이 받은 요청을 jsp에 넘김(위임)
		rd.forward(request, response);
	}

}
