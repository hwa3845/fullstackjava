<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/base.css">
<style type="text/css">
#content{}
#content form{
	width: 500px;
	margin: 10px auto 50px auto;
}
#content form>div{
	 margin-bottom: 10px ;
	 text-align: center;
}
#content form>div>label{
	display: inline-block;
	width: 100px;
	text-align: center;
	border-bottom: 1px solid gray;
}
#content form>div>input{
	width: 400px;
	box-sizing: border-box; 
}
#content form>div>textarea{
	width: 100%;
	height: 200px;
	box-sizing: border-box;
}
#content form>div>button{
	float: left;
	width: 30%;
	margin: 1%;
	
}
</style>
<script type="text/javascript">
	var form;
	window.onload=function(){
		form=document.querySelector("#content form");
		form.onsubmit=function(e){
			var input=form.querySelector('input');
			if(input.value=='')return false;
			if(input.value.length<5)return false;
			return true;
		};
	};
</script>
</head>
<body>
	<div>
		<div id="header">
			<h1>한국it여성기업인협회</h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="../">home</a></li>
				<li><a href="../intro.jsp">intro</a></li>
				<li><a href="./index.jsp">bbs</a></li>
				<li><a href="../login/">login</a></li>
			</ul>
		</div>
		<div id="content">
		<!-- content begin -->
		<h1>입력 페이지</h1>
		<form action="insert.jsp" method="post">
			<div>
				<label>제목</label><input name="sub"/>
			</div>
			<div><textarea name="content"></textarea></div>
			<div>
				<button type="submit">입력</button>
				<button type="reset">취소</button>
				<button type="button">뒤로</button>
			</div>
		</form>
		<!-- content end -->
		</div>
		<div id="footer">
			<address>(06130) 서울 강남구 테헤란로 7길 22, 한국과학기술회관 1관 303호</address>
			<p>&copy;한국IT여성기업인협회 Inc. All Rights Reserved.</p>
		</div>
	</div>
</body>
</html>






