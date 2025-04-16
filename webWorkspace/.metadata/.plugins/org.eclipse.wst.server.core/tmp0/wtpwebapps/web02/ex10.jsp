<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>out 내장 객체 </h1>
<% 
out.write("출력1".toCharArray());
out.print("출력2");
out.append("출력3");
out.flush();
out.newLine();	//소스보기에서는 개행하고 있으나 화면(퍼포먼스)는 html에서 해줘야 함
out.println("출력4");
%>
</body>
</html>