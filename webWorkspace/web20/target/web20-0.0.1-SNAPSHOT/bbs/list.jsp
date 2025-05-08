<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:url value="/" var="root"></c:url>
<%@ include file="../layout/header.jspf" %>
<style type="text/css">
tr>th:nth-child(1){
	width: 80px;
}
tr>th:nth-child(3){
	width: 100px;
}
tr>th:nth-child(4){
	width: 120px;
}
</style>
</head>
<body>
<%@ include file="../layout/menu.jspf" %>
<h2 class="sub-header">게시판 페이지</h2>
<div class="table-responsive">
  <table class="table table-striped">
    <thead>
      <tr>
        <th>num</th>
        <th>subject</th>
        <th>id</th>
        <th>nalja</th>
      </tr>
    </thead>
    <tbody>
<c:forEach items="${list }" var="bean">   
<c:url var="detail" value="/bbs/detail.do">
	<c:param name="num" value="${bean.num }"></c:param>
</c:url> 
      <tr>
        <td><a href="${detail }">${bean.num }</a></td>
        <td><a href="${detail }">${bean.sub }</a></td>
        <td><a href="${detail }">${bean.id }</a></td>
        <td><a href="${detail }"><fmt:formatDate value="${bean.nalja }"/></a></td>
      </tr>
</c:forEach>
     </tbody>
   </table>
</div>
<p><a href="add.do" class="btn btn-primary btn-block" role="button">입력</a></p>

<%@ include file="../layout/footer.jspf" %>
</body>
</html>