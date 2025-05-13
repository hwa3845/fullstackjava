<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1~div {
	border-bottom: 1px dashed gray;
}

h1~div>span {
	display: inline-block;
	width: 33%;
}
</style>
</head>
<body>
	<nav>
	 <a href="${pageContext.request.contextPath }/">home</a>
	 <a	href="${pageContext.request.contextPath }/bbs/list">list</a> 
	</nav>
	<div>
		<h1>list page</h1>
		<c:forEach items="${list }" var="bean">
			<div>
				<span>${bean.deptno }</span> 
				<span>${bean.dname }</span> 
				<span>${bean.loc }</span>
			</div>
		</c:forEach>
		<p><a href="add">입력</a></p>
		
	</div>
</body>
</html>