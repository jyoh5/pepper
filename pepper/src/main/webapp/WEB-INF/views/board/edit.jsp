<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>글 수정</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/board/write.css?ver=1" />">
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
	<script>
		var num = "${num}";
		var searchType = "${searchType}";
		var keyword = "${keyword}";
	</script>
	<script src="<c:url value="/resources/js/board/write.js" />"></script>
</head>
<body>

	<div id="bgImg"></div>
	
    <div id="nav">
		<%@ include file="../nav/nav.jsp" %>
	</div>
    
    <div id="wrap">
    
    	<p id="pageTitle">${view.bno}번 글 수정</p>
    	
        <form method="post" action="/board/edit">
        
        	<div style="display:none;">
        		<input type="text" name="num" value="${num}">
        		<input type="text" name="bno" value="${view.bno}">
            </div>
            
            <div id="titleArea">
                <input type="text" name="title" class="input" id="title" value="${view.title}" placeholder="제목">
            </div>

            <div id="contentArea">
            	<textarea name="content" class="input content" id="content" placeholder="내용">${view.content}</textarea>
            </div>
            
            <div id="submitArea">
                <button type="submit" class="btn" id="btnSubmit">OK</button>
                <button type="button" class="btn" id="btnCancel">취소</button>
            </div>
        </form>
    </div>
</body>
</html>
