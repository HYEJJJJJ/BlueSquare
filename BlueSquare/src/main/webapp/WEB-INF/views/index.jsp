<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BLUE SQUARE</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/index.css">
</head>
<body>
	<div id="wrap">
		<header>
		<jsp:include page="header.jsp"></jsp:include>
		</header>
		<main>
		  <div class="container">
            <div class="content_a">
                <div class="img_big"> <!-- 공연 이미지 출력 -->
               	 <c:forEach var="perform" items="${perform}"> 
				    <p><a href="${pageContext.request.contextPath}/perform/detail?pno=${perform.pno}">
				        <img src="${pageContext.request.contextPath}${perform.url}" height="400px" alt="Perform Image">
				    </a></p>
					</c:forEach>
                </div> 
            </div>
            <div class="content_b">
                <div class="list">
                    <ul class="img_list">
                        <li><a href=""><img src="<%=request.getContextPath() %>/resources/img/g1.jpg" alt=""></a></li>
                        <li><a href=""><img src="<%=request.getContextPath() %>/resources/img/g1.jpg" alt=""></a></li>
                        <li><a href=""><img src="<%=request.getContextPath() %>/resources/img/g1.jpg" alt=""></a></li>
                    </ul>
                </div>
                
            </div>
            <div class="content_c">
                <div class="SNS">
                    <div class="SNS_head">
                        <span>SNS & promotion</span>
                    </div>
                    <div class="SNSImg">
                        <a href="">
                            <img src="<%=request.getContextPath() %>/resources/img/snsPromo.gif" alt="">
                        </a>
                    </div>
                </div>
                <div class="notice">
                    <div class="notice_head">
                        <span>NOTICE</span>
                        <a href="<%=request.getContextPath() %>/notice/list"><span>more ▶</span></a>
                    </div>
                    <div class="notice_list"> <!-- 공지사항 글목록 출력 -->
                    	<c:forEach var="NoticeBoardDto" items="${list}" varStatus="status" end="4">
					    <ul>
					        <li><a href="<c:url value='/notice/read?${ph.sc.getQueryString()}&amp;bno=${NoticeBoardDto.bno}'/>">${NoticeBoardDto.title}</a></li>
					    </ul>
						</c:forEach>
                    </div>
                </div>
            </div>
        </div>
		<aside>
			<jsp:include page="quickMenu.jsp"></jsp:include>
		</aside>
		</main>
		<footer>		
        <div class="footer">
            <div class="sponser">
                <ul>
                    <li><a href=""><img src="<%=request.getContextPath() %>/resources/img/banner1.png" alt=""></a></li>
                    <li><a href=""><img src="<%=request.getContextPath() %>/resources/img/banner2.png" alt=""></a></li>
                    <li><a href=""><img src="<%=request.getContextPath() %>/resources/img/banner3.png" alt=""></a></li>
                    <li><a href="<c:url value='/convenience'/>"><img src="<%=request.getContextPath() %>/resources/img/banner4.png" alt=""></a></li>
                </ul>
            </div>
            <div class="info">
                <a href=""><img src="<%=request.getContextPath() %>/resources/img/m_cs.gif" alt=""></a>
                <div>
                    <img src="<%=request.getContextPath() %>/resources/img/m_copyright.gif" alt="">
                    <div>
                        <a href=""><img src="<%=request.getContextPath() %>/resources/img/btn_privacy.png" alt=""></a>
                        <a href=""><img src="<%=request.getContextPath() %>/resources/img/btn_eclean.png" alt=""></a>
                    </div>
                </div>
            </div>
        </div>
		</footer>	
	</div>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
      <script>
      $(document).ready(function(){
        $(".img_big").bxSlider();
      });
      
      $('.img_list').bxSlider({
    	  minSlides: 4,
    	  maxSlides: 4,
    	  slideWidth: 1000,
    	  slideMargin: 10,
    	  ticker: true,
    	  speed: 82500
    	});
      
    </script>
    
</body>
</html>