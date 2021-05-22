<%@page import="com.kosta.model.JobVO"%>
<%@page import="com.kosta.model.ManagerVO"%>
<%@page import="com.kosta.model.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="com.kosta.model.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
//EmpVO emp = (EmpVO)request.getAttribute("emp");
List<JobVO> joblist = (List<JobVO>)request.getAttribute("joblist");
List<DeptVO> deptlist = (List<DeptVO>)request.getAttribute("deptlist");
List<ManagerVO> mlist = (List<ManagerVO>)request.getAttribute("mlist");
int mydept = ((EmpVO)request.getAttribute("emp")).getDepartment_id();
int mymanager = ((EmpVO)request.getAttribute("emp")).getManager_id();
String myjob = ((EmpVO)request.getAttribute("emp")).getJob_id();
%>
</head>
<body>
	<h1>직원 정보 수정</h1>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<form id="myfrm" action="empUpdate" method="post">
		<!-- emp는 request.getAttribute("emp")와 같다. -->
		<img src="/webShop/upload/${emp.phone_number }"><br>
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
			<%
			for(JobVO j : joblist){
				String jobid = j.getJob_id();
				String s = myjob.equals(jobid)? "selected":"";
				out.print("<option "+s+" value='"+jobid+"'>"+j.getJob_title()+"</option>");
			}
			%>
		</select><br>
		<label>급여:</label>
		<input type="number" name="salary" value="${emp.salary }"><br>
		<label>커미션:</label>
		<input type="number" step=0.01 name="commission_pct" value="${emp.commission_pct}"><br>
		<label>매니저:</label>
		<select name="manager_id">
		<%
		for(ManagerVO m : mlist){
			int mid = m.getManager_id();
			String s = mymanager == mid? "selected":"";
			out.print("<option "+s+" value='"+mid+"'>"+m.getFullname()+"</option>");
		}
		%>
		</select><br>
		<label>부서:</label>
		<select name="department_id">
			<%for(DeptVO dept : deptlist) {%>
			<%	int deptid = dept.getDepartment_id(); %>
					<option <%=mydept==deptid?"selected":""%> value=<%=deptid%>><%=dept.getDepartment_name()%></option>
			<%} %>
		</select><br>
		<input type="submit" value="수정하기(submit)">
		<input type="button" id="btnUpdate" value="수정하기(button)">
		<input type="button" id="btnRetrieve" value="목록보기(button)">
		<input type="button" id="btnDelete" value="삭제하기(button)" mydata="${emp.employee_id}">
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
			location.href = "emplist";
		});
		
		$("#btnDelete").on("click", function(){
			//alert($(this).attr("mydata"));
			location.href = "empDelete?empid=" + $(this).attr("mydata");
		});
		
	});
	</script>
	<%-- selected 추가하기
	<script>
	var current_job = "<%=emp.getJob_id()%>";
	var current_manager = "<%=emp.getManager_id()%>";
	var current_dept = "<%=emp.getDepartment_id()%>";
	$('select[name="job_id"]').find('option[value="'+current_job+'"]').attr("selected",true);
	$('select[name="manager_id"]').find('option[value="'+current_manager+'"]').attr("selected",true);
	$('select[name="department_id"]').find('option[value="'+current_dept+'"]').attr("selected",true);
	</script> --%>
</body>
</html>