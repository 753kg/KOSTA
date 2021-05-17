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
				// responseData를 받는 function을 만들어서 resultPrint를 부르고 있었는데
				// resultPrint도 responseData를 받으니까 그냥 resultPrint를 넣어주기
			});
			
		});
		
		$("#dept input[type='button']").click(function(){
			var param = $("#dept input[name='deptid']").val();
			
			$.ajax({
				url: "${cpath }/emp2/selectByDept.do/" + param,
				type: "get",
				success: function(responseData){
					console.log(responseData);	// 배열
					console.log(JSON.stringify(responseData));
					resultPrint(responseData);
				}
			});
			
		});
		
		$("#loginButton").click(function(){
			
			
			// 100/SKING/서울시/010-1111-1111
			var param = $("#userid").val() + "/" + $("#userpw").val() + "/" + 
						$("#address").val() + "/" + $("#phone").val();
			$.ajax({
				url: "${cpath}/emp2/login3.do/" + param,	// 서버에서 해석
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
				url: "${pageContext.request.contextPath}/emp2/login3.do",		// 서버에서 해석
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
			<legend>여러가지 작업들</legend>
			<input type="radio" name="jobSelect" value="login" checked="checked">로그인
			<input type="radio" name="jobSelect" value="dept">부서로조회
			<input type="radio" name="jobSelect" value="salary">급여로조회
			<input type="radio" name="jobSelect" value="hiredate">입사일로조회(String)
			<input type="radio" name="jobSelect" value="hiredate2">입사일로조회(Date)
			<input type="radio" name="jobSelect" value="dynamic">동적으로조회
		</fieldset>
	</div>
	
	<div id="login" class="active">
		<h1>로그인하기</h1>
		<form>
			아이디:<input type="number" name="userid" id="userid" value="100"><br>
			비밀번호:<input type="password" name="userpw" id="userpw" value="SKING"><br>
			<!-- 숨겨서 보내기(데이터유지, 다른페이지로 넘기기 위해) -->
			<input type="hidden" name="address" id=address value="서울시">
			<input type="hidden" name="phone" id="phone" value="010-1111-1111">
			<input id="loginButton" type="button" value="로그인">
		</form>
	</div>
	
	<!-- 버튼이 submit이면 name주고 아니면 id주기 -->
	<div id="dept" class="deactive">
		<h1>부서로 조회하기</h1>
		<form>
			부서번호:<input type="number" name="deptid" value="10"><br>
			<input type="button" value="조회하기">
		</form>
	</div>
	
	<div id="salary" class="deactive">
		<h1>급여로 조회하기</h1>
		<form>
			최소:<input type="number" name="minsal" value="15000"><br>
			최대:<input type="number" name="maxsal" value="20000"><br>
			<input type="button" value="조회하기">
		</form>
	</div>
	
	<div id="hiredate" class="deactive">
		<h1>일자로 조회하기(String Type)</h1>
		<form>
			시작일:<input type="date" name="sdate" value="2005-01-01"><br>
			종료일:<input type="date" name="edate" value="2005-12-31"><br>
			<input type="button" value="조회하기">
		</form>
	</div>
	
	<div id="hiredate2" class="deactive">
		<h1>일자로 조회하기(Date Type)</h1>
		<form action="${cpath }/emp/selectByDate2.do">
			시작일:<input type="date" name="sdate" value="2005-01-01"><br>
			종료일:<input type="date" name="edate" value="2005-12-31"><br>
			<input type="button" value="조회하기">
		</form>
	</div>
	
	<div id="dynamic" class="deactive">
		<h1>동적으로 조회하기</h1>
		<form action="${cpath }/emp/selectByCondition.do">
			부서번호:<input type="number" name="deptid" value="60"><br>
			jobID:<input type="text" name="jobid" value="IT_PROG"><br>
			급여:<input type="number" name="sal" value="1000"><br>
			입사일:<input type="date" name="hdate" value="2005-01-03"><input type="checkbox" name="hdateChk">일자조회제외<br>
			<input type="button" value="조회하기">
		</form>
	</div>
	
	<div id="here">여기</div>
	
</body>
</html>