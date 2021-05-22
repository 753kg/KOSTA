<%@page import="model.EmpVO"%>
<%@page import="model.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
String userid = request.getParameter("userid");	//웹에서 받은 값
int empid = Integer.parseInt(userid);	// id는 숫자로만 입력해야한다.
EmpDAO dao = new EmpDAO();
EmpVO emp = dao.selectById(empid);
String message = "존재하지않는 아이디입니다.";
if(emp != null){
		message = emp.getFirst_name()+" "+emp.getLast_name()+" 님 환영합니다!";
}

%>
<p><%=message %></p>
<p>당신의 이메일은 ${param.email}입니다.</p>
