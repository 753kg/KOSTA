<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
//post 방식일 땐 body 부분에 전달된 parameter를 encode한다.
request.setCharacterEncoding("utf-8");
%>


</head>
<body>
<h1>사용자가 입력한 테이터를 서버에서 받는다.</h1>
<!-- EL(Expression Language) 표기법 -->
<p>아이디 : ${ param.userid }</p>
</body>
</html>