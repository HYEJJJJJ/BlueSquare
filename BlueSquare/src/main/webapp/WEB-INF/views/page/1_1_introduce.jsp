<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/1_1_introduce.css">
    <title>BLUE SQUARE 소개</title>
</head>
<body>
    <div class="wrap">
    	<header>
			<jsp:include page="../header.jsp"></jsp:include>
		</header>
        <div class="mainContents">
            <div class="content"><!--내용-->
             <h2 class="title"><!--소개 제목-->
                    <img src="<%=request.getContextPath() %>/resources/img/ttl_bluesquare.gif" alt="블루스퀘어 소개">
                </h2>

                <p class="introduceImg"><!--소개 이미지-->
                    <img src="<%=request.getContextPath() %>/resources/img/txt_introduce.gif" alt="">
                </p>

                <table><!--소개 목록-->
                    <tr>
                        <th class="loc">위치</th>
                        <td colspan="2" class="loc">서울특별시 용산구 이태원로 294</td>
                    
                    </tr>
                    <tr>
                        <th class="range">규모</th>
                        <td colspan="2" class="range">지하 4층 ~ 지상 4층</td>
                    
                    </tr>
                    <tr>
                        <th class="seat">좌석</th>
                        <td class="left"  id="b_holl">
                            <p class="holl">신한카드홀</p>
                            <p>1,766석 (1층 1,066석, 2층 430석, 3층 270석)</p>

                        </td>
                        <td class="con"> <p class="holl">마스터카드홀</p>
                            <p>1,382석[가변석] (1층 992석, 2층 390석) /
                                1,012석 (1층 622, 2층 390석)</p>
                            </td>
                    </tr>
                    <tr>
                        <th>부대시설</th>
                        <td class="left">
                            <p class="holl">신한카드홀</p>
                            <p>그룹분장실 5室, 개인분장실 4室,
                                감독실, 연기자 대기실, 스탭 대기실,
                                의상실, 탈의실, 샤워실, 세탁실, 건조실</p>
                            </td>
                        <td>
                            <p class="holl">마스터카드홀</p>
                            <p>그룹분장실 2室, 개인분장실 2室,
                                출연자 대기실, 스탭 대기실,대연습실</p></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</body>
</html>