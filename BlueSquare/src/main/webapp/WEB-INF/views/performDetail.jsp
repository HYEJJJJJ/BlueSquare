<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<html>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/mainStyle.css">
    <title>BLUE SQUARE 공연 상세 정보</title>
</head>
<body>
<div class="wrap">
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<div class="mainContents">
    <h3>공연 상세 정보</h3>
	<table>
  <tbody>
    <c:forEach var="perform" items="${performList}">
     <c:if test="${pno eq perform.pno}">
      <tr>
	      <th>포스터</th>
	      <td class="posterImg">
	          <a href="${pageContext.request.contextPath}/perform/detail?pno=${perform.pno}">
	          <img src="${pageContext.request.contextPath}${perform.url}" width="700px" alt="Perform Image">
	          </a>
	       </td>
       </tr>
       <tr>
	       <th>제목</th>
	       <td>${perform.title}</td>
       </tr>
       <tr>
	       <th>배우</th>
	       <td>${perform.actors}</td>
       </tr>
       <tr>
	       <th>공연일</th>
	       <td>
		       <fmt:formatDate value="${perform.startday}" pattern="yyyy-MM-dd" type="date"/>~
	       		<fmt:formatDate value="${perform.endday}" pattern="yyyy-MM-dd" type="date"/> 
       		</td>
       </tr>
       <tr>
	       <th>공연시간</th>
	       <td>${perform.runtime}시간</td>
       </tr>
        <tr>
	       <th>가격</th>
	       <td>${perform.price}원</td>
       </tr>
       <tr>
	       <th>예매</th>
	       <td> <a href="${pageContext.request.contextPath}/ticketing"/><button>예매하기</button></td>
       </tr>
       <hr>
      </c:if>
    </c:forEach>
  </tbody>
</table>
	
	</div>
</div>
</body>
</html>
