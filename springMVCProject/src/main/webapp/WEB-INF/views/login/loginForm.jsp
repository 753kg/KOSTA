<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.deactive { display:none; }
	.active { display:block; }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>
<script>
	$(function(){
		$('input[name="jobSelect"]').on("change", function(){
			$("#here").html("");
			$('div[class="active"]').attr('class','deactive');
			var id = "#" + $(this).val();
			$(id).attr('class', 'active');
		});
	});

</script>
<script>
	function resultPrint(responseData){
		var output = "<ul>";
		$.each(responseData, function(index, item){
			output += "<li>" + item["first_name"] + "</li>";
		});
		output += "</ul>";
		$("#here").html(output);
	}

	$(function(){
		$("#dynamic input[type='button']").click(function(){
			var deptid = $("#dynamic input[name='deptid']").val();
			if(deptid == "") deptid = 0;
			var jobid = $("#dynamic input[name='jobid']").val();
			if(jobid == "") jobid = null;
			var sal = $("#dynamic input[name='sal']").val();
			if(sal == "") sal = 0;
			var hdate = $("#dynamic input[name='hdate']").val();
			if(hdate == "") hdate = null;
			var hdateChk = $("#dynamic input[name='hdateChk']").prop("checked");
			
			var param = deptid + "/" + jobid + "/" + sal + "/"+ hdate + "/"+ hdateChk;
			alert(param);
			
			$.ajax({
				url: "${cpath }/emp2/selectByDynamic.do/" + param,
				type: "get",
				success: resultPrint
			});
			
		});
		
		$("#hiredate2 input[type='button']").click(function(){
			var sdate = $("#hiredate2 input[name='sdate']").val();
			var edate = $("#hiredate2 input[name='edate']").val();
			var param = sdate + "/" + edate;
			
			$.ajax({
				url: "${cpath }/emp2/selectByDate2.do/" + param,
				type: "get",
				success: resultPrint
			});
			
		});
		
		$("#hiredate input[type='button']").click(function(){
			var sdate = $("#hiredate input[name='sdate']").val();
			var edate = $("#hiredate input[name='edate']").val();
			var param = sdate + "/" + edate;
			
			$.ajax({
				url: "${cpath }/emp2/selectByDate.do/" + param,
				type: "get",
				success: resultPrint
			});
			
		});
		
		$("#salary input[type='button']").click(function(){
			var minsal = $("#salary input[name='minsal']").val();
			var maxsal = $("#salary input[name='maxsal']").val();
			var param = minsal + "/" + maxsal;
			
			$.ajax({
				url: "${cpath }/emp2/selectBySalary.do/" + param,
				type: "get",
				success: resultPrint		
				// responseData??? ?????? function??? ???????????? resultPrint??? ????????? ????????????
				// resultPrint??? responseData??? ???????????? ?????? resultPrint??? ????????????
			});
			
		});
		
		$("#dept input[type='button']").click(function(){
			var param = $("#dept input[name='deptid']").val();
			
			$.ajax({
				url: "${cpath }/emp2/selectByDept.do/" + param,
				type: "get",
				success: function(responseData){
					console.log(responseData);	// ??????
					console.log(JSON.stringify(responseData));
					resultPrint(responseData);
				}
			});
			
		});
		
		$("#loginButton").click(function(){
			
			
			// 100/SKING/?????????/010-1111-1111
			var param = $("#userid").val() + "/" + $("#userpw").val() + "/" + 
						$("#address").val() + "/" + $("#phone").val();
			$.ajax({
				url: "${cpath}/emp2/login3.do/" + param,	// ???????????? ??????
				type:"get",
				success: function(responseData){
					console.log(responseData);
					$("#here").html(JSON.stringify(responseData));
				}
			});
			
			
			/*
			var obj = {"userid":$("#userid").val(), "userpw":$("#userpw").val(), 
					"address":$("#address").val(), "phone":$("#phone").val()};
			alert(JSON.stringify(obj));
			$.ajax({
				url: "${pageContext.request.contextPath}/emp2/login3.do",		// ???????????? ??????
				type:"post",
				data: JSON.stringify(obj),
				contentType: "application/json;charset=utf-8",
				success: function(responseData){
					console.log(responseData);
					$("#here").html(JSON.stringify(responseData));
				}
			});
			*/
		});
	});
</script>
</head>
<body>

	<div>
		<fieldset>
			<legend>???????????? ?????????</legend>
			<input type="radio" name="jobSelect" value="login" checked="checked">?????????
			<input type="radio" name="jobSelect" value="dept">???????????????
			<input type="radio" name="jobSelect" value="salary">???????????????
			<input type="radio" name="jobSelect" value="hiredate">??????????????????(String)
			<input type="radio" name="jobSelect" value="hiredate2">??????????????????(Date)
			<input type="radio" name="jobSelect" value="dynamic">??????????????????
		</fieldset>
	</div>
	
	<div id="login" class="active">
		<h1>???????????????</h1>
		<form>
			?????????:<input type="number" name="userid" id="userid" value="100"><br>
			????????????:<input type="password" name="userpw" id="userpw" value="SKING"><br>
			<!-- ????????? ?????????(???????????????, ?????????????????? ????????? ??????) -->
			<input type="hidden" name="address" id=address value="?????????">
			<input type="hidden" name="phone" id="phone" value="010-1111-1111">
			<input id="loginButton" type="button" value="?????????">
		</form>
	</div>
	
	<!-- ????????? submit?????? name?????? ????????? id?????? -->
	<div id="dept" class="deactive">
		<h1>????????? ????????????</h1>
		<form>
			????????????:<input type="number" name="deptid" value="10"><br>
			<input type="button" value="????????????">
		</form>
	</div>
	
	<div id="salary" class="deactive">
		<h1>????????? ????????????</h1>
		<form>
			??????:<input type="number" name="minsal" value="15000"><br>
			??????:<input type="number" name="maxsal" value="20000"><br>
			<input type="button" value="????????????">
		</form>
	</div>
	
	<div id="hiredate" class="deactive">
		<h1>????????? ????????????(String Type)</h1>
		<form>
			?????????:<input type="date" name="sdate" value="2005-01-01"><br>
			?????????:<input type="date" name="edate" value="2005-12-31"><br>
			<input type="button" value="????????????">
		</form>
	</div>
	
	<div id="hiredate2" class="deactive">
		<h1>????????? ????????????(Date Type)</h1>
		<form action="${cpath }/emp/selectByDate2.do">
			?????????:<input type="date" name="sdate" value="2005-01-01"><br>
			?????????:<input type="date" name="edate" value="2005-12-31"><br>
			<input type="button" value="????????????">
		</form>
	</div>
	
	<div id="dynamic" class="deactive">
		<h1>???????????? ????????????</h1>
		<form action="${cpath }/emp/selectByCondition.do">
			????????????:<input type="number" name="deptid" value="60"><br>
			jobID:<input type="text" name="jobid" value="IT_PROG"><br>
			??????:<input type="number" name="sal" value="1000"><br>
			?????????:<input type="date" name="hdate" value="2005-01-03"><input type="checkbox" name="hdateChk">??????????????????<br>
			<input type="button" value="????????????">
		</form>
	</div>
	
	<div id="here">??????</div>
	
</body>
</html>