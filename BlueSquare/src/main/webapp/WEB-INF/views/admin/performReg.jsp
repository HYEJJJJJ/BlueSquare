<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/mainStyle.css">
<title>BLUE SQUARE 공연 등록</title>
</head>
<body>
	<div class="wrap">
	<header>
	<jsp:include page="../header.jsp"></jsp:include>
	</header>
	 <div class="mainContents">
	<h3>공연 등록</h3>
	<form action="performReg" method="post" enctype="multipart/form-data">
		<table>
		<tr>
			<th>제목</th>
			<td><input type="text" class="tb" name="title" required></td>
		</tr>
		<tr>
			<th>출연배우</th>
			<td><input type="text" class="tb" name="actors" required></td>
		</tr>
		<tr>
			<th>공연시간</th>
			<td><input type="number" class="tb" name="runtime" required>(시간)</td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="number" class="tb" name="price" required>(원)</td>
		</tr>
		<tr>
			<th>시작일</th>
			<td><input type="date" class="tb" name="startday" required></td>
		</tr>
		<tr>
			<th>종료일</th>
			<td><input type="date" class="tb" name="endday" required></td>
		</tr>
		<tr>
			<th>포스터 이미지</th>
			<td><input type="file" class="tb" name="performImg" required></td>
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