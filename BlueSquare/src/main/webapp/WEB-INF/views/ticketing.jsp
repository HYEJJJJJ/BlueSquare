<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/ticketing.css">
<title>BLUE SQUARE 공연 예매</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script type="text/javascript">

	$(document).on('click', '.scheduleN', function(){
		let sno = $(this).attr('value');
		$.ajax({
			url:"ticket/seatList?sno="+sno,
			type: "get",
			dataType: "html",
			success: function(html) {
				$("#seatList").html(html);
			}
		})
	});
	/* $(document).on('click', '.scheduleN', function(){
		let sno = $(this).attr('value');
		$.ajax({
			url:"ticket/seatListAjax?sno="+sno,
			type: "get",
			success: function(data) {
				let seat = "";
				$(data).each(function(){
					seat = seat + this + " ";
				});
				$('#seatList').html(seat);
			}
		})
	}); */
	$(document).on('click', '.performN', function(){
		let pno = $(this).attr('value');
		$.ajax({
			url:"ticket/scheduleListAjax?pno="+pno,
			type: "get",
			success: function(data) {
				let tag="<ul>";
				$(data).each(function(){
					tag = tag + "<li class='scheduleN' value='"+this.sno+"'>"+convertDate(this.timetable)+"</li>";
				});
				tag = tag + "</ul>";
				$('#scheduleList').html(tag);
			}
		})
	});
	$.ajax({
		url:"ticket/performListAjax",
		type: "get",
		success: function(data) {
			let tag="<ul>";
			$(data).each(function(){
				tag = tag + "<li class='performN' value='"+this.pno+"'><h4>"+this.title+"</h4></li>";
			});
			tag = tag + "</ul>";
			$('#performList').html(tag);
		}
	})

	function convertDate(ms) {
		const days = ['일', '월', '화', '수', '목', '금', '토'];
		const data = new Date(ms);  //Date객체 생성
		const year = data.getFullYear();    //0000년 가져오기
		const month = data.getMonth() + 1;  //월은 0부터 시작하니 +1하기
		const date = data.getDate();        //일자 가져오기
		const day = days[data.getDay()];  //요일 가져오기
		const hour = data.getHours();
		const minute = data.getMinutes();
		
		return year+"."+month+"."+date+" ("+day+") "+hour+" : "+minute;
	}
</script>
</head>
<body>
<div class="wrap">
	<header>
	<%-- <c:if test="${sessionScope.id == 'admin' }">
		<a href="<c:url value='/admin/home'/>">관리자 메뉴</a>
	</c:if> --%>
	<jsp:include page="header.jsp"></jsp:include>
	</header>
	
	<h3 align="center">예매하기</h3>
	<div id="ticketingBox">
		<div id="performListBox">
			<h3>공연 목록</h3>
			<div id="performList"></div>
		</div>
		<div id="scheduleListBox">
			<h3>공연 일정</h3>
			<div id="scheduleList"></div>
		</div>
		<div id="seatListBox">
			<h3>좌석 선택</h3>
			<div id="seatList"></div>
		</div>
	</div>
	</div>

</body>
</html>