<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session="true"
    info="session 내장객체 사용"
    %>
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
	<%! 
	private Map<String,String> logMap= new HashMap<String,String>();
	{
		logMap.put("gong", "공선의");
		logMap.put("lee", "이재찬");
		logMap.put("kim", "김희철");
	}//instance 영역: 클래시가 실행될 때 자동 호출되며, 한번만 실행된다.(이름이 없으므로 호출 불가)
	%>
	<%
	String id= request.getParameter("id");
	String pass= request.getParameter("pass");
	
	if(logMap.containsKey(id)&&"1234".equals(pass)){
		//로그인 성공
		session.setAttribute("user_id", id);
		session.setAttribute("user_name", logMap.get(id));
		
		//세션 생존시간 설정
		session.setMaxInactiveInterval(60*1);
		//servlet이나 JSP에서 Console로 출력할 때 log method 사용.
		String name =(String)session.getAttribute("user_name");
		%>
		로그인 성공<br/> <a href="use_session_c.jsp">로그아웃</a><br/>
		<%=name %>님 로그인 하셨습니다.<br/>
		<a href="job_a.jsp">작업페이지</a>	
		<%		
	}else{
		//로그인 실패
		%>
		아이디나 비밀번호를 확인해주세요.<br/>
			<a href="use_session.html">로그인</a>
		<% 
	}//end else
		%>
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
	</div>
</div>
</body>
</html>








