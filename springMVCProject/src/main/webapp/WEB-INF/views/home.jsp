<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Home</title>
<style>
	input, select { margin-bottom: 10px; width:130px; height:20px;}
	label { 
		display:inline-block; 
		width:80px; 
		text-align: left;
	}
</style>
</head>
<body>
	<h1>
		Hello world! 첫번째 JSP파일
	</h1>

	<P>  The time on the server is ${serverTime}. </P>
	
	<h1>AJAX</h1>

	<div id="here"></div>
	<form>
		직원번호:<input type="number" id="empid" value="100">
		<input id="btn1" type="button" value="rest로 보내기">
	</form>
	
	<hr>
	
	<form id="empForm">
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
			<c:forEach var="job" items="${joblist }">
				<option value="${job.job_id }">${job.job_title }</option>
			</c:forEach>
		</select><br>
		<label>급여:</label>
		<input type="number" name="salary"><br>
		<label>커미션:</label>
		<input type="number" step=0.01 name="commission_pct"><br>
		<label>매니저:</label>
		<select name="manager_id">
			<option value="" selected disabled hidden>===선택===</option>
			<c:forEach var="m" items="${mlist }">
				<option value="${m.manager_id }">${m.fullname }</option>
			</c:forEach>
		</select><br>
		<label>부서:</label>
		<select name="department_id">
			<option value="" selected disabled hidden>===선택===</option>
			<c:forEach var="dept" items="${deptlist }">
				<option value="${dept.department_id }">${dept.department_name }</option>
			</c:forEach>
		</select><br>
		<label>사진:</label>
		<input type="file" name="photos"><br>
		<input id="btn2" type="button" value="등록하기">
	</form>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		$(function(){
			$("#btn1").click(function(){
				$.ajax({
					url:"emp2/emp5.do/" + $("#empid").val(),
					type:"get",
					success: function(responseData){
						console.log(responseData);
						$("#here").html(responseData["first_name"]);
					}
				});
			});
			
			$("#btn2").click(function(){
				var fdata = $("#empForm").serialize(); // key=val&key2=val2 ---> RESTful은 /로 파라미터를 보내기 때문에 ?로 안씀
				
				var emp = $("#empForm").serializeArray(); // [name,val],[name,val]
				var object = {};
				for (var i = 0; i < emp.length; i++){
				    object[emp[i]['name']] = emp[i]['value'];	// {"name":"val"} ...object
				}
				
				var json = JSON.stringify(object);	// '{"name":"val"}'  .. string으로
				
				$.ajax({
					url:"emp2/empinsert.do",
					type:"post", 
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
