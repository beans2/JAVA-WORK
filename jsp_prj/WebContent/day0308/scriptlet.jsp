<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="scriptlet 연습"%>
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
td:hover{background: #FF0000}
td{cursor:pointer}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	function test(value) {
		alert(value);
	}
	$(function(){
	var d = new Date();
	var time="";
	time+=d.getFullYear()+"-"+d.getMonth()+"-"+d.getDate()+" "+d.getHours()+":"
		+d.getMinutes()+":"+d.getSeconds();
	
	$("#c_time").text(time);
	});
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
	<div id="headerTitle">SIST Class4 </div>
	</div>
	<div id="container">

	<%
	//scriptlet은 _jspService method내에 코드가 생성된다.
		int i=3;//지역변수 : 자동 초기화가 되지 않는다.
		
	%>
	<%=i %>
	<%	for(int j=1;j<7;j++){	%>
		<h<%=j %>>오늘은 불금입니다.</h<%=j %>>
	<% }//end for	%>
	<%
		String[] names={"노진경","김정윤","박영민","김희철","박소영","이지수"};
	%>
	<table border="1">
	<tr>
		<th width="100">이름</th>
	</tr>
	<% for(int j=0;j<names.length;j++){ %>
	<tr>
		<td><%=names[j] %></td>
	</tr>
	<% }//end for %>
	</table>
	
	<!-- 1~100까지 합만 출력 -->
	<% 
		int sum=0;
		 for(int k=0;k<101;k++){ 
		sum+=k;
		 } 
	%>
	<div>1에서 100까지 합은 <%=sum %> 입니다</div>
	
	<div>
		<!-- 구구단 3단 출력 -->
		<table border="1">
		<% for(int k=1;k<10;k++){%>
			<tr>
			<td>3*<%=k %>=<%=3*k %></td>
			</tr>
		<%} %>
		</table>
		
		<table border="1">
			<tr>
			<% for(int k=1;k<10;k++){%>
			<td>3*<%=k %>=<%=3*k %></td>
			<%} %>
			</tr>
		</table>
	</div>
	
	<div>
		<table border="1">
			<% for(int k=1;k<10;k++){ %>
			<tr>
				<% for(int j=1;j<10;j++) {%>
				<td onclick="test('<%=k*j %>')" ><%=k %>    *    <%=j %></td>
				<% } %>
			</tr>
			<% } %>
		</table>
	</div>
	
	<!-- 년-월-일 요일 시:분을 서버의 시간으로 얻어와서 흘러가는 문자열로 보여주세요. -->
	<!-- 버튼을 클릭하면 해당 일자가 3초동안 서서히 사라지도록 만들것 -->
	<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE hh:mm:ss");
	String date = sdf.format(new Date());
	%>	
	<div>
		서버 시간: <span id="s_time"><%=date %></span>	
		접속자 시간: <span id="c_time"></span>
	</div>
	
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
	</div>
</div>
</body>
</html>








