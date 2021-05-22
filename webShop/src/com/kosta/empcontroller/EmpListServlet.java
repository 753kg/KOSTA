package com.kosta.empcontroller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.model.EmpDAO;
import com.kosta.model.EmpVO;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/emp/emplist")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청 URL에 대한 정보를 취득
		String cp = request.getContextPath();
		System.out.println("application이름 : " + cp);
		System.out.println("IP: " + request.getLocalAddr());
		System.out.println("port: " + request.getLocalPort());
		System.out.println("URI: " + request.getRequestURI());
		System.out.println("URL: " + request.getRequestURL());
		
		EmpDAO dao = new EmpDAO();
		request.setAttribute("emplist", dao.selectAll());
		
		// 서블릿이 요청을 받아서 JSP에게 위임
		// 1. request영역에 데이터 저장
		request.setAttribute("myname", "chaeyeon");
		request.setAttribute("myscore", 100);
		EmpVO myemp = new EmpVO();
		myemp.setFirst_name("직원이름");
		myemp.setSalary(500);
		request.setAttribute("myemp", myemp);
		// 2. servlet context : application당 하나
		// 서버가 꺼질때까지 데이터가 살아있음
		// 아무데서나 사용 가능. 전달할 필요가 없다.
		ServletContext app = getServletContext();
		// ServletContext app2 = getServletContext();	//싱글톤
		app.setAttribute("appInfo", "우리사이트에 오신것을 환영합니다.");
		
		// 1.쿠키얻기
		Cookie[] cs = request.getCookies();
		for(Cookie c:cs) {
			String name = c.getName();		//key
			String value = c.getValue();	//value
			if(name.equals("username")) {
				request.setAttribute("username", URLDecoder.decode(value, "utf-8"));
			}
			System.out.println(name + ":" + value);
			System.out.println("========================");
		} 
		
		/* 2. 세션 이용 */
		// 로그인 안하면 emplist를 볼 수 없음. 자동으로 로그인창으로 간다.
		// 로그인하고 가면 보임
		// setMaxInactiveInterval(60) ==> 1분지나면 session 없어져서 새로고침하면 다시 로그인창으로 감
		HttpSession session = request.getSession();	//있으면 얻고, 없으면 만들기
		// 새로 만들면 obj엔 아무것도 없게됨
		Object obj = session.getAttribute("empid");
		if(obj == null) {
			response.sendRedirect("../login/loginChk.kosta");
			return;	//밑 코드 실행 못하게
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("emplist.jsp");
		rd.forward(request, response);
		
		//System.out.println("info:" + request.getAttribute("info"));
		//System.out.println("dbname:" + app.getInitParameter("dbname"));
		//System.out.println("userid:" + app.getInitParameter("userid"));
		
	}
}
