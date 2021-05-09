<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.loginInfo { border: 5px dotted green; float:right;}
</style>
</head>
<body>
	<!-- 모든 페이지에서 다 보이게 -->
	
	<div class="loginInfo">
		<c:if test="${emp != null }">
			<h3>로그인 정보(if)</h3>
			<p>${username}님 로그인되었습니다.</p> <!-- session에 저장해서 바로 쓸 수 있다. -->
			<p><a href="../login/logout.kosta">로그아웃</a></p>		
		</c:if>
		<c:if test="${emp == null }">	<!-- else가 없음 -->
			<p>손님</p>
			<p><a href="../login/loginChk.kosta">로그인</a></p>
		</c:if>
	</div>
	
	<hr>
	
	<div class="loginInfo">
	<c:choose>
		<c:when test="${emp == null }">
			<p>손님</p>
			<p><a href="../login/loginChk.kosta">로그인</a></p>
		</c:when>
		<c:otherwise>
			<h3>로그인 정보(choose)</h3>
			<p>${username}님 로그인되었습니다.</p>
			<p><a href="../login/logout.kosta">로그아웃</a></p>	
		</c:otherwise>
	</c:choose>
	</div>
</body>
</html>