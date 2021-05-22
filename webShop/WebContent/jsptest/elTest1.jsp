<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kosta.model.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
request.setAttribute("mystr", "자바");
request.setAttribute("myval", null);

pageContext.setAttribute("score", 10);
request.setAttribute("score", 20);
session.setAttribute("score", 30);
application.setAttribute("score", 40);

String name ="jj"; // ==> EL로 못가져옴 <%= or setAttribute 해야함
pageContext.setAttribute("dept", new DeptVO(10, "개발부", 100, 1700));

ArrayList<DeptVO> deptlist = new ArrayList<>();
deptlist.add(new DeptVO(10, "개발부1", 100, 1700));
deptlist.add(new DeptVO(20, "개발부2", 100, 1700));
deptlist.add(new DeptVO(30, "개발부3", 100, 1700));
pageContext.setAttribute("deptlist", deptlist);

HashMap<String, String> user = new HashMap<>();
user.put("아이디", "zzid");
user.put("이름", "홍길동");
user.put("phone", "010-1234-5676");
pageContext.setAttribute("user", user);
%>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	숫자연산: ${10 + 20}<br>
	숫자문자연결: ${mystr}100<br>
	숫자문자연결: ${"문자"}100<br>
	비교연산자(&lt;): ${ 10 < 20 }<br>
	비교연산자(le): ${ 10 le 20 }<br>
	비교연산자(==):${"aa" == "aa" } <br>
	비교연산자(eq):${"aa" eq "bb" } <br>
	null인변수: ${myval }<br>
	null확인: ${empty myval }<br>
	null+10: ${myval+10 }<br>
	<br>
	<h3>내장객체</h3>
	parameter읽기(주소창에서 ?age=20로 요청) : ${param.age }<br>
	scope사용(가장가까운쪽): ${score }<br>
	scope사용(page): ${pageScope.score }<br>
	scope사용(request): ${requestScope.score }<br>
	scope사용(session): ${sessionScope.score }<br>
	scope사용(application): ${applicationScope.score }<br>
	<br>
	부서코드: ${dept.department_id }<br>		<!-- 자동으로 getDepartment_id 함수를 지나간다. -->
	부서이름: ${dept.department_name }<br>	
	부서위치: ${dept.location_id }<br>	
	매니저: ${dept.manager_id }<br>	
	
	<h3>collection 연습</h3>
	<h4>list</h4>
	부서코드: ${deptlist[0].department_id }<br>	<!-- EL에는 반복문이 없다. -->
	부서이름: ${deptlist[0].department_name }<br>	
	부서위치: ${deptlist[0].location_id }<br>	
	매니저: ${deptlist[0].manager_id }<br>
	<br>
	부서코드: ${deptlist[1].department_id }<br>
	부서이름: ${deptlist[1].department_name }<br>	
	부서위치: ${deptlist[1].location_id }<br>	
	매니저: ${deptlist[1].manager_id }<br>
	
	<h4>map</h4>
	아이디: ${user["아이디"] }<br>	<!-- key를 주면 값이 온다. -->
	이름: ${user["이름"]}<br>			<!-- key가 한글이면 [] 사용  -->
	전화번호: ${user.phone}<br>
	
	
</body>
</html>