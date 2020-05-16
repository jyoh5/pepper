<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>정보 수정</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/member/member.css" />">
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
	<script src="<c:url value="/resources/js/member/modifyInfo.js" />"></script>
</head>
<body>
	
	<div id="bgImg"></div>

	<div id="nav">
		<%@ include file="../nav/nav.jsp" %>
	</div>

	<div id="wrap">
        
        <div id="pageTitle">정보수정</div>

        <form method="post" action="/member/modifyInfo">
        
			<div class="inputTitle" style="display:none;">아이디</div>
			<div class="inputBox" style="display:none;">
                <input type="text" class="input" id="userID" name="userID" value="${login.userID}">  
			</div>
			
			<div class="inputTitle">닉네임 </div>
			<div class="inputBox">
				<input type="text" class="input" id="userName" name="userName" value="${login.userName}">
			</div>
            
            <div class="inputTitle">이메일</div>
			<div class="inputBox">
				<input type="text" class="input" id="userEmail" name="userEmail" value="${login.userEmail}">
			</div>
            
            <div class="inputTitle">연락처</div>
			<div class="inputBox">
				<input type="text" class="input" id="userNumber" name="userNumber" value="${login.userNumber}">
			</div>
			
            <button type="submit" id="submit">OK</button>
        </form>
        
    </div>

</body>
</html>

