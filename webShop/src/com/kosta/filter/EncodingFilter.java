package com.kosta.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/*")	//모든 요청일때 이 필터를 거쳐감
public class EncodingFilter implements Filter {

    public EncodingFilter() {
		System.out.println("EncodingFilter 생성자...");
    }
    
	public void destroy() {
		System.out.println("EncodingFilter destroy...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("utf-8");
		
		// pass the request along the filter chain
		System.out.println("EncodingFilter... 서블릿으로 가기 전!!");
		long start = System.currentTimeMillis();
		chain.doFilter(request, response);	// 요청,응답을 서블릿으로 전달
		long end = System.currentTimeMillis();
		System.out.println("EncodingFilter... 서블릿 수행 후!!");
		System.out.println("EncodingFilter... 수행시간:" + (end-start)+"ms");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("EncodingFilter init--------------------------");
		System.out.println(fConfig.getFilterName());
		System.out.println(fConfig.getServletContext().getRealPath(".")); //servletcontext의 실제위치
		System.out.println(fConfig.getServletContext().getContextPath()); //servletcontext의 위치???
	}

}
