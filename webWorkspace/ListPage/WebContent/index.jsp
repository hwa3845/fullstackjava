<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mvc.model.*, com.mvc.util.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="css/frame.css">
<head>
  <meta charset="UTF-8" />
  <title>게시판 (AJAX)</title>
  
</head>
<body>

<%
	BbsDao dao=new BbsDao();
	java.util.List<BbsDto> list=dao.selectAll();
%>
<h1>List page</h1>

  <form onsubmit="return onSearch();">
    <input type="text" id="search" placeholder="검색어 입력">
    <input type="submit" class="button" value="검색" />
    <input type="hidden" id="hiddenKeyword" />
  </form>

<table>
<tr>
	<td width="50">글번호</td>
	<td>제목</td>
	<td width="50">글쓴이</td>
	<td width="100">날짜</td>
</tr>
<%
for(int i=0; i<list.size(); i++){
	BbsDto bean=list.get(i);
%>
<tr>
	<td><a href="detail.jsp?idx=<%=bean.getNum() %>"><%=bean.getNum() %></a></td>
	<td>
		<%
		for(int j=0; j<bean.getLvl(); j++){ 
			out.print("&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		if(bean.getLvl()!=0)out.print("┖");
		%>
		<%=bean.getSub() %>
	</td>
	<td><%=bean.getId() %></td>
	<td><%=bean.getNalja() %></td>
</tr>
<%
}
%>
</table>

</body>
</html>