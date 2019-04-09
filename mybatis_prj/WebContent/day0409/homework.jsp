<%@page import="kr.co.sist.exam.vo.homeworkVO"%>
<%@page import="kr.co.sist.exam.domain.homeworkDomain"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.sist.exam.service.MyBatisService1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

function countryChange(){
	var korMaker = ["현대","삼성"];
	var gerMaker = ["BMW"];
	var selectItem = $("#country").val();
	 alert(selectItem);
	var changeItem;
	if(selectItem == "국산"){
	  changeItem = korMaker;
	}
	else(selectItem == "수입"){
	  changeItem = gerMaker;
	}
	$('#maker').empty();
	for(var count = 0; count < changeItem.size(); count++){                
	                var option = $("<option>"+changeItem[count]+"</option>");
	                $('#maker').append(option);
	}
}
function makerChange(){
	var hyeondai = ["그랜저","소나타"];
	var samsung = ["SM7","SM5"];
	var bmw = ["Eclass","Cclass"];
	var selectItem = $("#maker").val();
	var changeItem;
	if(selectItem == "현대"){
	  changeItem = hyeondai;
	}
	else if(selectItem == "삼성"){
	  changeItem = samsung;
	}
	else if(selectItem == "BMW"){
	  changeItem = bmw;
	}
	$('#model').empty();
	alert(changeItem.size);
	for(var count = 0; count < changeItem.size; count++){
	                var option = $("<option>"+changeItem[count]+"</option>");
	                $('#model').append(option);
	}
}
</script>

</head>
<%
	MyBatisService1 mbs= new MyBatisService1();
	
	String country= request.getParameter("country");
	String maker= request.getParameter("maker");
	String model= request.getParameter("model");
	
	if(country!=null){
		List<homeworkDomain> list= mbs.homework(new homeworkVO(country,maker,model));
		pageContext.setAttribute("empList", list);
	}//end if
%>


<form name="frm" action="main.jsp">
<input type="hidden" name="page" value="day0409/homework"/>
<div style="padding: 30px">
제조국 
<select style="width: 150px" id="country" name="country" onchange="countryChange()">
	<option >국산</option>
	<option >수입</option>
</select>
제조사
<select style="width: 150px" id="maker" name="maker" onchange="makerChange()">
	<option >기아</option>
</select>
모델명
<select style="width: 150px"  id="model" name="model">
	<option >K5</option>
</select>
<input type="submit" value="조회" class="btn"/><br/>
</div>
</form>
<div>
<c:if test="${not empty param.country}">
	<table border="1">
		<tr>
		<th width="200">이미지</th>
		<th width="400">옵션</th>
		<th width="180">연식</th>
		</tr>
		
		<c:if test="${empty empList}">
		<tr>
			<td colspan="6" align="center">
					조회결과가 없습니다.
			</td>
		</tr>
		</c:if>
		
		<c:forEach var="emp" items="${empList}">
		<tr>
			<td><img src="http://localhost:8080/mybatis_prj/day0409/images/${emp.car_img }"></td>
			<td><c:out value="${emp.car_option }"/></td>
			<td><c:out value="${emp.cc }"/></td>
		</tr>
		</c:forEach>
	</table>
</c:if>
</div>