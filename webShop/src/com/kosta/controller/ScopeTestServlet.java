package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScopeTestServlet
 */
@WebServlet("/ScopeTestServlet")
public class ScopeTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Scope : 값이 어느 기간동안 유지되는지
		// context, session, request
		// 1. context (application 영역) : 아무데서나 다 사용 가능
		ServletContext app = getServletContext();
		// 2. session : 브라우저 정보
		HttpSession session = request.getSession();
		// 3. request : 요청
		
		app.setAttribute("scopeMessage1", "ServletContext Message");
		session.setAttribute("scopeMessage2", "Session Message");
		request.setAttribute("scopeMessage3", "request Message");
		
		// key가 다 같으면 범위가 더 좁은 request를 사용
		// request < session < application
		app.setAttribute("myname", "app길동");
		session.setAttribute("myname", "session길동");
		request.setAttribute("myname", "request길동");
		
		RequestDispatcher rd = request.getRequestDispatcher("scopetest.jsp");	//페이지 연결
		rd.forward(request, response);
	}

}
