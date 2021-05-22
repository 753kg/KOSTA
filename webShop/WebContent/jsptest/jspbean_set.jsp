<%@page import="com.kosta.model.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>표준액션태그 --> jsp: 으로 시작</h1>
	<%--1. 스크립트릿? 방법 <%
	RequestDispatcher rd = request.getRequestDispatcher("test2.jsp");	// 특정 페이지와 연결
	//rd.include(request, response);	// 연결한 페이지가 이 페이지로 들어옴
	rd.forward(request, response);	// 연결한 페이지로 이동
	%> --%>
	
	<!-- 2.표준액션태그 -->
	<%-- <jsp:include page="test2.jsp"/> --%>
	<%-- <jsp:forward page="test2.jsp"/> --%>
	
	<!-- 객체만들기 -->
	<!-- 1. 스크립트릿?? -->
	<%
	DeptVO dept = new DeptVO();
	dept.setDepartment_id(100);
	dept.setDepartment_name("부서이름연습");
	dept.setLocation_id(1700);
	dept.setManager_id(200);
	%>
	<%=dept.getDepartment_id() %><br>
	
	<!-- 2. 표준액션태그 -->
	<!-- DeptVO에 default생성자가 꼭 있어야한다. -->
	<jsp:useBean id="dept2" class="com.kosta.model.DeptVO" scope="request"/>	<!-- request: request영역에서 쓸 수 있다. -->
	<jsp:setProperty property="department_id" name="dept2" value="101" />
	<jsp:setProperty property="department_name" name="dept2" value="부서이름연습2" />
	<jsp:setProperty property="location_id" name="dept2" value="1800" />
	<jsp:setProperty property="manager_id" name="dept2" value="201" />
	
	<!-- 값 가져오기 -->
	id:<jsp:getProperty property="department_id" name="dept2"/><br>
	name:<jsp:getProperty property="department_name" name="dept2"/><br>
	location:<jsp:getProperty property="location_id" name="dept2"/><br>
	manager:<jsp:getProperty property="manager_id" name="dept2"/><br>
	
	<!-- 값 보내기 -->
	<jsp:forward page="jspbean_get.jsp"/>
</body>
</html>