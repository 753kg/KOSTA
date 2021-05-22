package com.kosta.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParameterServlet2
 */
//web.xml 파일에 매핑했음 "/param3","/param4"
//어노테이션방식, xml에 쓰는방식 둘다 하면
//xml호출후 어노테이션방식 호출하면 생성자가 다시 호출된다.
//@WebServlet("/InitParameterServlet2")
public class InitParameterServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InitParameterServlet2() {
		System.out.println("InitParameterServlet2 생성자!!");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2222");
		System.out.println(getInitParameter("email"));
		System.out.println(getInitParameter("phone"));
	}

}
