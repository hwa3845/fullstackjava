<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/header.jspf" %>
</head>
<body>
<%@ include file="../layout/menu.jspf" %>
<div class="container">
	<h1>add page</h1>
	<form class="form" action="insert.do" method="post">
		<div class="form-group">
			<label>deptno</label><input name="deptno" class="form-control"/>
		</div>
		<div class="form-group">
			<label>dname</label><input name="dname" class="form-control"/>
		</div>
		<div class="form-group">
			<label>loc</label><input name="loc" class="form-control"/>
		</div>
		<div class="form-group text-center">
			<button type="submit">입력</button>
			<button type="reset">취소</button>
			<button type="button">뒤로</button>
		</div>
	</form>
</div>
</body>
</html>