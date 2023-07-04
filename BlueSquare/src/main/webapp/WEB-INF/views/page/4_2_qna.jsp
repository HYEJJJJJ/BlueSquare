<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/4_2_qna.css">
    <title>BLUE SQUARE QNA</title>
</head>
<body>
    <div class="wrap">
    	<header>
			<jsp:include page="../header.jsp"></jsp:include>
		</header>
        <div class="content">
            <div class="mainC">
                <p class="title">
                    <img src="<%=request.getContextPath() %>/resources/img/ttl_faq.gif" alt="자주 묻는 질문">
                </p>

                    <ul class="list">
                        <li>
                            
                            <a href="#FAQ01">공연</a>
                            
                        </li>
        
                        <li>
                            <a href="#FAQ02">예매</a>
                        </li>
        
                        <li>
                            <a href="#FAQ03">관람</a>
                        </li>
        
                        <li>
                            <a href="#FAQ04">편의</a>
                        </li>
        
                        <li>
                            <a href="#FAQ05">주차</a>
                        </li>
                    </ul>
                
                <div class="qna">
                    
                    <p class="mainR1" id="FAQ01">
                        <img src="<%=request.getContextPath() %>/resources/img/1.png" alt="">
                    </p>
                    <p class="mainR2" id="FAQ02">
                        <img src="<%=request.getContextPath() %>/resources/img/R2.png" alt="">
                    </p>
                    <p class="mainR3" id="FAQ03">
                        <img src="<%=request.getContextPath() %>/resources/img/3.png" alt="">
                    </p>
                    <p class="mainR4" id="FAQ04">
                        <img src="<%=request.getContextPath() %>/resources/img/4.png" alt="">
                    </p>
                    <p class="mainR5" id="FAQ05">
                        <img src="<%=request.getContextPath() %>/resources/img/5.png" alt="">
                    </p>

                </div>
            </div>
        </div>
    </div>
</body>
</html>

