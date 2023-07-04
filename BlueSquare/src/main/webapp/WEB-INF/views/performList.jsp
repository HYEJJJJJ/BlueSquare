<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	tbody {
	    display: block;
	    width: 320px;
	    border-collapse: collapse;
	    border: 2px solid #000;
	}
</style>
</head>
<body>
	<div id="container">
	<c:choose>
		<c:when test="${empty list}">
			<h2>예매 가능한 공연이 없습니다. 관리자에게 문의해주세요</h2>
		</c:when>
		<c:when test="${not empty list}">
		<table border="1">
			<caption>예매</caption>
			<thead>
				<tr>
					<th>공연 목록</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="performDto" items="${list}">
				<tr>
					<td>
						<a href="<c:url value='/ticket/scheduleList?pno=${performDto.pno}'/>">
							${performDto.title}
						</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>		
		</c:when>
	</c:choose>
	</div>
</body>
</html>