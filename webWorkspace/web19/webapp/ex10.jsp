<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jstl format</h1>
<p>123456</p>
<p><fmt:formatNumber value="1234567" pattern="000,000,000"></fmt:formatNumber></p>
<p><fmt:formatNumber var="su" value="1234567" pattern="###,###,###"></fmt:formatNumber></p>
<p>${su }</p>
<p><%=new java.util.Date() %></p>
<p><fmt:formatDate value="<%=new java.util.Date() %>" pattern="yy.MM.dd hh:mm:ss"></fmt:formatDate></p>
</body>
</html>