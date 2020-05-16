<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>회원가입</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/member/member.css" />">
    <script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script src="<c:url value="/resources/js/member/join.js" />"></script>
</head>
<body>

	<div id="bgImg"></div>
	
	<div id="nav">
		<%@ include file="../nav/nav.jsp" %>
	</div>

	<div id="wrap2">
        
        <div id="pageTitle">회원가입</div>

        <form method="post" action="/member/join">
			<div class="inputTitle">아이디</div>
			<div class="inputBox">
                <input type="text" class="input" id="userID" name="userID" placeholder="4자 이상, 입력 후 자동 중복확인">  
            </div>
            <div class="alertText" id="idCheckResult"></div>
            
            <div class="inputTitle">비밀번호</div>
			<div class="inputBox">
				<input type="password" class="input" id="userPW" name="userPW" placeholder="영문 대문자+숫자+특수문자 8자 이상">
			</div>
            
            <div class="inputTitle">비밀번호 재확인</div>
			<div class="inputBox">
				<input type="password" class="input" id="userPWCheck" placeholder="비밀번호 다시 입력">
            </div>
            <div class="alertText" id="pwCheckResult"></div>
            
            <div class="inputTitle">닉네임 </div>
			<div class="inputBox">
				<input type="text" class="input" id="userName" name="userName" placeholder="2자 이상, 입력 후 자동 중복확인">
			</div>
			<div class="alertText" id="nameCheckResult"></div>
            
            <div class="inputTitle">이메일</div>
			<div class="inputBox">
				<input type="text" class="input" id="userEmail" name="userEmail" placeholder="ㅇㅇㅇ@ㅇㅇㅇ.ㅇㅇㅇ">
			</div>
            
            <div class="inputTitle">연락처</div>
			<div class="inputBox">
				<input type="text" class="input" id="userNumber" name="userNumber" placeholder="숫자만 입력">
			</div>
            
            <button type="submit" id="submit">OK</button>
        </form>
        
	
	</div>
</body>
</html>

