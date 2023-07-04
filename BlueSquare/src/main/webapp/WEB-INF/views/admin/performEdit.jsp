<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/mainStyle.css">
<title>BLUE SQUARE 공연 수정</title>
</head>
<body>
	<div class="wrap">
		<header>
		<jsp:include page="../header.jsp"></jsp:include>
		</header>
		<div class="mainContents">
		<h3>공연 수정</h3>
		<form action="performEdit" method="post">
		<input type="hidden" name="pno" value="${dto.pno }">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${dto.title }"></td>
			</tr>
			<tr>
				<th>출연배우</th>
				<td><input type="text" name="actors" value="${dto.actors }"></td>
			</tr>
			<tr>
				<th>공연시간</th>
				<td><input type="number" name="runtime" value="${dto.runtime }">(시간)</td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="number" name="price" value="${dto.price }">(원)</td>
			</tr>
			<tr>
				<th>시작일</th>
				<td><input type="date" name="startday" value="<fmt:formatDate value="${performDto.startday}" pattern="yyyy-MM-dd" type="date"/>"></td>
			</tr>
			<tr>
				<th>종료일</th>
				<td><input type="date" name="endday" value="<fmt:formatDate value="${performDto.endday}" pattern="yyyy-MM-dd" type="date"/>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="submit">등록하기</button></td>
			</tr>
		</table>

		</form>
		</div>
	</div>
</body>
</html>