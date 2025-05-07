<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
java.util.Set list=new java.util.HashSet();
list.add("item1");
list.add("item2");
list.add("item3");
list.add("item4");
list.add("item5");
request.setAttribute("list", list);

java.util.Map map=new java.util.HashMap();
map.put("k1","v1");
map.put("k2","v2");
map.put("k3","v3");
map.put("k4","v4");
map.put("k5","v5");
request.setAttribute("map", map);
%>
<h1>loop</h1>

<jsp:useBean id="bean" class="com.web19.model.BbsDto" scope="page"></jsp:useBean>
<!-- usebean tag -->
<jsp:setProperty property="id" name="bean" value="admin"/>
<!-- jstl 문법 -> target 으로 설정 -->
<c:set target="${bean }" property="sub">제목없음</c:set>
<c:set target="${bean }" property="num">1234</c:set>
<c:set target="${bean }" property="content">한글로</c:set>
<p>${bean }</p>
<!-- BbsDto [num=0, sub=제목없음, content=null, id=null] -->
<p>${bean.num }</p>
<p>${bean.sub }</p>
<p>${bean.content }</p>
<p>${bean.id }</p>
<p>${bean.nalja }</p>
<!-- null인 곳은 빈칸으로 호출 -->
<ul>
	<c:forEach items="${map }" var="item">
		<li>${item }-${item.key }:${item.value }</li>
	</c:forEach>
</ul>


</body>
</html>