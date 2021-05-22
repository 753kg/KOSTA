package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class URLPatternTestServlet
 */
//@WebServlet("/*")		//Front Controller
//@WebServlet("/sample/*") // sample 폴더 이름만 일치하면 여기로 옴
@WebServlet("*.do") // .do로 끝나면 여기로
public class URLPatternTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// service : get일때도 오고 post일때도 온다.
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ContextPath(application): " + request.getContextPath());	/* /webShop */
		System.out.println("URI: " + request.getRequestURI());	/* /webShop/sample/aa/bb */
		System.out.println("URL: " + request.getRequestURL());	/* http://localhost:9090/webShop/sample/aa/bb */
		System.out.println("Method: " + request.getMethod());	/* GET */
		System.out.println("ServletPath(this servlet): " + request.getServletPath());	/* /sample */
		
		int pos = request.getContextPath().length();
		String uri = request.getRequestURI().substring(pos);
		System.out.println(uri);
		// 요청한 경로? 찾기
		String page = "default.jsp";
		if (uri.equals("/sample/aa.do")) {
			page = "../sample2/test1.jsp";
		} else if (uri.equals("/sample/bb.do")) {
			page = "../sample2/test2.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		 
	}

}
