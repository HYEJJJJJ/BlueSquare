<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/mainStyle.css">
<title>BLUE SQUARE 관리자메뉴</title>
<style>
	td {
		text-align: center;
		text-weight: bold;
	}
</style>
</head>
<body>
	<div class="wrap" >
		<jsp:include page="../header.jsp"></jsp:include>
		<div class="mainContents">
		<h3>관리자 메뉴</h3>
		<table>
		  <tr>
		    <td><a href="<c:url value='/admin/performManagement'/>">공연 관리</a></td>
		  </tr>
		  <tr>
		    <td><a href="<c:url value='/admin/performReg'/>">새 공연 등록</a></td>
		  </tr>
		  <tr>
		    <td><a href="<c:url value='/notice/list'/>">공지사항 바로가기</a></td>
		  </tr>
		</table>
		</div>	
	</div>
</body>
</html>