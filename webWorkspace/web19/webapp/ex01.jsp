<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		width: 100%;
	}
	th{
		width: 25%;
	}
</style>
</head>
<body>
	<h1>el language(EL 표현식)</h1>
	<table>
		<tr>
			<th>자료형</th>
			<th>자바</th>
			<th>EL Lang</th>
			<th>etc</th>
		</tr>
		<tr>
			<td>숫자(10진수 정수)</td>
			<td><%=1234 %></td>
			<td>${1234} </td>
			<td></td>
		</tr>
		<tr>
			<td>숫자(10진수 실수)</td>
			<td><%=3.14 %></td>
			<td>${3.14 }</td>
			<td></td>
		</tr>
		<tr>
			<td>문자열</td>
			<td><%="문자열" %></td>
			<td>${"문자열" }</td>
			<td></td>
		</tr>
		<tr>
			<td>문자열</td>
			<td><%='a'+1 %></td>
			<td>${'a' }</td>
				<!-- java에서는 ''은 오류(char), js는 가능 
					js 는 한 글자라도 문자열
				-->
			<td></td>
		</tr>
		<tr>
			<td>boolean</td>
			<td><%=true %></td>
			<td>${true }</td>
			<td></td>
		</tr>
		<tr>
			<td>boolean</td>
			<td><%=false %></td>
			<td>${false }</td>
			<td></td>
		</tr>
		<tr>
			<td>사칙연산(+)</td>
			<td><%=1+2+3+4+5 %></td>
			<td>${1+2+3+4+5 }</td>
			<td></td>
		</tr>
		<tr>
			<td>사칙연산(-)</td>
			<td><%=6-2 %></td>
			<td>${6-2 }</td>
			<td></td>
		</tr>
		<tr>
			<td>사칙연산(*)</td>
			<td><%=6*2 %></td>
			<td>${6*2 }</td>
			<td></td>
		</tr>
		<tr>
			<td>사칙연산(/)</td>
			<td><%=5/2 %></td>
			<td>${5/2 }</td>
			<!-- el은 정수끼리 연산해도 실수로 연산 -->
			<td></td>
		</tr>
		<tr>
			<td>사칙연산(%)</td>
			<td><%=5%2 %></td>
			<td>${5%2 }</td>
			<td>${5 mod 2 }</td>
		</tr>
		<tr>
			<td>사칙연산(/)</td>
			<td><%=5/2==2.5 %></td>	<!-- 2는 true, 2.5는 false -->
			<td>${5/2==2.5 }</td>	<!-- 나눠 떨어지면 true(또, 3.0==3), 아니면 false -->
			<!-- <td>${5 div 2 }</td> --> <!-- 오류 아님, 이클립스 버그 -->
		</tr>
		<tr>
			<td>비교연산<</td>
			<td><%=5<3 %></td>
			<td>${5<3 }</td>
			<td>${5 lt 3 }</td> 	<!-- 5<3의 방식보다 이 방식 사용(오류방지)-->
		</tr>
		<tr>
			<td>비교연산></td>
			<td><%=5>3 %></td>
			<td>${5>3 }</td>
			<td>${5 gt 3 }</td>
		</tr>
		<tr>
			<td>비교연산==</td>
			<td><%=5==3 %></td>
			<td>${5==3 }</td>
			<td>${5 eq 3 }</td>
		</tr>
		<tr>
			<td>비교<=</td>
			<td><%=5<=3 %></td>
			<td>${5<=3 }</td>
			<td>${5 le 3 }</td>
		</tr>
		<tr>
			<td>비교>=</td>
			<td><%=5>=3 %></td>
			<td>${5>=3 }</td>
			<td>${5 ge 3 }</td>
		</tr>
		<tr>
			<td>NULL</td>
			<td><%Object obj=null; out.print(obj); %></td>
			<!-- java에서 =null은 오류, null이 빈칸이 아니라 문자열 null출력-->
			<td>${null }</td>	<!-- 없는 것이라서 빈칸으로 나옴 -->
			<td></td>
		</tr>
		<jsp:useBean id="d" class="java.util.Date"></jsp:useBean>
		<%
		d=null;
		pageContext.setAttribute("d", null);
		%>
		<tr>
			<td>NULL</td>
			<td><%=d==null %></td>
			<td>${d }</td>
			<td>${d eq null }</td>
		</tr>
	</table>
</body>
</html>