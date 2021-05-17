<%@page import="com.kosta.model.JobVO"%>
<%@page import="com.kosta.model.ManagerVO"%>
<%@page import="com.kosta.model.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="com.kosta.model.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input { margin-bottom: 10px; }
	label { 
		display:inline-block; 
		width:80px; 
		text-align: left;
	}
</style>
</head>
<body>
	<h1>직원 정보 수정</h1>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<form id="myfrm" action="empDetail.do" method="post">
		<!-- emp는 request.getAttribute("emp")와 같다. -->
		<img src="${pageContext.request.contextPath}/upload/${emp.phone_number }" width="100" height="100"><br>
		<label>직원번호:</label>
		<input type="text" name="employee_id" value="${emp.employee_id}" readonly><br>
		<label>성:</label>
		<input type="text" name="last_name" value="${emp.last_name }"><br>
		<label>이름:</label>
		<input type="text" name="first_name" value="${emp.first_name }"><br>
		<label>이메일:</label>
		<input type="text" name="email" value="${emp.email }"><br>
		<label>전화번호:</label>
		<input type="text" name="phone_number" value="${emp.phone_number }"><br>
		<label>입사일:</label>
		<input type="date" name="hire_date" value="${emp.hire_date }"><br>
		<label>직책:</label>
		<select name="job_id">
			<c:forEach var="j" items="${joblist }">
				<option ${j.job_id==emp.job_id?"selected":"" } value="${j.job_id }">${j.job_title}</option>
			</c:forEach>
		</select><br>
		<label>급여:</label>
		<input type="number" name="salary" value="${emp.salary }"><br>
		<label>커미션:</label>
		<input type="number" step=0.01 name="commission_pct" value="${emp.commission_pct}"><br>
		<label>매니저:</label>
		<select name="manager_id">
			<c:forEach var="m" items="${mlist }">
				<option value="${m.manager_id }" 
					<c:if test="${m.manager_id == emp.manager_id }">selected</c:if>>${m.fullname}</option>
			</c:forEach>
		</select><br>
		<label>부서:</label>
		<select name="department_id">
			<c:forEach var="dept" items="${deptlist }">
				<option value="${dept.department_id }" 
					<c:if test="${dept.department_id == emp.department_id }">selected</c:if>>${dept.department_name}</option>
			</c:forEach>
		</select><br>
		<input type="submit" value="수정하기(submit)">
		<input type="button" id="btnUpdate" value="수정하기(button)">
		<input type="button" id="btnUpdate2" value="수정하기(rest)">
		<input type="button" id="btnRetrieve" value="목록보기(button)">
		<input type="button" id="btnDelete" value="삭제하기(button)" mydata="${emp.employee_id}">
		<input type="button" id="btnDelete2" value="삭제하기(rest)" mydata="${emp.employee_id}">
		<br>
		<h1>${appInfo }</h1>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	$(function(){
		
		$("#btnUpdate").on("click", function(){
			$("#myfrm").submit();
		});
		
		$("#btnRetrieve").on("click", function(){
			location.href = "emplist.do";
		});
		
		$("#btnDelete").on("click", function(){
			//alert($(this).attr("mydata"));
			location.href = "empDelete.do?empid=" + $(this).attr("mydata");
		});
		
		$("#btnDelete2").on("click", function(){
			var url = "${pageContext.request.contextPath}/emp2/empDelete.do/" + $(this).attr("mydata"); 
			$.ajax({
				"url": url,
				type: "delete",
				success: function(responseData){
					alert(responseData);
				}
			});
		});
		
		$("#btnUpdate2").on("click", function(){
			var emp = $("#myfrm").serializeArray(); // [name,val],[name,val]
			var object = {};
			for (var i = 0; i < emp.length; i++){
			    object[emp[i]['name']] = emp[i]['value'];	// {"name":"val"} ...object
			}
			
			var json = JSON.stringify(object);	// '{"name":"val"}'  .. string으로
			
			$.ajax({
				url: "${pageContext.request.contextPath}/emp2/empUpdate.do/",
				type:"put", 
				data: json, 
				contentType:"application/json",
			    success:function(responseData){
			    	alert(responseData);
			    }
			});
		});
		
	});
	</script>
</body>
</html>