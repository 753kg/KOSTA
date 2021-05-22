<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
application.setAttribute("myAge_app", 10);	//서버꺼질때까지저장
session.setAttribute("myAge_session", 20);	//브라우저꺼질때까지저장
request.setAttribute("myAge_rq", 30);				// first를 요청할 때 저장, 전달해줘야됨
pageContext.setAttribute("myAge_page", 40); //first페이지에서만 저장

// first페이지에 가면 second페이지가 보임. 주소는 first
RequestDispatcher rd = request.getRequestDispatcher("second.jsp");
// rd.forward(request, response);	
// forward: 다시 돌아오지 않음
// include: 갔다가 돌아옴
rd.include(request, response);	// second페이지갔다가 first페이지로 돌아옴. 둘다같이보임

String dbname = application.getInitParameter("dbname");
String userid = application.getInitParameter("userid");
%>
<h1>first페이지에서 저장 후 가져오기</h1>
<p>application(서버): ${myAge_app }</p>
<p>session(브라우저): ${myAge_session }</p>
<p>request(요청시): ${myAge_rq }</p>
<p>pageContext(페이지내): ${myAge_page }</p>
<p>web.xml에 저장</p>
<p><%=dbname %></p>
<p><%=userid %></p>
</body>
</html>