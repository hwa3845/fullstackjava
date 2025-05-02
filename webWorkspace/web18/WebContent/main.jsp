<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/frame.css">
<link rel="stylesheet" type="text/css" href="css/jquery.bxslider.min.css">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.bxslider.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('.bx').bxSlider();
	});
</script>
</head>
<body>
<jsp:include page="layout/header.jsp"></jsp:include>
<jsp:include page="layout/menu.jsp">
	<jsp:param value="." name="path"/>
</jsp:include>
<div class="bx">
	<div><img src="imgs/s1.avif"/></div>
	<div><img src="imgs/s2.avif"/></div>
	<div><img src="imgs/s3.avif"/></div>
	<div><img src="imgs/s4.avif"/></div>
	<div><img src="imgs/s5.avif"/></div>
	<div><img src="imgs/s6.avif"/></div>
</div>
<jsp:include page="layout/footer.jsp"></jsp:include>
</body>
</html>