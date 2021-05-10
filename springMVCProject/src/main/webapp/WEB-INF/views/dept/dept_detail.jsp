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
	<h1>부서 상세 보기</h1>
	<form action="deptDetail.do" method="post">
		부서번호:<input type="number" value="${dept.department_id }" name="department_id"><br>
		부서이름:<input type="text" value="${dept.department_name }" name="department_name"><br>
		매니저ID:
		<select name="manager_id">
			<c:forEach var="m" items="${mlist }">
				<option value="${m.manager_id }" 
					<c:if test="${m.manager_id == dept.manager_id }">selected</c:if>>${m.fullname}</option>
			</c:forEach>
		</select><br>
		LocationID:
		<select name="location_id">
			<c:forEach var="loc" items="${loclist }">
				<option value="${loc.location_id }"
					<c:if test="${loc.location_id == dept.location_id }">selected</c:if>>${loc.city}</option>
			</c:forEach>
		</select><br>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>