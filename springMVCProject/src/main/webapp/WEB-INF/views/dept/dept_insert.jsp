<%@page import="com.kosta.model.ManagerVO"%>
<%@page import="com.kosta.model.LocationVO"%>
<%@page import="java.util.List"%>
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
	<h1>부서 신규 등록</h1>
	<form action="deptInsert.do" method="post">
		부서번호:<input type="number" name="department_id"><br>
		부서이름:<input type="text" name="department_name"><br>
		매니저:
		<select name="manager_id">
			<c:forEach var="m" items="${mlist }">
				<option value="${m.manager_id }">${m.fullname}</option>
			</c:forEach>
		</select><br>
		Location:
		<select name="location_id">
			<c:forEach var="loc" items="${loclist }">
				<option value="${loc.location_id }">${loc.city}</option>
			</c:forEach>
		</select><br>
		<input type="submit" value="등록하기">
	</form>
</body>
</html>