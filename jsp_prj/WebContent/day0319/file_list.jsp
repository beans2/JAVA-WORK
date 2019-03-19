<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
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
		File uploadFolder=new File("C:/dev/workspace/jsp_prj/WebContent/upload");
		File[] listFile=uploadFolder.listFiles();
		File temp=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd a HH:mm");
	%>
	<a href="upload_form.jsp">업로드</a>
	<table border="1">
		<tr>
			<th width="60">번호</th>
			<th width="350">파일명</th>
			<th width="250">업로드일시</th>
			<th width="120">크기(byte)</th>
		</tr>
		<%
			if(listFile.length != 0){
				for(int i=0; i<listFile.length;i++){
					temp=listFile[i];
		%>
		<tr>
			<td><%=i+1 %></td>
			<td><a href="download.jsp?file_name=<%=temp.getName() %>"><%=temp.getName() %></a></td>
			<td><%=sdf.format(new Date(temp.lastModified())) %></td>
			<td><%=temp.length()%></td>
		</tr>
		<%
			}//end for
		}else{
			out.println("<tr><td colspan='4' align='center'>업로드 된 파일이 존재하지 않는다.</td></tr>");
		}
		%>	
	</table>
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
	</div>
</div>
</body>
</html>








