<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>비밀번호 변경</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/member/member.css" />">
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
	<script src="<c:url value="/resources/js/member/modifyPW.js" />"></script>
</head>
<body>
	
	<div id="bgImg"></div>

	<div id="nav">
		<%@ include file="../nav/nav.jsp" %>
	</div>

	<div id="wrap">
        
        <div id="pageTitle">비밀번호 변경</div>

        <form method="post" action="/member/modifyPW">

			<div class="inputTitle" style="display:none;">아이디</div>
			<div class="inputBox" style="display:none;">
                <input type="text" class="input" id="userID" name="userID" value="${login.userID}">  
			</div>

			<div class="inputTitle">기존 비밀번호</div>
			<div class="inputBox">
				<input type="password" class="input" id="oldUserPW">
			</div>
			<div class="alertText" id="oldPWCheckResult"></div>

            <div class="inputTitle">새로운 비밀번호</div>
			<div class="inputBox">
				<input type="password" class="input" id="userPW" name="userPW">
			</div>

            <div class="inputTitle">새로운 비밀번호 재확인</div>
			<div class="inputBox">
				<input type="password" class="input" id="userPWCheck">
            </div>
            <div class="alertText" id="pwCheckResult"></div>

            <button type="submit" id="submit">OK</button>

        </form>

    </div>
</body>
</html>

