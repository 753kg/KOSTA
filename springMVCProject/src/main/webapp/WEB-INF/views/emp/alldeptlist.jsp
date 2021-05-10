<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서 목록</h1>
	<ol>
		<c:forEach var="dept" items="${dlist }">
			<li><a href="empByDept.do?deptid=${dept.department_id }">${dept.department_name }</a></li>
		</c:forEach>
	</ol>
</body>
</html>