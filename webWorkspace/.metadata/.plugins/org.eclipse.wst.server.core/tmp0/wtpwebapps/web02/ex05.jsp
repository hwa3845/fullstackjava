<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>구구단</h1>
<table border="1" width="100%">
<%!
String setTr(String msg) {
	return "<tr>"+msg+"</tr>";
}
String setTd(String msg) {
	return "<td>"+msg+"</td>";
}
String gugu(int dan, int i){
	return dan+"x"+i+"="+(dan*i);
}
%>
<% for(int i=1; i<10; i++) {
	String msg="";
	for(int dan=2; dan<10; dan++) {
		msg+=setTd(gugu(dan,i));
	}
	String result=setTr(msg);
	out.print(result);

}%>
</table>
</body>
</html>