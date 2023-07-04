<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/performManagementDetail.css">
<title>BLUE SQUARE 공연 관리</title>
</head>
<body>
	<div class="wrap">
		<header>
		<jsp:include page="../header.jsp"></jsp:include>
		</header>
	<div class="mainContents">
	<div id="detail" >
		<h3>공연 관리</h3>
			<table>
			  <tr>
			    <th>항목</th>
			    <th>내용</th>
			  </tr>
			  <tr>
			    <td>공연명</td>
			    <td>${performDto.title}</td>
			  </tr>
			  <tr>
			    <td>출연진</td>
			    <td>${performDto.actors}</td>
			  </tr>
			  <tr>
			    <td>런타임</td>
			    <td>${performDto.runtime}시간</td>
			  </tr>
			  <tr>
			    <td>시작일</td>
			    <td><fmt:formatDate value="${performDto.startday}" pattern="yyyy-MM-dd" type="date"/></td>
			  </tr>
			  <tr>
			    <td>종료일</td>
			    <td><fmt:formatDate value="${performDto.endday}" pattern="yyyy-MM-dd" type="date"/></td>
			  </tr>
			  <tr>
			    <td>가격</td>
			    <td><fmt:formatNumber value="${performDto.price}" type="currency"/></td>
			  </tr>
			  <tr>
			  	<td colspan="2">
					<div id="btnbox">
					<form action="<c:url value='/admin/performEditPage'/>" method="post">
					<input type="hidden" name="pno" value="${performDto.pno }">
					<input type="hidden" name="title" value="${performDto.title }">
					<input type="hidden" name="startday" value="<fmt:formatDate value="${performDto.startday}" pattern="yyyy-MM-dd" type="date"/>">
					<input type="hidden" name="endday" value="<fmt:formatDate value="${performDto.endday}" pattern="yyyy-MM-dd" type="date"/>">
					<input type="hidden" name="runtime" value="${performDto.runtime }">
					<input type="hidden" name="actors" value="${performDto.actors }">
					<input type="hidden" name="price" value="${performDto.price }">
						<button type="submit" id="editBtn" class="btn">공연 수정</button>
					</form>
					<form action="<c:url value='/admin/performDel'/>" method="post" onsubmit="return confirm('정말 삭제하시겠습니까?')">
						<input type="hidden" name="pno" value="${performDto.pno }">
						<button type="submit" id="delBtn" class="btn">공연 삭제</button>
					</form>
					</div>
			  	</td>
			  </tr>
			</table>

	</div>
	<h3>공연 일정</h3>
	<table>
	<tr>
		<th>일정목록</th>
	</tr>
	<c:forEach var="scheduleDto" items="${list}">
		<tr>
			<td>		
				<fmt:formatDate value="${scheduleDto.timetable}" pattern="yy-MM-dd [E] a hh:mm:ss" type="both"/>		
			</td>	
		</tr>
	</c:forEach>
	<tr>
		<th>새로운 일정 추가</th>
	</tr>
	<tr>
		<td>
			<form action="performScheReg" method="post">
				<input type="hidden" value="${pno}" name="pno">
				<input type="datetime-local" name="timetable" required>
				<input type="submit" class="submitBtn" value="등록">
			</form>
		</td>
	</tr>
</table>
	
	</div>
	</div>
</body>
</html>