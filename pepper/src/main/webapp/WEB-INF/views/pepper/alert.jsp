<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>login alert</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/pepper/alert.css" />">
    
</head>
<body>

	<div id="nav">
		<%@ include file="../nav/nav.jsp" %>
	</div>
    
	<div class="warp">
        <div class="img"></div>
        
        <div class="letterArea">
        	<p>로그인 후 이용해 주세요</p>
        	<a href="/member/login?page=${page}">로그인 페이지로 이동 ></a>
        </div>
    </div>
	
    
</body>
</html>
