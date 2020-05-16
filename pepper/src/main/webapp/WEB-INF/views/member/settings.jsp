<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>settings</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/member/settings.css" />">
</head>
<body>

	<div id="bgImg"></div>
	
	<div id="nav">
		<%@ include file="../nav/nav.jsp" %>
	</div>
	
	<div id="wrap">
		<ul>
			<li>
				<a href="/member/modifyPW" >비밀번호 변경</a>
				<hr class="settingsLine">
			</li>
			<li>
				<a href="/member/modifyInfo" >정보 수정</a>
				<hr class="settingsLine">
			</li>
			<li class="setting_menu">
				<a href="/member/delete" >회원 탈퇴</a>
			</li>
		</ul>
	</div>
	
</body>
</html>