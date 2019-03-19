<%@page import="javax.naming.SizeLimitExceededException"%>
<%@page import="kr.co.sist.util.HangulConv"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
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
	<%-- 이름: <%=request.getParameter("uploader") %><br/>
	나이: <%=request.getParameter("age") %><br/> --%>
	<%
	//파일업로드에 적합한 요청인지를 얻는다.
	request.setCharacterEncoding("UTF-8");
	boolean isMultipart= ServletFileUpload.isMultipartContent(request);
	if(isMultipart){ //파일업로드에 부적합한 요청
		File repository = new File("C:/dev/workspace/jsp_prj/WebContent/upload");
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
	
		// 업로드 파일이 메모리에 저장되는 최대 크기
		factory.setSizeThreshold(1024*1024*1);
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 업로드 파일의 최대 크기를 설정
		upload.setSizeMax(1024*1024*5);
		
		try{
		// Parse the request
		List<FileItem> items = upload.parseRequest(request);		
		
		// Process the uploaded items
		Iterator<FileItem> iter = items.iterator();
		String uploader="",age="",fieldName="", fileName="", contentType="";
		long sizeInBytes=0;
		while (iter.hasNext()) {
		    FileItem item = iter.next();
		    if (item.isFormField()) { //일반 HTML Form Control인지? <input type="file"이 아닌것
		    	String controlName = item.getFieldName();
		    	String controlValue = HangulConv.toUTF(item.getString());
		    	//out.println(controlName+"  //  "+controlValue);
		    	if("uploader".equals(controlName)){
		    		uploader=controlValue;
		    	}else if("age".equals(controlName)){
		    		age=controlValue;
		    	}
		    } else { //File Upload Control인지 <input type="file">
		    	 fieldName = item.getFieldName();//File Control명
		    	 fileName = item.getName(); //File명
		    	 contentType = item.getContentType();//업로드 File의 종류
		    	 sizeInBytes = item.getSize();//크기
		    	 
		    	 File selectFile=new File(fileName);
		    	 File uploadedFile = new File(repository.getAbsolutePath()+"/"+selectFile.getName());//업로드 파일의 저장경로와 파일명을 설정
		    	 item.write(uploadedFile);//설정된 파일을 업로드
		    }//end else
		}//end while
		%>
		파일업로드 성공<br/>
		업로더명: <%=uploader%><br/>
		연령대:<%=age %><br/>
		업로드 파일명: <%=fileName %><br/>
		크기:<%=sizeInBytes%>byte<br/>
		<a href="upload_form.jsp">업로드</a>
		<a href="file_list.jsp">파일리스트</a>
		<%
		}catch(SizeLimitExceededException slee){
			//브라우저로 출력이 되지 않는다.
			out.println("예외!!!");
		}
	}else{//파일업로드에 부적합 요청
		response.sendRedirect("upload_form.jsp");
	}
	%>
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
	</div>
</div>
</body>
</html>








