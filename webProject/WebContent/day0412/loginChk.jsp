<%@page import="model.EmpVO"%>
<%@page import="model.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
String userid = request.getParameter("userid");	//������ ���� ��
int empid = Integer.parseInt(userid);	// id�� ���ڷθ� �Է��ؾ��Ѵ�.
EmpDAO dao = new EmpDAO();
EmpVO emp = dao.selectById(empid);
String message = "���������ʴ� ���̵��Դϴ�.";
if(emp != null){
		message = emp.getFirst_name()+" "+emp.getLast_name()+" �� ȯ���մϴ�!";
}

%>
<p><%=message %></p>
<p>����� �̸����� ${param.email}�Դϴ�.</p>
