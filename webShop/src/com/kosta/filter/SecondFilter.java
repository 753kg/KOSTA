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
 * Servlet Filter implementation class SecondFilter
 */
@WebFilter("*.kosta")	// .kosta일 때만 이 필터를 거쳐감
public class SecondFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecondFilter() {
        System.out.println("SecondFilter 생성자");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
        System.out.println("SecondFilter destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("SecondFilter... 실제 요청가기 전에 수행");

		// pass the request along the filter chain
		chain.doFilter(request, response);	// 요청
		System.out.println("SecondFilter... 실제 요청 후에 수행");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("SecondFilter init--------------------------");
		System.out.println(fConfig.getFilterName());
		System.out.println(fConfig.getServletContext().getRealPath(".")); //servletcontext의 실제위치
		System.out.println(fConfig.getServletContext().getContextPath()); //servletcontext의 위치???
	}

}
