<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>BLUESQUARE</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/board.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>


<script>
	//model의 내용을 get방식으로 전달 받으면 모두 파라미터로 전달됨
	let msg = "${msg}"
	if (msg == "WRT_ERR") alert("게시글 등록에 실패하였습니다.")
	if (msg == "MOD_ERR") alert("게시글 수정에 실패하였습니다.")
</script>
<div class="wrap">
	<header>
	<jsp:include page="header.jsp"></jsp:include>
	</header>
	
<div class="mainContents">
    <h2>게시글 ${mode=="new" ? "작성" : "읽기"}</h2>
    <form id="form">
        <table>
            <tr>
                <th>번호</th>
                <td><input type="text"  class="tb"  name="bno" value="${noticeBoardDto.bno}" readonly="readonly"></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text"  class="tb" name="writer" value="${noticeBoardDto.writer}" readonly="readonly"}></td>
            </tr>
            <tr>
            
                <th>제목</th>
                <td><input type="text"  class="tb" name="title" value="<c:out value='${noticeBoardDto.title}'/>" ${mode == 'new'? '':'readonly="readonly"'}></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea  class="tb" name="content" ${mode == 'new'? '' : 'readonly="readonly"'} cols="50" rows="20"><c:out value='${noticeBoardDto.content}'/></textarea></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="button" class="btn">글쓰기</button>
                    <button type="button" id="modifyBtn" class="btn">수정</button>
                    <button type="button" id="removeBtn" class="btn">삭제</button>
                    <button type="button" id="listBtn" class="btn">목록</button>

                </td>
                
            </tr>
        </table>
    </form>
</div>
</div>
	<script>
		$(document).ready(function() {
			
			$("#listBtn").on("click", function() {
				location.href="<c:url value='/notice/list'/>";
			})
			
			$("#removeBtn").on("click", function() {
				
				if(!confirm("정말로 삭제하시겠습니까?")) return;
				
				let form = $('#form')
				form.attr("action", "<c:url value='/notice/remove?page=${page}&pageSize=${pageSize}'/>")
				form.attr("method", "post")
				
				form.submit();
				
				
			})
			
			$("#writeBtn").on("click", function() {

				let form = $('#form')
				form.attr("action", "<c:url value='/notice/write'/>")
				form.attr("method", "post")
				
				form.submit();
			})
			
		
			$("#modifyBtn").on("click", function() {

				let form = $('#form')
				
				let isReadOnly = $("input[name=title]").attr('readonly');
				
				//1. 읽기 상태라면 수정 상태로 변경
				if (isReadOnly == 'readonly') {
					$("h2").html("게시글 수정");
					
					$("input[name=title]").attr('readonly', false).css('background-color', '#CCE5FF');
					$("textarea").attr('readonly', false).css('background-color', '#CCE5FF');
					$("#modifyBtn").html("수정 완료");
					
					return;
				}
				
				//2. 수정 상태라면 수정된 내용을 서버로 전송				
				form.attr("action", "<c:url value='/notice/modify'/>")
				form.attr("method", "post")
				
				form.submit();
			})
			
		})
	</script>
</body>
</html>





