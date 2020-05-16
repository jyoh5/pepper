<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>분석</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/pepper/analysis.css" />">
</head>
<body>

	<div id="nav">
		<%@ include file="../nav/nav.jsp" %>
	</div>

    <div id="wrap">

        <form>
            <div class="analImg"></div>

            <div class="analBox">
                <div class="text">파일경로</div>
                <div class="iconFolder"></div>
                <input type="text" class="path">
            </div>
            
            <div class="analBox">
                <div class="text">저장경로</div>
                <div class="iconFolder"></div>
                <input type="text" class="path">
            </div>

            <div class="analBox">
                <div class="btn" id="start"></div>
                <div class="btn" id="pause"></div>
                <div class="btn" id="stop"></div>
                <div class="btn" id="cancel"></div>
            </div>
        </form>
    </div>
	
	<div id="notification">
		<div id="notiBox">
			<div class="notiImg"></div>
			<p class="notiText big">under construction</p>
			<p class="notiText small">현재 준비중입니다.</p>
		</div>
	</div>

</body>
</html>
