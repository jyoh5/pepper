<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>글 상세보기</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/board/view.css?ver=1" />">
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
	<script>
		var bno = "${view.bno}";
		var num = "${num}";
		var searchType = "${searchType}";
		var keyword = "${keyword}";
	</script>
	<script src="<c:url value="/resources/js/board/view.js?ver=1" />"></script>
</head>
<body>
	<div id="bgImg"></div>

    <div id="nav">
		<%@ include file="../nav/nav.jsp" %>
	</div>

    <div id="wrap">

		<p id="pageTitle">${view.bno}번 글</p>
		
        <table>
        	<colgroup>
        		<col width="*%">
        		<col width="20%">
        		<col width="20%">
        		<col width="15%">
        	</colgroup>
        	
        	<tbody>
        		<tr id="titleRow">
	        		<td id="title">제목 : ${view.title}</td>
	        		<td >작성자 : ${view.writer}</td>
	        		<td >날짜 : ${view.regDate}</td>
	        		<td >조회수 : ${view.viewCnt}</td>
        		</tr>
        		<tr >
        			<td colspan="4">
        				<textarea id="content" readonly="readonly">${view.content}</textarea>
        			</td>
        		</tr>
        	</tbody>
        </table>
        
        <div id="submitArea">
        		<c:if test="${login.userID == view.userID}">
		            <button type="button" class="btn" id="btnEdit">수정</button>
		            <button type="button" class="btn" id="btnDelete">삭제</button>
		        </c:if>
	            <button type="button" class="btn" id="btnList">목록</button>
        </div>
        
        <div id="deleteArea">
        	<p class="deleteText">게시물을&nbsp</p><p class="deleteText focus">삭제</p><p class="delete_letter">&nbsp하시겠습니까? </p>
        	<input type="text" name="userID" style="display:none" value="${login.userID}">
        	<input type="password" name="userPW" id="userPW" placeholder="비밀번호 입력">
        	<p class="alertText"></p>
        	<div id="btnArea">
	        	<button type="submit" class="btn delete" id="btnDeleteOK">OK</button>
	        	<button type="button" class="btn delete" id="btnDeleteCancel">취소</button>
        	</div>
        </div>
        
    </div>
    
    
</body>
</html>