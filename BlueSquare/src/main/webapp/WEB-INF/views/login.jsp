<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blue Square LOGIN</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

</head>
<body>
<div id="container">
	<div class="logo">
	        <a href="<c:url value='/'/>"><h1><img src="<%=request.getContextPath() %>/resources/img/bluesquare.gif" alt="BLUE SQUARE"></h1></a>
	 </div>
	<form action="<c:url value='/login/login'/>" method="post" onsubmit="return formCheck(this);">
	 <div id="msg">
	    <c:if test="${not empty param.msg}">
		<i class="fa fa-exclamation-circle"> ${URLDecoder.decode(param.msg)}</i>            
	    </c:if>        
	</div>
	<input type="hidden" name="toURL" value="${param.toURL}"> 
		<fieldset>
		<legend>로그인</legend>
		<ul>
			<li>
				<label>아이디</label>
				<input type="text" name="id" id="id" placeholder="아이디를 입력하세요">
			</li>
			<li>
				<label>비밀번호</label>
				<input type="password" name="pw" id="pw" placeholder="비밀번호를 입력하세요">
			</li>
			<li>
				<button id="chkBtn">로그인</button>
			</li>
		</ul>
		</fieldset>
	</form>
</div>

<script>
	function formCheck(frm) {
		let msg = "";
		
		 if(frm.id.value.length==0) {
             setMessage('아이디를 입력해주세요.', frm.id);
             return false;
         }

         if(frm.pw.value.length==0) {
             setMessage('비밀번호를 입력해주세요.', frm.pw);
             return false;
         }
         return true;
	}
	
	 function setMessage(msg, element){
		 document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle"> ${'${msg}'}</i>`;

         if(element) {
             element.select();
         }
    }
</script>
</body>
</html>