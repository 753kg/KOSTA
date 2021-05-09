<%@page import="com.kosta.model.DeptVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td { border:1px solid black; border-collapse: collapse; }
	td { padding:5px; }
	tr:first-of-type { background-color: lightgray; }
</style>

</head>
<body>
	<h1>부서전체목록</h1>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<a href="deptInsert">신규등록</a><!-- 무조건 servlet으로 이동(controller로) -->
	<table>
		<tr>
			<td>부서코드</td><td>부서이름</td><td>매니저</td><td>지역코드</td><td></td>
		</tr>
		<c:forEach var="dept" items="${deptAll }">
			<tr>
				<td><a href="deptDetail?deptid=${dept.department_id}">${dept.department_id}</a></td>
				<td>${dept.department_name}</td>
				<td>${dept.manager_id}</td>
				<td>${dept.location_id}</td>
				<td><button onclick="location.href='deptDelete?deptid=${dept.department_id}'">삭제</button></td>
			</tr>		
		</c:forEach>
	</table>
</body>
</html>