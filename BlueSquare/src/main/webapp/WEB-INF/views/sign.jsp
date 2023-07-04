<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blue Square SIGN</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/sign.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

</head>
<body>
<div id="container">
	<div class="logo">
	        <a href="<c:url value='/'/>"><h1><img src="<%=request.getContextPath() %>/resources/img/bluesquare.gif" alt="BLUE SQUARE"></h1></a>
	 </div>
	<form action="<c:url value="/sign/save" />" method="post" onsubmit="return formCheck(this)">
	  <div id="msg" class="msg">${URLDecoder.decode(param.msg, "utf-8")}</div> 
		<fieldset>
		<legend>기본정보</legend>
			<ul>
				<li>
					<label>아이디</label>
					<input type="text" id="id" name="id" onblur="checkId()" placeholder="아이디를 입력하세요">
					 <button type="button" id="idOverlap" class="idOverlap" value="N" onclick="fn_idOverlap()">중복확인</button>
				</li>
				<li>
					<label>비밀번호</label>
					<input type="password" id="pw" name="pw" onblur="checkPw()" placeholder="비밀번호를 입력하세요">				
				</li>
				<li>
					<label>이름</label>
					<input type="text" id="name"  name="name" onblur="checkName()" placeholder="이름을 입력하세요">
				</li>
				<li>
					<label>생년월일</label>
					<input type="date" id="birth" name="birth">
				</li>
				<li>
					<label>이메일</label>
					<input type="text" id="email" name="email" onblur="checkEmail()" placeholder="이메일을 입력하세요">
				</li>
				<li>
					<label>주소</label>
					<input type="text" id="address" name="address" onblur="checkAddress()" placeholder="주소를 입력하세요">
				</li>
			</ul>
			<button id="chkBtn">가입하기</button>
		</fieldset>
	</form>
</div>

<script>
	function formCheck(frm) {
		var msg='';
		
		 if(frm.id.value == "") {
             setMessage('아이디를 입력하세요.', frm.id);
             return false;
         }
		 
		 if(frm.idOverlap.value == "N") {
	         	setMessage('아이디 중복확인 버튼을 눌러주세요.', frm.id);
	         	return false;
	     }
         
         if(frm.pw.value == "") {
             setMessage('비밀번호를 입력하세요.', frm.pw);
             return false;
         }
         
         if(frm.name.value == "") {
             setMessage('이름을 입력하세요.', frm.name);
             return false;
         }

         if(frm.birth.value == "") {
             setMessage('생일을 입력하세요.', frm.birth);
             return false;
         }
         
         if(frm.email.value == "") {
             setMessage('이메일을 입력하세요.', frm.email);
             return false;
         }
	
         
         if(frm.address.value == "") {
             setMessage('주소를 입력하세요.', frm.address);
             return false;
         }
	
         return true;
	}
	


	function fn_idOverlap() {
 	   $.ajax({
 		 	url : "/app/sign/idOverlap",
 		 	type : "post",
 		 	dataType : "json",
 		 	data : {"id": $("#id").val()},
 		 	success : function(data) {
 		 		if($("#id").val() == null || $("#id").val() == "") {
 		 			setMessage("아이디를 입력하세요", $("#id"))
 		 		}else if(data == 0) {
 		 			$("#idOverlap").attr("value", "Y")
 		 			setMessage("사용 가능한 아이디입니다.", $("#pw")) 
 		 		} else if(data == 1) {
 		 			setMessage("중복된 아이디입니다.", $("#id"))
 		 		}
 		 	}
 	   })
    } 
      let id = document.getElementById("id"); 
      let pw = document.getElementById("pw");
      let name = document.getElementById("name");
      let email = document.getElementById("email");
      let birth = document.getElementById("birth");
	  
      function checkId() {
   	   //5~12자리의 영소문자와 숫자, -, _ 조합
   	   let pattern = /^[a-z0-9-_]{5,12}$/;
   	   
   	   if (!pattern.test(id.value)) {
   			setMessage("5~12자의 영소문자와 숫자,특수문자(-, _)만 사용가능합니다.", id);
   			return false;
   	   }
   	   document.getElementById("msg").innerHTML="";
		   return true;    	   
      }
      
       function checkPw() {
   	   //영문자, 특수문자, 숫자 모두를 포함하여 8~12글자로 작성
   	   let pattern = /^(?=.*[a-zA-Z])(?=.*[~!@#$%^&*+-/=_])(?=.*[0-9]).{8,12}$/;
   	   
   	   if (!pattern.test(pw.value)) {
   			setMessage("영문자, 특수문자, 숫자 모두를 포함하여 8~12글자로 작성하세요.", pw);
   			return false;
   	   }
   	   document.getElementById("msg").innerHTML="";
		   return true;    	   
      } 
      
      function checkName() {
   	   //한글, 영어 2~10글자
   	   let pattern = /^[a-zA-Z가-힣]{2,10}$/;
   	   
   	   if (!pattern.test(name.value)) {
   			setMessage("2~10자의 한글과 영문만 사용가능합니다.", name);
   			return false;
   	   }
   	   document.getElementById("msg").innerHTML="";
		   return true;    	   
      }
      
      function checkEmail() {
   	   let pattern = /^[a-zA-Z0-9]([-_.]*?[a-zA-Z0-9])*@[a-zA-Z0-9]([-_]?[a-zA-Z0-9])*\.[a-zA-Z.]{2,10}$/;
   	   
   	   if (!pattern.test(email.value)) {
   			setMessage("이메일 형식이 아닙니다.", email);
   			return false;
   	   }
   	   document.getElementById("msg").innerHTML="";
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