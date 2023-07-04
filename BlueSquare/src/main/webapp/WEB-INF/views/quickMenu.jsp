<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
<style>
	.quick{
	    z-index: 9999; */
	    /* background-color: skyblue; */
	    /* height: 300px; */
	    /* width: 1200px; */
	    display: flex;
	    justify-content: flex-end;
	    position: fixed;
	    right: 100px;
	    bottom: 80px;
	}

	p {font-size: 13px;
		font-weight:bold;
	} 
</style>
</head>
<body>
	<div class="quick">
	    <ul> 
	    	<li><p>빠른메뉴</p></li>
	        <li><a href="<c:url value='/ticketing'/>"><img src="<%=request.getContextPath() %>/resources/img/q_ticket1.png" alt=""></a></li>
	        <li><a href="<c:url value='/perform/all'/>"><img src="<%=request.getContextPath() %>/resources/img/q_perform.png" alt=""></a></li>
	        <li><a href="<c:url value='/seatInfo'/>"><img src="<%=request.getContextPath() %>/resources/img/q_seat.png" alt=""></a></li>
	        <li><a href="<c:url value='/guideMap'/>"><img src="<%=request.getContextPath() %>/resources/img/q_map.png" alt=""></a></li>
	        <li><a href="<c:url value='/ticket/ticketingList'/>"><img src="<%=request.getContextPath() %>/resources/img/q_ticket2.png" alt=""></a></li>
	    </ul>
	</div>
</body>
</html>