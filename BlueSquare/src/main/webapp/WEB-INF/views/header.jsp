<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BLUE SQUARE</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/header.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
</head>
<body>
	<div class="header">
	    <div class="logo">
	        <a href="<c:url value='/'/>"><h1><img src="<%=request.getContextPath() %>/resources/img/bluesquare.gif" alt="BLUE SQUARE"></h1></a>
	    </div>
	    <div class="user">
	    <c:choose>
	    <c:when test="${sessionScope.id == null}">
	    	<ul>
	    		<li><a href="<c:url value='/login/login'/>">로그인</a></li>
	    		<li><a href="<c:url value='/sign/add'/>">회원가입</a></li>
	    	</ul>	    	    
	    </c:when>
	    <c:when test="${sessionScope.id != null}">
	    	<ul>
				<c:choose>
				<c:when test="${sessionScope.id == 'admin'}">
				<li><a href="<c:url value='/admin/home'/>">관리자 메뉴</a></li>
				</c:when>
				<c:otherwise>
	    		<li>${sessionScope.id}님, 환영합니다!</li>
				</c:otherwise>
				</c:choose>	
	    		<li><a href="<c:url value='/login/logout'/>">로그아웃</a></li>
	    	</ul>
	    </c:when>
	    </c:choose>
	    </div>
	    <div class="menu">
	        <ul>
	            <li>
	                <h3>블루스퀘어</h3>
	                <ul>
	                <li><a href="<c:url value='/introduce'/>">소개</a></li>
	                <li><a href="<c:url value='/convenience'/>">편의시설</a></li>
	                <li><a href="<c:url value='/seatInfo'/>">좌석배치도</a></li>
	                <li><a href="<c:url value='/guideMap'/>">오시는 길</a></li>  
	                </ul>
	            </li>
	            <li>
	               <h3>공연 안내</h3>
	                <ul>
	                    <li><a href="<c:url value='/perform/all'/>">전체공연</a></li>
	                    <li><a href="<c:url value='/ticketing'/>">티켓예매</a></li>
	                    <li><a href="<c:url value='/board/list'/>">공연후기</a></li>
	                </ul>
	            </li>
	            <li>
	                <h3>대관 안내</h3>
	                <ul>
	                    <li><a href="<c:url value='/rental'/>">대관시설</a></li>
	                    <li><a href="<c:url value='/rentalP'/>">대관료</a></li>
	                   <!--  <li><a href="">대관신청</a></li> -->
	                </ul>
	            </li>
	            <li>
	                <h3>고객센터</h3>
	                <ul>
	                    <li><a href="<c:url value='/notice/list'/>">공지사항</a></li>
	                    <li><a href="<c:url value='/qna'/>">FAQ</a></li>
	                </ul>
	            </li>
	        </ul>
	    </div>
	</div>
</body>
</html>