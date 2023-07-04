<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/3_2_rentalP.css">
    <title>BLUE SQUARE 대관료</title>
</head>
<body>
    <div class="wrap">
    	<header>
			<jsp:include page="../header.jsp"></jsp:include>
		</header>
        <div class="content">
            <div class="mainC">
                <P class="title">
                    <img src="<%=request.getContextPath() %>/resources/img/ttl_venue.gif" alt="대관료">
                </P>

                <P class="rpc">
                    <img src="<%=request.getContextPath() %>/resources/img/rentalpriceCs.png" alt="대관료 내용">
                </P>            
            </div>
        </div>
    </div>
</body>
</html>