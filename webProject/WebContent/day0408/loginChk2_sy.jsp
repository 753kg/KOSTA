<%@page import="model.EmpVO"%>
<%@page import="model.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String userid= request.getParameter("userid");
int empid= Integer.parseInt(userid);
EmpDAO dao= new EmpDAO();
EmpVO emp= dao.selectById(empid);
String message="아이디에 해당하는 직원이 존재하지 않음";
if(emp!=null){
   message= emp.getFirst_name()+emp.getLast_name()+" 환영~~";
}
%>

{
"fname":"<%=emp.getFirst_name() %>",
"lname":"<%=emp.getLast_name() %>",
"salary":<%=emp.getSalary() %>,
"hiredate":"<%=emp.getHire_date() %>"
}