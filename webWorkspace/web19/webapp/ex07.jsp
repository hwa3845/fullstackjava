<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jstl etc</h1>
	<c:url var="myPath" value="https://search.naver.com/search.naver">
		<c:param name="query" value="java"></c:param>
		<c:param name="where" value="nexearch"></c:param>
	</c:url>
	<a href="${myPath }">link</a>
</body>
</html>