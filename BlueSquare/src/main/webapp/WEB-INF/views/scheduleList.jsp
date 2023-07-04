<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>일정 목록</h1>
	<c:choose>
		<c:when test="${empty list}">
			<h2>공연 일정이 없습니다.</h2>
		</c:when>
		<c:when test="${not empty list}">
		<ul>
		<c:forEach var="scheduleDto" items="${list}">
			<li>
				<a href="<c:url value='/ticket/seatList?sno=${scheduleDto.sno}'/>">
				<fmt:formatDate value="${scheduleDto.timetable}" pattern="yy-MM-dd [E] a hh:mm:ss" type="both"/>
				</a>
			</li>	
		</c:forEach>
		</ul>
		</c:when>
	</c:choose>
</body>
</html>