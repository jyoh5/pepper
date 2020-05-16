<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>로그인</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/member/member.css" />">
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
	<script src="<c:url value="/resources/js/member/login.js" />"></script>
</head>
<body>

	<div id="bgImg"></div>
	
	<div id="nav">
		<%@ include file="../nav/nav.jsp" %>
	</div>

    <div id="wrap">
        
        <div id="pageTitle">로그인</div>

        <form method="post" action="/member/login">
			<div class="inputTitle">아이디</div>
			<div class="inputBox">
				<input type="text" class="input" id="userID" name="userID">
			</div>
            
            <div class="inputTitle">비밀번호</div>
			<div class="inputBox">
				<input type="password" class="input" id="userPW" name="userPW">
			</div>
            
            <button type="submit" id="submit">OK</button>

           	<c:if test="${'fail' eq login_fail}">
				<p class="alertText">로그인에 실패했습니다.<br> 아이디 또는 비밀번호를 다시 입력해주십시오.</p>
			</c:if>
          
        </form>
		
    </div>

</body>
</html>

