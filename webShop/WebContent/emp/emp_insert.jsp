<%@page import="com.kosta.model.JobVO"%>
<%@page import="com.kosta.model.ManagerVO"%>
<%@page import="com.kosta.model.DeptVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input, select { margin-bottom: 10px; width:130px; height:20px;}
	label { 
		display:inline-block; 
		width:80px; 
		text-align: left;
	}
</style>
<%
List<JobVO> joblist = (List<JobVO>)request.getAttribute("joblist");
List<DeptVO> deptlist = (List<DeptVO>)request.getAttribute("deptlist");
List<ManagerVO> mlist = (List<ManagerVO>)request.getAttribute("mlist");
%>
</head>
<body>
	<h1>직원 신규 등록</h1>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<form action="empInsert" method="post" enctype="multipart/form-data">
		<label>직원번호:</label>
		<input type="text" name="employee_id"><br>
		<label>성:</label>
		<input type="text" name="last_name"><br>
		<label>이름:</label>
		<input type="text" name="first_name"><br>
		<label>이메일:</label>
		<input type="text" name="email"><br>
		<label>전화번호:</label>
		<input type="text" name="phone_number"><br>
		<label>입사일:</label>
		<input type="date" name="hire_date"><br>
		<label>직책:</label>
		<select name="job_id">
			<option value="" selected disabled hidden>===선택===</option>
			<%for(JobVO job : joblist) {%>
			<option value="<%=job.getJob_id()%>"><%=job.getJob_title() %></option>
			<%} %>
		</select><br>
		<label>급여:</label>
		<input type="number" name="salary"><br>
		<label>커미션:</label>
		<input type="number" step=0.01 name="commission_pct"><br>
		<label>매니저:</label>
		<select name="manager_id">
			<option value="" selected disabled hidden>===선택===</option>
			<%for(ManagerVO m : mlist) {%>
			<option value=<%=m.getManager_id()%>><%=m.getFullname()%></option>
			<%} %>
		</select><br>
		<label>부서:</label>
		<select name="department_id">
			<option value="" selected disabled hidden>===선택===</option>
			<%for(DeptVO dept : deptlist) {%>
			<option value=<%=dept.getDepartment_id()%>><%=dept.getDepartment_name() %></option>
			<%} %>
		</select><br>
		<label>사진:</label>
		<input type="file" name="photos"><br>
		<input type="submit" value="등록하기">
	</form>
	<br>
	<h1>${appInfo }</h1>
</body>
</html>
<!-- 숙제 : JOB, 매니저, 부서 선택으로 바꾸기!! -->