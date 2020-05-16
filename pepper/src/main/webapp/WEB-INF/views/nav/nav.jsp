<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<html>
<head>
	<meta charset="utf-8">
    <link rel="stylesheet" href="<c:url value="/resources/css/nav/nav.css" />">
	<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
</head>
<body>
	<div id="navWrap">
		
		<div id="logoArea">
			<a href="/" id="logo"></a>
		</div>
		
		<ul id="menu">
			<li>
				<a href="/pepper/analysis" class="menuLetter1">분석</a>
				<a href="/pepper/analysis" class="menuLetter2">ANALYSIS</a>
			</li>
			<li>
				<a href="/pepper/statistics" class="menuLetter1">통계</a>
				<a href="/pepper/statistics" class="menuLetter2">STATISTICS</a>
			</li>
			<li>
				<a href="/board/list?num=1" class="menuLetter1">게시판</a>
				<a href="/board/list?num=1" class="menuLetter2">COMMUNITY</a>
			</li>
			
		</ul>

		<div id="user">
			<c:choose>
				<c:when test="${login == null}">
					<div class="userBox">
						<div class="usericon" id="iconLogin"></div>
						<a href="/member/login" class="userText" title="로그인">로그인</a>
					</div>
					<div class="userBox">
						<div class="usericon" id="iconJoin"></div>
						<a href="/member/join" class="userText" title="회원가입">회원가입</a>
					</div>
				</c:when>
				
				<c:otherwise>
					<div class="userBox">
						<div class="usericon" id="iconSettings"></div>
						<a href="/member/settings" class="userText" title="${login.userName}님의 정보 수정">${login.userName} 님</a>
					</div>
					<div class="userBox">
						<div class="usericon" id="iconLogout"></div>
						<a href="/member/logout" class="userText" title="로그아웃">로그아웃</a>
					</div>	
				</c:otherwise>
			</c:choose>
			
		</div>

	</div>

</body>
</html>