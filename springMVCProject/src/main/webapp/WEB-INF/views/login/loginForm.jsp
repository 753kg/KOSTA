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
	<h1>로그인하기</h1>
	<form action="login3.do" method="post">
		아이디:<input type="number" name="userid" value="100"><br>
		비밀번호:<input type="password" name="userpw" value="SKING"><br>
		<!-- 숨겨서 보내기(데이터유지, 다른페이지로 넘기기 위해) -->
		<input type="hidden" name="address" value="서울시">
		<input type="hidden" name="phone" value="010-1111-1111">
		<input type="submit" value="로그인">
	</form>

		

	<hr><hr>
	
	<c:set var="cpath" value="${pageContext.request.contextPath}"/>
	
	<h1>부서로 조회하기</h1>
	<form action="${cpath }/emp/selectByDept.do">
		부서번호:<input type="number" name="deptid" value="10"><br>
		<input type="submit" value="조회하기">
	</form>
	
	<h1>급여로 조회하기</h1>
	<form action="${cpath }/emp/selectBySalary.do">
		최소:<input type="number" name="minsal" value="15000"><br>
		최대:<input type="number" name="maxsal" value="20000"><br>
		<input type="submit" value="조회하기">
	</form>
	
	<h1>일자로 조회하기</h1>
	<h4>String Type</h4>
	<form action="${cpath }/emp/selectByDate.do">
		시작일:<input type="date" name="sdate" value="2005-01-01"><br>
		종료일:<input type="date" name="edate" value="2005-12-31"><br>
		<input type="submit" value="조회하기">
	</form>
	<h4>Date Type</h4>
	<form action="${cpath }/emp/selectByDate2.do">
		시작일:<input type="date" name="sdate" value="2005-01-01"><br>
		종료일:<input type="date" name="edate" value="2005-12-31"><br>
		<input type="submit" value="조회하기">
	</form>
	
	<h1>동적으로 조회하기</h1>
	<form action="${cpath }/emp/selectByCondition.do">
		부서번호:<input type="number" name="deptid" value="60"><br>
		jobID:<input type="text" name="jobid" value="IT_PROG"><br>
		급여:<input type="number" name="sal" value="10000"><br>
		입사일:<input type="date" name="hdate" value="2005-01-03"><input type="checkbox" name="hdateChk">일자조회제외<br>
		<input type="submit" value="조회하기">
	</form>
	
</body>
</html>