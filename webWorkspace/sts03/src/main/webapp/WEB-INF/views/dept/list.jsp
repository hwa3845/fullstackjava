<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/header.jspf" %>
</head>
<body>
<%@ include file="../layout/menu.jspf" %>
<h1>list page</h1>
<table class="table">
	<thead>
		<tr>
			<th>deptno</th>
			<th>dname</th>
			<th>loc</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="bean">
			<c:url var="path" value="detail.do">
				<c:param name="deptno" value="${bean.deptno }"></c:param>
			</c:url>
			<tr>
				<td><a href="${path }">${bean.deptno }</a></td>
				<td><a href="${path }">${bean.dname }</a></td>
				<td><a href="${path }">${bean.loc }</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<p><a href="add.do" class="btn btn-primary btn-block" role="button">입력</a></p>

<%@ include file="../layout/footer.jspf" %>
</body>
</html>