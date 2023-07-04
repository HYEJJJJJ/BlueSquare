<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>BLUESQUARE</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/board.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
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
	                <td><input type="text" class="tb" name="bno" value="${boardDto.bno}" readonly="readonly"></td>
	            </tr>
	            <tr>
	                <th>작성자</th>
	                <td><input type="text" class="tb" name="writer" value="${boardDto.writer}" readonly="readonly"}></td>
	            </tr>
	            <tr>
	            
	                <th>제목</th>
	                <td><input type="text" class="tb" name="title" value="<c:out value='${boardDto.title}'/>" ${mode == 'new'? '':'readonly="readonly"'}></td>
	            </tr>
	            <tr>
	                <th>내용</th>
	                <td><textarea class="tb" name="content" ${mode == 'new'? '' : 'readonly="readonly"'} cols="50" rows="20"><c:out value='${boardDto.content}'/></textarea></td>
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
	
	<div class="commentsContainer">
	<c:if test="${mode != 'new' }">
		<span>댓글 : </span><input type="text" name="comments" class="write">
		<button id="sendBtn" type="button">쓰기</button>
		<button id="modBtn" type="button">확인</button>
		
		<!-- 댓글 표시 -->
	<div id="commentsList"></div> 
		
		<div id="replyForm" style="display: none">
			<input type="text" name="replyComment">
			<button type="button" id="wrtRepBtn">등록</button>
		</div>
		
		<script>
		
			let bno=${boardDto.bno};
			
			let showList = function(bno) {
				
				$.ajax({
	                type:'GET',       // 요청 메서드
	                url: '/app/comments?bno='+bno,  // 요청 URI
	                success : function(result){
	                   
	                  
	                    $("#commentsList").html(toHtml(result));
	                },
	                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
	            }); // $.ajax()
	        } //function
	        
			
			
			$(document).ready(function() {
				
				showList(bno);
				
				$("#sendBtn").click (function() {
					
					let comments = $("input[name=comments]").val()
					
					if (comments.trim() == '') {
						alert("댓글을 입력하세요!")
						$("input[name=comments]").focus();
						return;
					}
					
					$.ajax({
		                type:'POST',       // 요청 메서드
		                url: '/app/comments?bno='+bno,  // 요청 URI
		                headers : {"content-type" : "application/json"},//요청헤더
		                data: JSON.stringify({bno: bno, comments:comments}),
		                success : function(result){
		                   
		                  alert(result);
		                  showList(bno);
		                },
		                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
		            }); // $.ajax()
					
				})
				
				$("#wrtRepBtn").click (function() {
					
					let comments = $("input[name=replyComment]").val()
					
					let pcno = $("#replyForm").parent().attr("data-pcno");
					
					if (comments.trim() == '') {
						alert("댓글을 입력하세요!")
						$("input[name=replyComment]").focus();
						return;
					}
					
					$.ajax({
		                type:'POST',       // 요청 메서드
		                url: '/app/comments?bno='+bno,  // 요청 URI
		                headers : {"content-type" : "application/json"},//요청헤더
		                data: JSON.stringify({pcno: pcno, bno: bno, comments:comments}),
		                success : function(result){
		                   
		                  alert(result);
		                  showList(bno);
		                },
		                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
		            }); // $.ajax()
		            
		            $("#replyForm").css("display", "none");
		            $("input[name=replyComment]").val('');
					$("#replyForm").appendTo("body");
				})
				
				$("#modBtn").click (function() {
					
					let comments = $("input[name=comments]").val()
					
					let cno = $(this).attr("data-cno");
					
					if (comments.trim() == '') {
						alert("댓글을 입력하세요!")
						$("input[name=comments]").focus();
						return;
					}
					
					$.ajax({
		                type:'PATCH',       // 요청 메서드
		                url: '/app/comments/'+cno,  // 요청 URI
		                headers : {"content-type" : "application/json"},//요청헤더
		                data: JSON.stringify({cno: cno, comments:comments}),
		                success : function(result){
		                   
		                  alert(result);
		                  showList(bno);
		                },
		                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
		            }); // $.ajax()
					
				})
				
				$("#commentsList").on("click", ".delBtn", function() {
					
					let cno = $(this).parent().attr("data-cno");
					let bno = $(this).parent().attr("data-bno");
					
					$.ajax({
		                type:'DELETE',       // 요청 메서드
		                url: '/app/comments/'+cno + '?bno='+bno,  // 요청 URI
		                success : function(result){
		                   	alert("result")
		                  	
		                    showList(bno);
		                },
		                error   : function(){ alert("error") } // 에러가 발생했을 때, 호출될 함수
		            }); // $.ajax()
				})
				
				$("#commentsList").on("click", ".replyBtn", function() {
					
					//appendTo : 선택한 요소의 뒤에 붙여줌
					$("#replyForm").appendTo($(this).parent());
					$("#replyForm").css("display", "block");
					
				})
				
				$("#commentsList").on("click", ".modBtn", function() {
					
					let cno = $(this).parent().attr("data-cno");
					
					
					// comment내용을 input에 넣어주기
					let comments = $("span.comments", $(this).parent()).text();
					
					$("input[name=comments]").val(comments);
					
					// cno 전달
					$("#modBtn").attr("data-cno", cno)
				})
			})
			
			//결과를 화면에 출력하기위한 함수를 생성
			let toHtml = function(comments) {
				
				let tmp="<ul id='comments'>";
				
				comments.forEach(function(comments) {
					tmp += '<li data-cno=' + comments.cno
					tmp += ' data-pcno=' + comments.pcno
					tmp += ' data-bno=' + comments.bno + '>'
					
					if (comments.cno != comments.pcno)
						tmp += '<span class="material-symbols-outlined">east</span>'

						
					tmp += ' 댓글 작성자=<span class="commenter">' + comments.commenter + '</span>'
					tmp += ' 내용=<span class="comments">' + comments.comments + '</span>'
					tmp += ' 작성 시간=' + dateToString(comments.up_date)				
					tmp += ' <button class="delBtn">삭제</button>'
					tmp += ' <button class="modBtn">수정</button>'
					tmp += ' <button class="replyBtn">답글</button>'
					tmp += '</li>'
				})
				
				tmp+= "</ul>"
				
				return tmp;
			}
	        
	        let addZero = function(value=1) {
	        	return value > 9 ? value : "0" + value;
	        }
	        
	        let dateToString = function(ms=0) {
	        	let date = new Date(ms);
	        	
	        	let yyyy = date.getFullYear();
	        	let mm = addZero(date.getMonth()+1);
	        	let dd = addZero(date.getDate());
	        	
	        	let HH = addZero(date.getHours());
	        	let MM = addZero(date.getMinutes());
	        	let ss = addZero(date.getSeconds());
	        	
	        	return yyyy+ "." + mm + "." + dd + " " + HH + ":" + MM + ":"+ ss;
	        }
	        
		</script>
		
	</c:if>
	</div>

</div>
	<script>
		$(document).ready(function() {
			
			$("#listBtn").on("click", function() {
				location.href="<c:url value='/board/list?page=${page}&pageSize=${pageSize}'/>";
			})
			
			$("#removeBtn").on("click", function() {
				
				if(!confirm("정말로 삭제하시겠습니까?")) return;
				
				let form = $('#form')
				form.attr("action", "<c:url value='/board/remove?page=${page}&pageSize=${pageSize}'/>")
				form.attr("method", "post")
				
				form.submit();
				
				
			})
			
			$("#writeBtn").on("click", function() {

				let form = $('#form')
				form.attr("action", "<c:url value='/board/write'/>")
				form.attr("method", "post")
				
				form.submit();
			})
			
			//
			//
			
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
				form.attr("action", "<c:url value='/board/modify'/>")
				form.attr("method", "post")
				
				form.submit();
			})
			
		})
	</script>
</body>
</html>





