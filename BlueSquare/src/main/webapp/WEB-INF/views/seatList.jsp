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
$(function(){
	${reserved}.forEach(function(i){
		$('#sp'+i).css({'background':'#777','border':'red'});
		$('#ip'+i).attr('disabled', true);
	});
});
</script>
<style>
	label {
		display: inline-block;
		padding: 5px;
		position: relative;
		padding-left: 20px;
	}
	
	label input {
		display: none;
	}
	
	label span {
		border: 1px solid skyblue;
		width: 15px;
		height: 15px;
		position: absolute;
		overflow: hidden;
		line-height: 1;
		text-align: center;
		border-radius: 5px;
		font-size: 10pt;
		left: 0;
		top: 50%;
		margin-top: -7.5px;
	}
	
	input:checked+span {
		background: #ccf;
		border-color: #ccf;
	}
</style>
</head>
<body>
	<form action="<c:url value='/ticket/ticketing'/>" method="post" onsubmit="return seatCheck()">
		<input type="hidden" name="sno" value="${param.sno}">
		<input type="hidden" name="id" value="${sessionScope.id}">
		<table>
			<c:set var="seatNum" value="1"/>
			<c:forEach var="i" begin="1" end="8">
				<tr>
					<c:forEach var="j" begin="1" end="10">
						<td><label><input type="radio" name="seat" value="${seatNum}" id="ip${seatNum}"><span id="sp${seatNum}">${seatNum}</span></label></td>
						<c:set var="seatNum" value="${seatNum + 1}"/>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="예매하기">
		<c:forEach var="i" items="${reserved}">
			<h6>${i}</h6>
		</c:forEach>
	</form>
	<script>
	function seatCheck() {
	    var selected = false;
	    var radios = document.getElementsByName('seat');
	    for (var radio of radios)
	    {
	        if (radio.type === 'radio' && radio.checked)
	        {
	            selected = true;
	        }
	    }
	 
	    if (!selected) {
	        alert('좌석을 선택해주세요');
	    }
	    return selected;
	}
	</script>
</body>
</html>