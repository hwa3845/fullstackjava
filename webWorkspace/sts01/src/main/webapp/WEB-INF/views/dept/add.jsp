<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
</head>
<body>
<nav>
	<a href="${pageContext.request.contextPath }/index.do">home</a>
	<a href="${pageContext.request.contextPath }/dept/list.do">dept</a>
</nav>
<h1>add page</h1>
<form action="add.do" method="post">
	<div class="form-group">
		<label>deptno</label><input class="form-control" name="deptno" />
	</div>
	<div class="form-group">
		<label>dname</label><input class="form-control" name="dname" />
	</div>
	<div class="form-group">
		<label>location</label>
		<select name="loc" class="form-control">
			<option>서울</option>
			<option>대전</option>
			<option>대구</option>
			<option>부산</option>
			<option>광주</option>
			<option>제주</option>
		</select>
	</div>
	<div class="text-center">
		<button class="btn btn-primary" type="submit">입력</button>
		<button class="btn btn-default" type="reset">취소</button>
		<button class="btn btn-default" type="button" onclick="history.back();">뒤로</button>
	</div>
</form>

</body>
</html>