// 서블릿 생명주기
// 최초요청시 생성자, 초기화는 1번만하고 이후로는 doGet요청만 들어옴
// 주소창은 get요청만 된다.
package com.kosta.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet({"/first3", "/first4"})	//주소창에 뭐라고 요청할건지. 요청 이름. /꼭 붙여야함
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        //super();
    	System.out.println("FirstServlet 생성자");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet init 초기화");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("FirstServlet destroy 소멸");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doGet 요청");
		response.getWriter().append("GET...Served at: ").append(request.getContextPath());	//컨텍스트 이름?
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doPost 요청");
		//doGet(request, response);
		response.getWriter().append("POST...Served at: ").append(request.getContextPath());
	}

}
