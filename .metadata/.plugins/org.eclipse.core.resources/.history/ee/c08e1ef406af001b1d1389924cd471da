<%@page import="com.kosta.model.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td { border:1px solid black; border-collapse: collapse; }
	td { padding: 5px; }
	tr:first-of-type { background-color: lightgray; }
</style>

</head>
<body>
	<h1>직원 전부 조회</h1>
	<h2>로그인정보: ${username}</h2>
	<!-- 표준액션: header와 emplist 따로 컴파일 후 합침 -->
	<jsp:include page="../common/header.jsp"></jsp:include>
	<a href="empInsert">신규등록</a>
	<table>
		<tr>
			<td>직원번호</td>
			<td>성</td>
			<td>이름</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td>입사일</td>
			<td>JOB</td>
			<td>급여</td>
			<td>커미션</td>
			<td>매니저</td>
			<td>부서</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<c:forEach var="emp" items="${emplist}">
		<c:url value="empDetail" var="empD">
			<c:param name="empid" value="${emp.employee_id}"></c:param>
		</c:url>
			<tr>
				<td><a href="${empD}">${emp.employee_id}</a></td>
				<td><a href="${empD}">${fn:toLowerCase(emp.last_name)}</a></td>
				<td><a href="${empD}">${fn:toUpperCase(emp.first_name)}</a></td>
				<td>${emp.email}</td>
				<td>${emp.phone_number}</td>
				<td>
					<fmt:formatDate pattern="YYYY-MM-dd hh:mm:ss" value="${emp.hire_date}"/>
				</td>
				<td>${emp.job_id}</td>
				<td>
					<%-- groupingUsed="true" : 3자리씩 ,로 끊음 --%>
					<fmt:formatNumber type="currency" currencySymbol="$" groupingUsed="true" value="${emp.salary}"/>
				</td>
				<td>${emp.commission_pct}</td>
				<td>${emp.manager_id}</td>
				<td>${emp.department_id}</td>
				<td><a href="${empD}">수정</a></td>
				<td><button onclick="call(${emp.employee_id});">삭제</button></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<!-- 디렉티브 태그: footer와 emplist 합쳐서 컴파일. -->
	<!-- 컴파일 전에 경로에서 파일을 찾아서 합친다.. 경로오류.. 그래서 불가 -->
	<%-- <%@ include file="${contextPath}/common/footer.jsp" %> --%>
	<p>html태그의 기본경로 ==> http://localhost:9090</p>
	<p>jsp페이지에서의 기본경로 ==> http://localhost:9090/webShop</p>
	<c:set var="aa" value="${pageContext.request.contextPath }"/> <%--jsp기본경로 --%>
	<jsp:include page="/common/footer.jsp"></jsp:include>
	<img src="${aa }/duke.png"/> <%-- html기본경로  --%>
	<script>
		function call(empid){
			// get방식
			// post는 form으로만 가능
			location.href = "empDelete?empid=" + empid;
		}
	</script>
</body>
</html>