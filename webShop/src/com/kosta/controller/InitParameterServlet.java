package com.kosta.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParameterServlet
 */
// 초기값은 이 서블릿 내에서만 사용가능???
@WebServlet(
		urlPatterns = { 
				"/InitParameterServlet", 
				"/param1", 
				"/param2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "test@naver.com"), 
				@WebInitParam(name = "phone", value = "010-1233-4566")
		},
		loadOnStartup = 1	// 서버시작되면 처음으로 실행됨
		)
public class InitParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public InitParameterServlet() {
		System.out.println("InitParameterServlet 생성자...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(getInitParameter("email"));
		System.out.println(getInitParameter("phone"));
	}

}
