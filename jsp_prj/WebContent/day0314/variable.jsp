<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="EL에서 제공하는 변수관련 태그"
    %>
<!-- JSTL을 사용할려면 지시자 선언 -->
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
	<!-- 변수의 선언 -->
	<%
		int month=3;
		pageContext.setAttribute("month", month);
	%>
	<c:set var="i" value="14"/>
	<c:set var="mon" value="<%=month %>"/>
	<c:set var="name" value="김희철"/>
	<!-- 출력 -->
	i= <c:out value="${i+1 }"/>
	<strong><c:out value="${name}"/></strong>
	pageScope 사용: <c:out value="${month} "/>(<c:out value="${ pageScope.month }"/>)
	<br/>
	&lt;c:set&gt;사용: <c:out value="${ mon +60 }"/>
	<c:remove var="i"/>
	<c:remove var="name"/>
	<br/>
	변수삭제후
	i= <c:out value="${ i }"/>
	name =<c:out value="${name}"/>
	month = <c:out value="${mon} "/>
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
	</div>
</div>
</body>
</html>








