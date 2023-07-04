<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/3_1_rental.css">
    <title>BLUE SQUARE 대관시설</title>
</head>
<body>
    <div class="wrap">
    	<header>
			<jsp:include page="../header.jsp"></jsp:include>
		</header>
        <div class="content">
            <div class="mainC">
                <p class="title">
                    <img src="<%=request.getContextPath() %>/resources/img/ttl_facility.gif" alt="대관시설">
                </p>

                
                <ul class="list">
                    <li>
                        
                        <a href="#FAQ01">무대장비현황</a>
                     
                    </li>
    
                    <li>
                        <a href="#FAQ02">음향장비현황</a>
                    </li>
    
                    <li>
                        <a href="#FAQ03">조명장비현황</a>
                    </li>
    
                    
                </ul>
            
            <div class="qna">
                
                <p class="mainc1" id="FAQ01">
                    <img src="<%=request.getContextPath() %>/resources/img/sound1.png" alt="시설 소개 및 무대장비">
                </p>
                <p class="mainc2" id="FAQ02">
                    <img src="<%=request.getContextPath() %>/resources/img/sound2.png" alt="음향장비">
                </p>
                <p class="mainc3" id="FAQ03">
                    <img src="<%=request.getContextPath() %>/resources/img/sou3.png" alt="조명장비">   
                </p>
               
            </div>

        </div>
    </div>
 </div>
</body>
</html>

