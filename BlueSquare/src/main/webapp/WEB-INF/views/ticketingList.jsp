<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BLUE SQUARE 티켓 예매 내역</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/mainStyle.css">
</head>
<body>
	<div class="wrap">
		<header>
		<jsp:include page="header.jsp"></jsp:include>
		</header>
		<div class="mainContents">
		<div class="content">
		<h3>티켓 예매 내역</h3>
		<c:choose>
			<c:when test="${empty list}">
				<h2>예매 내역이 없습니다</h2>
			</c:when>
			<c:when test="${not empty list}">
			<table>
				<tr><th>공연명</th><th>공연일자</th><th>공연시간</th><th>좌석</th><th>예매일자</th></tr>
				<c:forEach var="ticketingDto" items="${list }">
				<tr>
					<td><a href="<c:url value='/ticket/ticketingInfo?tno=${ticketingDto.tno}'/>">${ticketingDto.title }</a></td>
					<td><a href="<c:url value='/ticket/ticketingInfo?tno=${ticketingDto.tno}'/>"><fmt:formatDate value="${ticketingDto.timetable}" pattern="yy-MM-dd [E] a hh:mm:ss" type="both"/></a></td>
					<td>${ticketingDto.runtime }시간</td>
					<td>${ticketingDto.seat }번</td>
					<td><a href="<c:url value='/ticket/ticketingInfo?tno=${ticketingDto.tno}'/>"><fmt:formatDate value="${ticketingDto.tkt_date}" pattern="yy-MM-dd [E] a hh:mm:ss" type="both"/></a></td>
				</tr>
				</c:forEach>
			</table>			
			</c:when>
		</c:choose>
		</div>
		</div>
	</div>
</body>
</html>