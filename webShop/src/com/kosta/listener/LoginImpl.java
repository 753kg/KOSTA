package com.kosta.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */
@WebListener
public class LoginImpl implements HttpSessionBindingListener {
	
	// 변수 선언
	private int user_id;		// employee_id
	private String user_pw;		// email
	private static int total_user = 0;
	
    public LoginImpl() {
        // Default Constructor
    }

	public LoginImpl(int user_id, String user_pw) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public static int getTotal_user() {
		return total_user;
	}

	public static void setTotal_user(int total_user) {
		LoginImpl.total_user = total_user;
	}

	@Override
	public String toString() {
		return "LoginImpl [user_id=" + user_id + ", user_pw=" + user_pw + "]";
	}

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent event)  { 
        // 접속자 수 증가
    	// 접속하면 valueBound 지나감??
    	total_user++;
    	System.out.println("접속함...현재 접속자수: " + total_user);
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent event)  { 
        // 접속자 수 빼기
    	// 접속 해제될 때
    	total_user--;
    	System.out.println("접속해제...현재접속자수: " + total_user);
    }
	
}
