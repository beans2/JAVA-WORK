<%@page import="java.sql.SQLException"%>
<%@page import="java.util.Arrays"%>
<%@page import="kr.co.sist.diary.vo.MonthVO"%>
<%@page import="kr.co.sist.diary.dao.DiaryDAO"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"  href="http://localhost:8080/jsp_prj/common/css/main_v190130.css">
<style type="text/css">
#wrap{ margin:0px auto; width:800px; height:860px; }
#header{  width:800px; height:140px; background: #FFFFFF url(http://localhost:8080/jsp_prj/common/images/header_bg.png) repeat-x;
			position: relative;	}
#headerTitle{ font-family: HT견고딕,고딕; font-size: 30px; font-weight: bold;text-align: center;
				position:absolute; top: 40px;left: 290px; }
#container{  width:800px; height:600px; }
#footer{  width:800px; height:120px; }
#footerTitle{ float: right;font-size: 15px; padding-top: 20px; padding-right: 20px }
/* 달력 설정  */
#diaryTab{ margin: 0px auto; border-spacing: 0px; border: 1px solid #cecece }
#diaryContent{ position: relative;}
#diaryJob{ position: absolute; top: 50px;left: 160px }
.sunTitle{width:100px;height: 25px;border: 1px solid #CECECE;
				font-weight: bold; color: #FFFFFF;background-color: #DC2E38; text-align: center }
.weekTitle{width:100px;height: 25px;border: 1px solid #CECECE; text-align: center}
.satTitle{width:100px;height: 25px;border: 1px solid #CECECE;
			font-weight: bold; color: #FFFFFF;background-color: #618FFC; text-align: center}
#diaryTitle{ text-align: center;margin-bottom: 10px;margin-top: 20px }
#diaryToday{ width: 100px; font-family: 고딕체; font-size: 24px; font-weight: bold; 
			vertical-align: bottom;}
.diaryTd{width: 100px; height: 60px; border: 1px solid #CECECE;
			text-align: right; vertical-align: top; font-size: 14px;font-weight: bold}
			
.blankTd{width: 100px; height: 60px; border: 1px solid #CECECE;
			text-align: right; vertical-align: top; font-size: 14px;font-weight: bold;
			color: #CCCCCC}
.sunColor{font-size: 15px;color:#DC2E38 }			
.weekColor{color:#222222}			
.satColor{font-size: 15px;color:#618FFC }			
#ohNulColor{width: 100px; height: 60px; border: 1px solid #CECECE; 
			background-color:#FFFFD9; 
			text-align: right; vertical-align: top; font-size: 14px;font-weight: bold}
#writeFrm{ background-color:#FFFFFF;border:1px solid #333333;
			box-shadow:5px 5px 5px #444444;
			padding: 10px  }


/* 달력 설정 끝 */
</style>
<!-- summernote 관련 library 시작 -->
<!-- include libraries(jQuery, bootstrap) -->
<link href="../common/summernote/bootstrap.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="../common/summernote/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="../common/summernote/summernote-lite.css" rel="stylesheet">
<script src="../common/summernote/summernote-lite.min.js"></script>
<script src="../common/summernote/lang/summernote-ko-KR.js"></script>
<script type="text/javascript">
	$(function() {
	  $('#summernote').summernote({
	        placeholder: '이벤트를 작성해 주세요.',
	        tabsize: 2,
	        height: 150,
	        width: 390,
	        lang: 'ko-KR'
	      });
	});//ready
	
	function writeEvt(year,month,day,pageFlag,evtCnt){
		if(evtCnt>4){
			alert("하루에 작성 가능한 이벤트 수는 5건까지 입니다.");
			return;
		}
		$("[name='param_year']").val(year);
		$("[name='param_month']").val(month);
		$("[name='param_day']").val(day);
		$("[name='pageFlag']").val(pageFlag);
		$("[name='diaryFrm']").submit();
	}//writeEvt
	
</script>

<script type="text/javascript">
	$(function() {
		$("#btnCloseFrm").click(function() {
			moveMonth("${param.param_month}","${param.param_year}");
		});
		$("#btnCloseClose").click(function() {
			moveMonth("${param.param_month}","${param.param_year}");
		});
		//글작성
		$("#btnWrite").click(function() {
			if($("#subject").val()==""){
				alert("이벤트 제목은 필수입력!!!")
				$("#subject").focus();
				return;
			}
			if($("#summernote").val()==""){
				alert("이벤트 내용은 필수입력!!!")
				$("#summernote").focus();
				return;
			}
			if($("#writer").val()==""){
				alert("작성자는 필수입력!!!")
				$("#writer").focus();
				return;
			}
			if($("#pass").val()==""){
				alert("비밀번호는 필수입력!!!")
				$("#pass").focus();
				return;
			}
			
			$("[name='writeFrm']").submit();
			
		})
	});//ready
	
</script>


<!-- summernote 관련 library 끝 -->

<!-- Tooltip시작 -->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="../common/js/jquery-ui.js"></script>
  <script>
  $( function() {
    $( document ).tooltip1({
      position: {
        my: "center bottom-20",
        at: "center top",
        using: function( position, feedback ) {
          $( this ).css( position );
          $( "<div>" )
            .addClass( "arrow" )
            .addClass( feedback.vertical )
            .addClass( feedback.horizontal )
            .appendTo( this );
        }
      }
    });
  } );
  </script>
  <style>
  .ui-tooltip, .arrow:after {
    background: black;
    border: 2px solid white;
  }
  .ui-tooltip {
    padding: 10px 20px;
    color: white;
    border-radius: 20px;
    font: bold 14px "Helvetica Neue", Sans-Serif;
    text-transform: uppercase;
    box-shadow: 0 0 7px black;
  }
  .arrow {
    width: 70px;
    height: 16px;
    overflow: hidden;
    position: absolute;
    left: 50%;
    margin-left: -35px;
    bottom: -16px;
  }
  .arrow.top {
    top: -16px;
    bottom: auto;
  }
  .arrow.left {
    left: 20%;
  }
  .arrow:after {
    content: "";
    position: absolute;
    left: 20px;
    top: -20px;
    width: 25px;
    height: 25px;
    box-shadow: 6px 5px 9px -9px black;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
  }
  .arrow.top:after {
    bottom: -20px;
    top: auto;
  }
  </style>
  
<script type="text/javascript">
	function moveMonth(month, year) {
		//location.href="diary.jsp?param_year="+year+"&param_month="+month;
		//var obj= document.diaryFrm;
		//obj.param_month.value= month;
		//obj.param_year.value= year;
		//obj.submit();
		$("[name='param_year']").val(year);
		$("[name='param_month']").val(month);
		$("[name='diaryFrm']").submit();
		
	}//moveMonth
</script>


</head>
<body>
<div id="wrap">
	<div id="header">
	<div id="headerTitle">SIST Class4 </div>
	</div>
	<div id="container">
	<div id="diaryWrap">
	<%!
		public static final int START_DAY=1;
	%>
	<%
		Calendar cal= Calendar.getInstance();
		int nowYear= cal.get(Calendar.YEAR);
		int nowMonth=0;
		int nowDay=0;
		int ohNulDay=cal.get(Calendar.DAY_OF_MONTH);
		int ohNulMonth=cal.get(Calendar.MONTH)+1;
		int ohNulYear=cal.get(Calendar.YEAR);
		
		String param_month = request.getParameter("param_month");
		cal.set(Calendar.DAY_OF_MONTH, 1); //요청했을 때 해당 달에  없는 일이 존재한다면 다음달 1일로 설정되기 떄문에 
		//모든 달에 존재하는 날짜로 일을 설정한다.
		if(param_month!=null && !"".equals(param_month)){//파라메터 월이 존재하면 현재 캘린더 객체의 월을 변경
			cal.set(Calendar.MONTH, Integer.parseInt(param_month)-1);
		}//end if
		nowMonth= cal.get(Calendar.MONTH)+1;
		
		String param_year = request.getParameter("param_year");
		if(param_year!=null && !"".equals(param_month)){
			cal.set(Calendar.YEAR, Integer.parseInt(param_year));
		}//end if
		nowYear= cal.get(Calendar.YEAR);
		
		pageContext.setAttribute("nowYear", nowYear);
		pageContext.setAttribute("nowMonth", nowMonth);
		pageContext.setAttribute("nowDay", nowDay);
	%>
	<form action="diary.jsp" name="diaryFrm" method="post">
		<input type="hidden" name="param_month"/>
		<input type="hidden" name="param_year"/>
		<input type="hidden" name="param_day"/>
		<input type="hidden" name="pageFlag"/>
	</form>
	
	<div id="diaryTitle">
		<a href="#void" onclick="moveMonth(${nowMonth-1==0?12:nowMonth-1},${nowMonth-1==0?nowYear-1:nowYear })"><img src="images/btn_prev.png" title="이전 월"/></a>
		<span id="diaryToday" title="${nowYear}년 ${nowMonth}월"><c:out value="${nowYear}"/>.<c:out value="${nowMonth}"/></span>
		<a href="#void" onclick="moveMonth(${nowMonth+1==13?1:nowMonth+1},${nowMonth+1==13?nowYear+1:nowYear })"><img src="images/btn_next.png" title="다음 월"/></a>
		<a href="#void" onclick="moveMonth('','')"><img src="images/btn_today.png" title="오늘"/></a>
	</div>
	<div id="diaryContent">
	<table id="diaryTab">
	<tr>
		<th class="sunTitle">일</th>
		<th class="weekTitle">월</th>
		<th class="weekTitle">화</th>
		<th class="weekTitle">수</th>
		<th class="weekTitle">목</th>
		<th class="weekTitle">금</th>
		<th class="satTitle">토</th>
	</tr>
	<tr>
		<%
		String dayClass="";
		String todayCss="";
		
		//요청되는 년,월의 모든 이벤트를 조회
		DiaryDAO d_dao= DiaryDAO.getInstance();
		try{
		MonthVO[][] monthEvtData= d_dao.selectMonthEvent(String.valueOf(nowYear),String.valueOf(nowMonth));
		
		MonthVO[] dayEvt= null;//해당 일에 글이 존재한다면 저장할 배열		
		String tempSubject=""; //20장 이상인 글을 잘라...을 붙이기 위해
		int evtCnt=0;//이벤트 건수를 제한하기 위해
		
		int cntStart=-1;
		int cntEnd=0;
		for(int tempDay=1; ;tempDay++){
			cal.set(Calendar.DAY_OF_MONTH, tempDay);
			if(cal.get(Calendar.DAY_OF_MONTH)!=tempDay){
				if(cal.get(Calendar.DAY_OF_WEEK)!=1){ //문제 2번
					for(int j=cal.get(Calendar.DAY_OF_WEEK); j<8;j++){
						cntEnd++;
						if(nowMonth!=12){
							out.println("<td class='blankTd'>"+(nowMonth+1)+"/"+cntEnd+"</td>");
						}else{
							out.println("<td class='blankTd'>"+(nowMonth-11)+"/"+cntEnd+"</td>");
						}
					}
				}
				break;
			}
		%>
		<%
		
		//시작까지 공백을 넣어주기
			switch(tempDay){
			case START_DAY:
				Calendar cal2= Calendar.getInstance();
				cal2.set(Calendar.MONTH, nowMonth-2);
				cal2.set(Calendar.YEAR, nowYear);
				for(int blankTd=1;blankTd<cal.get(Calendar.DAY_OF_WEEK);blankTd++){
					cntStart++;
				}
				for(int blankTd=1;blankTd<cal.get(Calendar.DAY_OF_WEEK);blankTd++){
					if((nowMonth-1)!=0){
						out.println("<td class='blankTd'>"+(nowMonth-1)+"/"+(cal2.getActualMaximum(Calendar.DAY_OF_MONTH)-cntStart)+"</td>");
					}else{
						out.println("<td class='blankTd'>"+(nowMonth+11)+"/"+(cal2.getActualMaximum(Calendar.DAY_OF_MONTH)-cntStart)+"</td>");
					}
					cntStart--;
				}
			}
		
			//요일별 색 설정
			switch(cal.get(Calendar.DAY_OF_WEEK)){
			case Calendar.SUNDAY:
				dayClass="sunColor";
				break;
			case Calendar.SATURDAY:
				dayClass="satColor";
				break;
			default:
				dayClass="weekColor";
			}
			pageContext.setAttribute("dayClass", dayClass);
			
			if((cal.get(Calendar.DAY_OF_MONTH)==ohNulDay)&&((cal.get(Calendar.MONTH)+1)==ohNulMonth)&&(cal.get(Calendar.YEAR)==ohNulYear)){
				todayCss = "ohNulColor";//1번
			}
		%>
			<td class="diaryTd" id=<%=todayCss %>>
				<%
				dayEvt = monthEvtData[tempDay-1];
				evtCnt=0;
				if(dayEvt!=null){
					evtCnt=dayEvt.length;
				}
			
				%>
			<div>
				<a href="#void" onclick="writeEvt(${nowYear},${nowMonth},<%=tempDay%>,'write_form',<%= evtCnt %>)"><span class="${dayClass}" >
				<%=tempDay %></span></a></div>
				<div>
				<%if(dayEvt!=null){ 
					for(int i=0;i<dayEvt.length;i++){
						tempSubject=dayEvt[i].getSubject();
						if(tempSubject.length() > 21){
							tempSubject=tempSubject.substring(0,20)+"...";
						}
				%>
					<img src="images/evtflag.png" title="<%= tempSubject%>"/>
				<%
					}//end for
				}//end if
				%>
				</div>
			</td>
		<%
		todayCss="";
		//토요일이면 줄바꿈
		switch(cal.get(Calendar.DAY_OF_WEEK)){
        case Calendar.SATURDAY:
            out.println("</tr><tr>");
		}//end switch
	}//end for
	}catch(SQLException se){
		se.printStackTrace();
		%>
		<tr>
			<td colspan="7" style="text-align: center;height: 400px">
			<img src="images/construction.jpg" title="뎨둉합니다.T^T"/>
			</td>
		</tr>	
		<%
	}
	%>
	</tr>
	</table>
	<div id="diaryJob">
		<c:if test="${ not empty param.pageFlag}">
		<c:import url="${param.pageFlag}.jsp"/>
		</c:if>
	</div>
	
	</div>
	</div>
	</div>
	<div id="footer">
		<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
	</div>
	
</div>
</body>
</html>








