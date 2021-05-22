<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL태그연습</h1>
	<h3>코어문법</h3>
	<!-- setAttribute, var:변수이름, value:값 -->
	<c:set var="count" value="10"/>
	<c:set var="count" value="${count+1}"/>	<!-- count를 읽고 +1 한 뒤 set -->
	현재 count : ${count }<br>	<%-- ${} : getAttribute --%>
	
	<h3>이미지 경로</h3>
	<c:set var="appPath" value="${pageContext.request.contextPath}"></c:set>
	pageContext.request.contextPath: ${appPath }<br>
	상대경로:<img alt="image1" src="../image/duke.png"><br>
	절대경로:<img alt="image2" src="http://localhost:9090/webShop/image/duke2.png"><br>
	권장:<img alt="image3" src="${appPath}/image/duke2.png"><br>
	
	<h3>반복문</h3>
	<c:set var="total" value="0"/>
	<c:forEach begin="1" end="10" var="su">
		<c:set var="total" value="${ total+su }"/>
		<p>${su }</p>
	</c:forEach>
	합계: ${total }
	 
</body>
</html>