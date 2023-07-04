<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/mainStyle.css">
<title>BLUE SQUARE 공연 관리</title>
</head>
<body>
	<div class="wrap">
	<header>
	<jsp:include page="../header.jsp"></jsp:include>
	</header>
	<div class="mainContents">
		<h3>공연 관리</h3>
		<table>
			<thead>
				<tr>
					<th>공연 목록</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="performDto" items="${list}">
				<tr>
					<td>
						<a href="<c:url value='/admin/performManagementDetail?pno=${performDto.pno}'/>">
							${performDto.title}
						</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>