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

</head>
<%
	
	String country= request.getParameter("car_country");
	String maker= request.getParameter("car_maker");
	String model= request.getParameter("car_model");
	String selectFlag=request.getParameter("car_flag");// submit이 되는 <form>에서 어떤 Form Control이 이벤트를 발생
	//시켰는지 식별하기 위해서
	
	MyBatisService1 mbs= new MyBatisService1();
	
		
	if("1".equals(selectFlag)){ //제조국에서 이벤트가 발생 했을 때
		List<String> list= mbs.searchMaker(country); //제조국에 따른 제조사를 조회
		pageContext.setAttribute("makerList", list);
	}
	if("2".equals(selectFlag)){ //제조사에서 이벤트가 발생 했을 때
		List<String> list= mbs.searchMaker(country);
		pageContext.setAttribute("makerList", list);
		
		List<String> modelList= mbs.searchModel(maker);//제조사에 따른 모델명을 조회
		pageContext.setAttribute("modelList", modelList);
	}//end if
	if("3".equals(selectFlag)){ //제조사에서 이벤트가 발생 했을 때
		List<String> list= mbs.searchMaker(country);
		pageContext.setAttribute("makerList", list);
		
		List<String> modelList= mbs.searchModel(maker);//제조사에 따른 모델명을 조회
		pageContext.setAttribute("modelList", modelList);
		
		List<homeworkDomain> carList = mbs.homework(new homeworkVO(country,maker,model));
		pageContext.setAttribute("carList", carList);
		
	}//end if
		
%>

<script type="text/javascript">
$(function() {
	$("#car_country").change(function() {
		if($("#car_country").val()!="none"){
			$("#car_flag").val(1);
			$("#frm").submit();
		}//end if
	});//change
	$("#car_maker").change(function() {
		if($("#car_maker").val()!="none"){
			$("#car_flag").val(2);
			$("#frm").submit();
		}//end if
	});//change
	$("#car_model").change(function() {
		if($("#car_model").val()!="none"){
			$("#car_flag").val(3);
		}//end if
	});//change
	$("#btn").click(function() {
		if($("#car_flag").val()=="3"){
			$("#frm").submit();
		}
	})
});//ready
</script>

<form id="frm" action="main.jsp" method="get">
<input type="hidden" name="page" value="day0409/homework"/>
<input type="hidden" name="car_flag" id="car_flag"/>

<div style="padding: 30px">
제조국 
<select style="width: 150px" id="car_country" name="car_country" >
	<option value="none">==제조국==</option>
	<option value="국산"${param.car_country eq '국산'?"selected='selected'":"" }>국산</option>
	<option value="수입"${param.car_country eq '수입'?"selected='selected'":""}>수입</option>
</select>
제조사
<select style="width: 150px" id="car_maker" name="car_maker" >
	<option value="none">==제조사==</option>
	<c:if test="${not empty makerList }">
	<c:forEach var="maker" items="${makerList }">
	<option value="${maker }"${param.car_maker eq maker?"selected='selected'":"" }><c:out value="${maker }"/></option>
	</c:forEach>
	</c:if>
</select>
모델명
<select style="width: 150px"  id="car_model" name="car_model">
	<option value="none">==모델명==</option>
	<c:if test="${ not empty modelList }">
	<c:forEach var="model" items="${modelList }">
	<option value="${model }"${param.car_model eq model?"selected='selected'":"" }><c:out value="${model }"/></option>
	</c:forEach>
	</c:if>
</select>
<input type="button" value="조회" id="btn" class="btn"/><br/>
</div>
</form>
<div>
<c:if test="${param.car_flag eq '3'}">
	<table border="1">
		<tr>
		<th width="200">이미지</th>
		<th width="400">옵션</th>
		<th width="180">연식</th>
		</tr>
		<c:if test="${empty carList}">
		<tr>
			<td colspan="6" align="center">
					조회결과가 없습니다.
			</td>
		</tr>
		</c:if>
		
		<c:forEach var="car" items="${carList}">
		<tr>
			<td>
				<div>
				<img src="http://localhost:8080/mybatis_prj/day0409/images/${car.car_img }" width="63px">
				${car.model } /
				${car.maker }/
				${car.country }
				</div>
			</td>
			<td><c:out value="${car.car_option }"/></td>
			<td><c:out value="${car.cc }"/></td>
		</tr>
		</c:forEach>
	</table>
</c:if>
</div>