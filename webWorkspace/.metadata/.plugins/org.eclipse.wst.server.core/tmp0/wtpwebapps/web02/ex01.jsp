<%@ page language="java" import="java.util.Date" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  윗 부분: 디렉티브(Directive) -> 클래스 바깥 쪽 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jsp의 문법 구조</h1>
<%!
//선언부(Declaration) 
//-> class 기준 필드(생성자, 메서드, 내부클래스 등) 자리(class 안쪽, 메서드 바깥 쪽)
int su1=1111;
public void func(){}
class Inner{}
%>
<p><%
//스크립트릿 -> main 메서드 안쪽
System.out.println(new Date());
%></p>
</body>
</html>