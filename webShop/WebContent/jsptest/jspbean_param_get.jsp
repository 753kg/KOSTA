<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test4.jsp</h1>
	
	<!-- 객체를 만들고  -->
	<jsp:useBean id="dept" class="com.kosta.model.DeptVO" scope="request"/>
	
	<!-- 파라미터로 전달된 값을 객체에 넣어주기 -->
	<%-- <jsp:setProperty property="department_id" name="dept" param="department_id" />
	<jsp:setProperty property="department_name" name="dept" param="department_name" />
	<jsp:setProperty property="location_id" name="dept" param="location_id" />
	<jsp:setProperty property="manager_id" name="dept" param="manager_id" /> --%>
	<jsp:setProperty property="*" name="dept"/>
	
	<!-- 값 읽기 -->
	id:<jsp:getProperty property="department_id" name="dept"/><br>
	name:<jsp:getProperty property="department_name" name="dept"/><br>
	location:<jsp:getProperty property="location_id" name="dept"/><br>
	manager:<jsp:getProperty property="manager_id" name="dept"/><br>
</body>
</html>