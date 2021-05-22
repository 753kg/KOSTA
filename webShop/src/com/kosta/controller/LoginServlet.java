package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.listener.LoginImpl;
import com.kosta.model.EmpDAO;
import com.kosta.model.EmpVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login/loginChk.kosta")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int total_user;
	List<EmpVO> user_list = new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("loginForm.html");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost.....");
		
		// 요청
		//읽을 때 post방식은 한글 자동으로 인코딩 안돼서 깨져보임. get은 자동인코딩됨
		request.setCharacterEncoding("utf-8");
		
		// 유저의 요청은 다 request에 들어옴
		int empid = Integer.parseInt(request.getParameter("userid"));
		String email = request.getParameter("userpw");
		
		EmpDAO dao = new EmpDAO();
		EmpVO emp = dao.loginChk(empid, email);
		//request.setAttribute("empInfo", emp);
		//request.setAttribute("username", emp.getFirst_name()+" "+emp.getLast_name());
		
		/* 1. 쿠키이용 (서버에서 만들고 pc로 내려보냄)
		Cookie c1 = new Cookie("empid", empid+"");	//문자만 가능
		Cookie c2 = new Cookie("email", email);
		Cookie c3 = new Cookie("username", URLEncoder.encode(emp.getFirst_name(), "utf-8"));	// 한글 인코딩
		c1.setMaxAge(60*1);	//쿠키가 유지되는 시간. 1분
		c2.setMaxAge(60*5);	// 5분
		c3.setMaxAge(60*60*24);	//하루 24시간
		String path = getServletContext().getContextPath();
		c1.setPath(path);	// "/webShop" ==> 쿠키를 webShop 내에서만 쓸수있도록
		c2.setPath(path);
		c3.setPath(path);
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
		*/
		
		/* 2. Session 이용 (더 많이 사용됨 )
		 * -> why? 보안. 사이즈제한X, 브라우저에서 쿠키차단과 무관 
		 *-> Session은 쿠키 기술을 이용. 
		 *-> 자동으로 sessionID가 쿠키로 만들어져서 Browser에 저장됨 
		 *-> 정보는 서버 메모리에 저장됨. */
		HttpSession session = request.getSession();	//있으면 얻고, 없으면 만들기
		System.out.println(session.isNew());	// 새로 만든건지 확인해보기
		session.setAttribute("empid", empid);	// 숫자도 들어감
		session.setAttribute("email", email);
		session.setAttribute("empInfo", emp);
		session.setAttribute("emp", emp);
		session.setAttribute("username", emp.getFirst_name()+" "+emp.getLast_name());
		//session.setMaxInactiveInterval(60);		// 60초만 유지하기 default는 30분
		
		// 리스너 이용해서 접속자수 감시
		LoginImpl login = new LoginImpl(empid, email);
		if(session.isNew()) {	// true이면. 처음접속하면
			session.setAttribute("userinfo", login);	// 객체저장
			user_list.add(emp);
			ServletContext app = getServletContext();
			app.setAttribute("user_list", user_list);	// 하나의 서버에서 여러 세션들 관리
		}
		// 5초 후에 리프레시
		String s = 
				"<script>" +
				"	setTimeout('history.go(0);',5000)" +
				"</script>";
		request.setAttribute("js", s);	//자바스크립트 저장
		
		// request에 userid, userpw가 들어있어서 jsp에서 바로 쓸 수 있다.
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("loginResult.jsp");
		rd.forward(request, response);
		
		
		/*
		// 콘솔로 값 확인
		System.out.println("uid= " + uid);
		System.out.println("upw= " + upw);
		// document(web화면)에 찍기
		// 응답 한글 안깨지려면 인코딩타입을 줘야한다. getWriter하기 전에
		response.setContentType("text/html;charset=utf-8");	
		PrintWriter out = response.getWriter();
		out.append(String.format("<h1>아이디: %s</h1>", uid));
		out.append(String.format("<h1>비밀번호: %s</h1>", upw));
		*/
	}

}
