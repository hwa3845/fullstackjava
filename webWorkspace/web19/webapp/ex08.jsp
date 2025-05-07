<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){
		document.querySelector('div').innerHTML=
			document.querySelector('.sch').innerHTML;
	};
</script>
</head>
<body>
	<h1>jstl etc</h1>
	<div><c:import url="https://m.naver.com"></c:import></div>
	<iframe url="ex01.jsp"></iframe>
	<p>end</p>
</body>
</html>