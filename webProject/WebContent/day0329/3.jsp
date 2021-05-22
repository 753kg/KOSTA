<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP = JAVA + HTML</h1>
<%
	// 자바 문법
	String name = "김채연";
%>
<h2>작성자는 <%= name%></h2>
<h3>JSP는 Server에서 해석된다.</h3>
</body>
</html>