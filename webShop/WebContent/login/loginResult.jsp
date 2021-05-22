<%@page import="com.kosta.model.EmpVO"%>
<%@page import="java.util.List"%>
<%@page import="com.kosta.listener.LoginImpl"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 결과 출력</h1>
	<p>${param.userid }</p>
	<p>${param.userpw }</p>
	<p>${username }</p>
	<p>${param.address }</p>
	<p>${param.phone }</p>
	<h2>${empInfo }</h2>
	<p>userinfo: ${userinfo }</p>
	<p>total_user : <%=LoginImpl.getTotal_user() %></p><!-- LoginImpl Class의 static field -->
	<h2>현재 접속자</h2>
	<%
	List<EmpVO> ulist = (List<EmpVO>)application.getAttribute("user_list");
	if(ulist == null) return;
	for(EmpVO emp:ulist){
		out.print(emp + "<br>");
	}
	%>
</body>
</html>

<!-- 
form으로 받은건 param 객체로 넘어와서  param. 붙이고 
setAttribute로 직접준건 param 안붙여도 됨

getAttribute("username") ==> EL? ==> ${username}
 -->