<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/1_3_seatInfo.css">
    <title>BLUE SQUARE 좌석배치도</title>
</head>
<body>
    <div class="wrap">
    	<header>
			<jsp:include page="../header.jsp"></jsp:include>
		</header>
        <div class="mainContents">
            <div class="content"><!--내용-->
                <h2 class="title"><!--좌석배치도 제목-->
                    <img src="<%=request.getContextPath() %>/resources/img/ttl_seat.gif" alt="좌석배치도">
                </h2>

                <ul class="list">
                    <li>
                        <a href="#seat1stfloor">1층 좌석배치도</a>
                     </li>
    
                    <li>
                        <a href="#seat2ndfloor">2층 좌석배치도</a>
                    </li>
    
                    <li>
                        <a href="#seat3rdfloor">3층 좌석배치도</a>
                    </li>
                </ul>

                <div class="seat">

                    <div id="seat1stfloor">
                    <p class="seatTitleImg">
                        <img src="<%=request.getContextPath() %>/resources/img/txt_elec01.gif" alt="신한카드홀 1층 좌석배치도">
                    </p>
                    <p class="seatImg">
                        <img src="<%=request.getContextPath() %>/resources/img/seat_elec01.gif" alt="">
                    </p>
                    </div>
                   <br><br><hr><br><br>
                   
                    <div id="seat2ndfloor">
                        <p class="seatTitleImg">
                        <img src="<%=request.getContextPath() %>/resources/img/txt_elec02.gif" alt="신한카드홀 2층 좌석배치도">
                    </p>
                        <p class="seatImg">
                        <img src="<%=request.getContextPath() %>/resources/img/seat_elec02.gif" alt="">
                        </p>
                    </div>
                     <br><br><hr><br><br>
                   
					
                    <div id="seat3rdfloor">
                        <p class="seatTitleImg">
                        <img src="<%=request.getContextPath() %>/resources/img/txt_elec03.gif" alt="신한카드홀 3층 좌석배치도">
                    </p>
                        <p class="seatImg">
                        <img src="<%=request.getContextPath() %>/resources/img/seat_elec03.gif" alt="">
                        </p>
                    </div>

                </div>
            </div>    
        </div>
    </div>
</body>
</html>