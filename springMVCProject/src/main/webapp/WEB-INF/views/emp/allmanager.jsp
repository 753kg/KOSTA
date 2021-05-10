<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>매니저 목록</h1>
	<ol>
		<c:forEach var="m" items="${mlist }">
			<li><a href="empDetail.do?empid=${m.manager_id }">${m.manager_id }</a> :: ${m.fullname }</li>
		</c:forEach>
	</ol>
</body>
</html>