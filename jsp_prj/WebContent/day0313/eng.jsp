<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<%
		//form Control로 생성된 값.
		String name= request.getParameter("name");
		String age= request.getParameter("age");
		String addr= request.getParameter("address");
		//<jsp:param으로 생성된 값.
		String lang= request.getParameter("lang");
		String date= request.getParameter("date");
		
	%>
	<strong>Hello. It's English Page</strong>
	<strong>Your input values are under the contents</strong>
	<ul>
		<li>name: <strong><%=name %></strong></li>
		<li>age: <strong><%=age %></strong></li>
		<li>address: <strong><%=addr %></strong></li>
		<li>Language: <strong><%=lang %></strong></li>
		<li>Access Time: <strong><%=date %></strong></li>
		<li>Select location
		<select>
			<%String[] loc = (String[])request.getAttribute("loc");
				for(int i=0; i<loc.length;i++){
			%>
			<option value="<%=loc[i]%>"><%=loc[i] %></option>			
			<%	
				}
			%>
		</select>
		</li>
	</ul>	
	<a href="forward_a.jsp">Go back</a>
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
	</div>
</div>
</body>
</html>








