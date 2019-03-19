<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="파일업로드폼"
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
.btn {border: 1px solid #EDEDED;background-color: #FFFFFF;color: #1C1C1C;height: 22px;padding-left: 3px;padding-right: 3px;cursor : pointer;}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#btn").click(function() {
		if($("#uploader").val()==""){
			$("#uploader").focus();
			return;
		}
		if($("#upfile").val()==""){
			alert("업로드 할 파일을 선택해 주세요");
			return;
		}//end if
		
		//확장자가 jsp,java,class,xml은 업로드하지 못하도록 막는다. 
		if($("#upfile").val().substr($("#upfile").val().lastIndexOf(".")+1).toLowerCase()=="jsp"||
				$("#upfile").val().substr($("#upfile").val().lastIndexOf(".")+1).toLowerCase()=="java"||
				$("#upfile").val().substr($("#upfile").val().lastIndexOf(".")+1).toLowerCase()=="xml"||
				$("#upfile").val().substr($("#upfile").val().lastIndexOf(".")+1).toLowerCase()=="class"){
			alert("jsp,java,class,xml 파일은 올리지 못해요");
			return;
		}
		$("#uploadFrm").submit();
	});
});
</script>

</head>
<body>
<div id="wrap">
	<div id="header">
	<div id="headerTitle">SIST Class4 </div>
	</div>
	<div id="container">
		<!-- enctype="multipart/form-data"인경우 parameter을 받을 수 없다. -->
		<!-- HTML 폼기반의 파일업로드 
		1.enctype="multipart/form-data"
		2.method="post"
	-->
	<form action="upload_process.jsp" id="uploadFrm" method="post" enctype="multipart/form-data">
	<label>업로더</label>
	<input type="text" name="uploader" class="inputBox" id="uploader"><br/>
	<label>나이</label>
	<select name="age">
		<c:forEach var="i" begin="10" end="80" step="10">
		<option value="${ i }"><c:out value="${ i }대"/></option>		
		</c:forEach>
	</select>	
	<br/>
	<label>파일</label>
	<input type="file" name="upfile" class="inputBox" style="width: 200px" id="upfile"/><br/>
	<input type="button" value="업로드" class="btn" id="btn"/>
	</form>

	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
	</div>
</div>
</body>
</html>








