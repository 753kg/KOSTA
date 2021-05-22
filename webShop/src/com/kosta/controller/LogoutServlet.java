package com.kosta.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.model.EmpVO;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/login/logout.kosta")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	// 있으면 얻고 없으면 만든다.
		ServletContext app = getServletContext();
		List<EmpVO> user_list = (List<EmpVO>)app.getAttribute("user_list");
		if(user_list != null) {
			EmpVO emp = (EmpVO)session.getAttribute("emp");
			user_list.remove(emp);
		}
		app.setAttribute("user_list", user_list);	// 로그아웃한 유저를 현재접속중인 유저리스트에서 삭제하고 app영역에 업데이트
		session.invalidate();	// 세션 모두 지우기
		response.sendRedirect("loginChk.kosta");	// 로그인폼 보여주기
	}
}
