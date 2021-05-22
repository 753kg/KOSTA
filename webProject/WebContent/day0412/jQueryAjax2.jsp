<%@page import="model.EmpDAO"%>
<%@page import="model.DeptVO"%>
<%@page import="java.util.List"%>
<%@page import="model.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<%
DeptDAO deptDAO = new DeptDAO();
List<DeptVO> deptlist = deptDAO.selectAll();
%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	//부서가 선택되면 ajax 실핼
	$("#deptSelect").on("change", function(){
		$.ajax({
			url:"emplist.jsp",
			data:{"deptid":$(this).val()},
			type:"get",
			success: function(htmlData){
				$("#emplist").html(htmlData);
			}
		});
	});
	
});
</script>
</head>
<body>
	<h1>부서 직원 목록 조회</h1>
	<select id="deptSelect">
		<option value="부서ID">부서이름</option>
		<%
		for(DeptVO dept:deptlist) {
			String s = String.format("<option value='%d'>%s</option>", dept.getDepartment_id(), dept.getDepartment_name());
			out.print(s);
		}
		%>
	</select>
	<div id="emplist"></div>
</body>
</html>