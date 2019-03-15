<%@page import="day0313.TestVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="반복문 forEach 사용 2"
    %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#wrap{ margin:0px auto; width:800px; height:860px; }
#header{  width:800px; height:140px; background: #FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x;
			position: relative;	}
#headerTitle{ font-family: HT견고딕,고딕; font-size: 30px; font-weight: bold;text-align: center;
				position:absolute; top: 40px;left: 290px; }
#container{  width:800px; height:600px; }
#footer{  width:800px; height:120px; }
#footerTitle{ float: right;font-size: 15px; padding-top: 20px; padding-right: 20px }

</style>
</head>
<body>
<div id="wrap">
	<div id="header">
	<div id="headerTitle">SIST Class4 </div>
	</div>
	<div id="container">
	<select>
	<!-- 증가하는 값을 반복시킬 때 -->
		<c:forEach var="i" begin="1" end="100" step="1">
		<option value="${i}"><c:out value="${i}"/></option>
		</c:forEach>
	</select>
	<div>
	<%
		String[] movie ={"시네마 천국","주토피아","코어","7인의 사무라이","트루먼쇼","인셉션"};
		pageContext.setAttribute("movie", movie);
	%>
	<c:set var="i" value="0"></c:set>
	<ul>
	<c:forEach var="movie" items="${movie }">
		${i=i+1}.
		${movie}<br/>
	</c:forEach>
	</ul>
	<%
		//List의 값을 출력
		List<String> list= new ArrayList<String>();
		list.add("Java SE");
		list.add("Java EE");
		list.add("DBMS");
		list.add("HTML");
		pageContext.setAttribute("list", list);
	%>
	<ul>
	<c:forEach var="subject" items="${list}">
	<li><c:out value="${subject}"/></li>
	</c:forEach>
	</ul>
	<%
		//List가 Generic으로 VO를 가진 경우
		//forEach안에서 "변수명.getter명"
		List<TestVO> voList = new ArrayList<TestVO>();
		voList.add(new TestVO("정윤",30));
		voList.add(new TestVO("희철",27));
		voList.add(new TestVO("재찬",28));
		voList.add(new TestVO("택성",28));
		
		pageContext.setAttribute("vl", voList);
	%>
	<table border="1">
	<thead>
	<tr>
		<th width="50">번호</th>
		<th width="100">이름</th>
		<th width="50">나이</th>
	</tr>
	</thead>
	<tbody>
	</tbody>
	<c:forEach var="data" items="${vl}">
	<c:set var="cnt" value="${cnt+1}" />
	<tr>
		<td><c:out value="${cnt}"/></td>
		<td><c:out value="${data.firstName}"/></td>
		<td><c:out value="${data.age}"/></td>
	</tr>
	</c:forEach>
	</table>
	</div>
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
	</div>
</div>
</body>
</html>








