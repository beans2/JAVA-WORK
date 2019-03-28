<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
	String[] name_arr={"김정윤","김희철","박영민","노진경"};
	int[] age_arr ={30,28,27,31};
	JSONArray json_arr= new JSONArray();
	
	JSONObject json_obj=null;
	for(int i=0;i<name_arr.length;i++){
		//배열이 존재한다면 JSONObject생성
		json_obj = new JSONObject();
		json_obj.put("name", name_arr[i]);
		json_obj.put("agew", age_arr[i]);
		//생성된 JSONObject을 JSONArray 추가
		json_arr.add(json_obj);
	}//end for
	out.println(json_arr.toJSONString());
%>
<%-- [

<%
	for(int i=0; i<name_arr.length;i++){
	%>
	{ "name":"<%= name_arr[i] %>", "age":<%=age_arr[i]%> } 
	<%
		if( i<name_arr.length-1){
			%>
			,
			<%
		}
	}//end for
%>
] --%>







