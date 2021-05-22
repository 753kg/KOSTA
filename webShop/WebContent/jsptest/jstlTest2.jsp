<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
	<p>html페이지의 기본경로 ==> http://localhost:9090</p>
	<p>jsp 페이지에서의 기본경로 ==> http://localhost:9090/webShop</p>
  <p>jsp의현재경로 ==> <%= request.getServletContext().getRealPath(".") %></p>
	<c:url value="/emp/empDetail" var="empD">
			<c:param name="empid" value="100"></c:param>
	</c:url>
	<a href="${empD }">100번 직원 상세보기</a>
	
	<%-- redirect : 다른페이지로 이동 --%>
	<%-- jstlTest2.jsp를 요청하면 emp상세보기로 감 --%>
	<%--
	<c:redirect url="/emp/empDetail">
			<c:param name="empid" value="100"></c:param>
	</c:redirect>
	 --%>
</body>
</html>