<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/mainStyle.css">
<title>BLUE SQUARE 예매 상세 정보</title>
</head>
<body>
	<div class="wrap">
	<header>
	<jsp:include page="header.jsp"></jsp:include>
	</header>
	<div class="mainContents">
	<h3>예매 상세 정보</h3>
	
	<table>
	  <tr>
	    <th>공연 이름</th>
	    <td>${dto.title}</td>
	  </tr>
	  <tr>
	    <th>공연 일자</th>
	    <td><fmt:formatDate value="${dto.timetable}" pattern="yy-MM-dd [E] a hh:mm:ss" type="both"/></td>
	  </tr>
	  <tr>
	    <th>좌석</th>
	    <td>${dto.seat}번</td>
	  </tr>
	  <tr>
	    <th>런타임</th>
	    <td>${dto.runtime}시간</td>
	  </tr>
	  <tr>
	    <th>출연진</th>
	    <td>${dto.actors}</td>
	  </tr>
	  <tr>
	    <th>가격</th>
	    <td>${dto.price}원</td>
	  </tr>
	  <tr>
	    <th>예매일</th>
	    <td><fmt:formatDate value="${dto.tkt_date}" pattern="yy-MM-dd [E] a hh:mm:ss" type="both"/></td>
	  </tr>
	  <tr>
	  	<th>취소</th>
	  	<td><form action="<c:url value='/ticket/ticketCancle?tno=${dto.tno}'/>" method="post" onsubmit="return confirm('예매를 취소하시겠습니까?');">
			<button type="submit">예매 취소</button>
		</form></td>
	  </tr>
	</table>
	</div>
	</div>
</body>
</html>