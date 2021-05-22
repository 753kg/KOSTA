package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/memberInsert")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	// 없어도되지만 경고가뜸
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get방식은 자동 인코딩됨
		/* name을 알고있을 때
		String name = request.getParameter("name");	//<input>의 name
		String phone = request.getParameter("phonenumber");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String[] subject = request.getParameterValues("subject");
		
		System.out.println(name);
		System.out.println(phone);
		System.out.println(id);
		System.out.println(passwd);
		System.out.println(Arrays.toString(subject));
		*/
		
		// 브라우저에 응답을 내려보내기
		response.setContentType("text/html;charset=utf-8");	//utf-8형식의 html을 내려보낸다.
		PrintWriter out = response.getWriter();
		
		// 파라미터 값이 많은 경우 유용함
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()) {	//names에 element가 있는지
			String paramName = names.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			for(String val:paramValues) {
				out.println("<h3>" + paramName + "==> " + val + "</h3>");
			}
		}
		
		
	}

}
