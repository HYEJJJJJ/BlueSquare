<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/mainStyle.css">
    <title>BLUE SQUARE 전체 공연</title>
</head>
<body>
   <div class="wrap">
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<div class="mainContents">
     <h2 class="title"><!--공연 안내 제목-->
        <img src="<%=request.getContextPath() %>/resources/img/ttl_allperformance.gif" alt="전체 공연">
     </h2>
    
  <table>
  <thead>
    <tr>
     <th>포스터</th>
      <th colspan="3">상세정보</th>
    <!--   <th>배우</th>
      <th>공연일</th> -->
    </tr>
  </thead>
  <tbody>
    <c:forEach var="perform" items="${performList}">
      <tr>
      <td rowspan="5">
          <a href="${pageContext.request.contextPath}/perform/detail?pno=${perform.pno}">
            <img src="${pageContext.request.contextPath}${perform.url}" height="500px"  alt="Perform Image">
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
         <th>상세보기</th>
        <td>
        	<a href="${pageContext.request.contextPath}/perform/detail?pno=${perform.pno}"><button>상세보기</button></a>
       	</td>
       	</tr>
    </c:forEach>
  </tbody>
</table>
    
    
    </div>
   </div>
</body>
</html>
