<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/1_2_convenience.css">
    <title>BLUE SQUARE 편의시설</title>
</head>
<body>
    <div class="wrap">
      	<header>
			<jsp:include page="../header.jsp"></jsp:include>
		</header>
        <div class="mainContents">
        
            <div class="content"><!--내용-->
                <h2 class="title"><!--편의시설 제목-->
                    <img src="<%=request.getContextPath() %>/resources/img/ttl_guide.gif" alt="편의시설">
                </h2>

                <p class="convenienceImg"><!--편의시설 이미지-->
                    <img src="<%=request.getContextPath() %>/resources/img/con1.gif" alt="편의시설 상세이미지">
                </p>
            </div>
        </div>
    </div>
</body>
</html>