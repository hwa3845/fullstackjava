<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="bean" class="com.web12.model.Bbs05Dto"></jsp:useBean>
<jsp:setProperty property="sub" name="bean"/>
<jsp:setProperty property="content" name="bean"/>
<%@ page import="java.sql.*, com.web12.util.*" %>
<%
if("GET".equals(request.getMethod())){
	response.sendRedirect("add.jsp");
} else {
	try{
		Statement stmt=MyDataBase.getConnection().createStatement();
		stmt.executeUpdate(
				"insert into bbs05 (num,sub,content,cnt,nalja) values"
				+" (bbs05_seq.nextval, '"+bean.getSub()+"','"
				+bean.getContent()+"',0,sysdate)"
				);
	} finally{
		if(MyDataBase.getConnection()!=null) MyDataBase.getConnection().close();
		response.sendRedirect("./");
		}
}
%>
</body>
</html>