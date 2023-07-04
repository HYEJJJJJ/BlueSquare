<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/1_4_guideMap.css">
    <title>BLUE SQUARE 오시는 길</title>
</head>
<body>
    <div class="wrap">
    	<header>
			<jsp:include page="../header.jsp"></jsp:include>
		</header>
        <div class="mainContents">
            <div class="content"><!--내용-->
                <h2 class="title"><!--오시는 길 제목-->
                    <img src="<%=request.getContextPath() %>/resources/img/ttl_map.gif" alt="오시는 길">
                </h2>

                <!-- 오시는 길 -->
                <div class="guideMap">
                    <!--지도-->
                   <div id="map" style="width:100%;height:350px;"></div>
                    <!--오시는 길 이용안내-->
                <div class="guide">
                    <p>
                        <img src="<%=request.getContextPath() %>/resources/img/map_txt1.gif" alt="지하철 이용방법">
                    </p>
                    <p>
                        <img src="<%=request.getContextPath() %>/resources/img/map_txt2.gif" alt="버스 이용방법">
                    </p>
                    <p>
                        <img src="<%=request.getContextPath() %>/resources/img/map_txt3.gif" alt="자가용 이용방법">
                    </p>
                    <p>
                        <img src="<%=request.getContextPath() %>/resources/img/map_txt5.gif" alt="인근 주차장">
                    </p>
                    <p>
                        <img src="<%=request.getContextPath() %>/resources/img/map_txt4.gif" alt="주차안내">
                    </p>
                </div>

                </div>
            </div>    
        </div>
    </div>
 
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e95fa73104e3a67d0cb4b58bff969a84"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.5409,127.0025), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(37.5409,127.0025); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);    
</script>
</body>
</html>