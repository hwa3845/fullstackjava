<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>el의 표현</h1>
	<jsp:useBean id="test1" class="java.util.Date" scope="page"></jsp:useBean>
	<p>
		<%
		int a=1234;
		//값 넣기
		/* pageContext.setAttribute("a", 1111);
		request.setAttribute("b", true);
		application.setAttribute("c", 3.14);
		session.setAttribute("d", "문자열"); */
	//속성으로 값을 실어서 전달(session, application, pageContext, request)
		//만약 같은 속성으로 전달한다면
		pageContext.setAttribute("a", 1111);
		request.setAttribute("a", true);
		application.setAttribute("a", 3.14);
		session.setAttribute("a", "문자열");

		//자바코드에서 값 호출
		/* out.print(pageContext.getAttribute("a"));
		out.print(request.getAttribute("b"));
		out.print(application.getAttribute("c"));
		out.print(session.getAttribute("d")); */
		//object로 캐스팅해서 써야 했으나 el에서는 타입을 유지하기 때문에 그냥 사용 가능
		//자바에서는 오류X
		out.print(pageContext.getAttribute("a"));
		out.print(request.getAttribute("a"));
		out.print(application.getAttribute("a"));
		out.print(session.getAttribute("a"));
		%>
	<!-- 
	<p>${a==1111 }</p>
	<p>${b==true }</p>
	<p>${c==3.14 }</p>
	<p>${d eq '문자열' }</p>
	-->
	<!-- 결과 true -> 타입을 유지한다는 뜻 -->
	
	<!-- el 우선순위: page > request > session > application -->
	<p>${a }</p>
	<p>${a }</p>
	<p>${a }</p>
	<p>${a }</p>
	<!-- 명세해서 각각 불러오기 가능 -->
	<!-- 장점: 없으면 오류나는 게 아니라 안 불러옴 -->
	<p>${pageScope.a }</p>
	<p>${requestScope.a }</p>
	<p>${sessionScope.a }</p>
	<p>${applicationScope.a }</p>
</body>
</html>