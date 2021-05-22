<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>1. 당신의 나이는 ${ param.age + 1 }</h1>
<%
String age = request.getParameter("age");
int iAge = Integer.parseInt(age) + 2;
%>
<h1>2. 당신의 나이는 <%= iAge %></h1>
</body>
</html>