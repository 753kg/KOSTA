<%@page import="com.kosta.model.DeptDAO"%>
<%@page import="com.kosta.model.ManagerVO"%>
<%@page import="com.kosta.model.LocationVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
DeptDAO dao = new DeptDAO();
request.setAttribute("loclist", dao.selectAllLocation());
request.setAttribute("mlist", dao.selectAllManager());
%>
<% 
List<LocationVO> loclist = (List<LocationVO>)request.getAttribute("loclist");
List<ManagerVO> mlist = (List<ManagerVO>)request.getAttribute("mlist");
%>
</head>
<body>
	<h1>부서 신규 등록</h1>
	<!-- 값을 파라미터로 전달 -->
	<form action="jspbean_param_get.jsp">
		부서번호:<input type="number" name="department_id"><br>
		부서이름:<input type="text" name="department_name"><br>
		매니저:
		<select name="manager_id">
			<%for(ManagerVO m:mlist) {%>
				<option value="<%=m.getManager_id()%>"><%=m.getFullname()%></option>
			<%} %>
		</select><br>
		Location:
		<select name="location_id">
			<%for(LocationVO loc:loclist) {%>
				<option value="<%=loc.getLocation_id()%>"><%=loc.getCity()%></option>
			<%} %>
		</select><br>
		<input type="submit" value="등록하기">
	</form>
</body>
</html>