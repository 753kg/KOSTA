<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${title }</h1>
	<h3>userid: ${id }</h3>
	<h3>userpass: ${userpass }</h3>
	<h3>email: ${email }</h3>
	<h3>email2: ${email2 }</h3>
	<h3>map: ${userinfo.userVO }</h3>
	<h3>VO(default): ${user }</h3>
	<h3>VO(request): ${requestScope.user }</h3>
	<h3>VO(session): ${sessionScope.user }</h3>
</body>
</html>