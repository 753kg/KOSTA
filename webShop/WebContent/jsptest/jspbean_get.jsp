<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test2.jsp 입니다.</h1>
	<jsp:useBean id="dept2" class="com.kosta.model.DeptVO" scope="request"/>
	id:<jsp:getProperty property="department_id" name="dept2"/><br>
	name:<jsp:getProperty property="department_name" name="dept2"/><br>
	location:<jsp:getProperty property="location_id" name="dept2"/><br>
	manager:<jsp:getProperty property="manager_id" name="dept2"/><br>
</body>
</html>