<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<meta charset="utf-8">
	<title>게시판</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/board/list.css" />">
	<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
	<script src="<c:url value="/resources/js/board/list.js" />"></script>
</head>
<body>

	<div id="bgImg"></div>

    <div id="nav">
		<%@ include file="../nav/nav.jsp" %>
	</div>

    <div id="wrap">
        <div id="boardArea">
            <table>
            	<colgroup>
	        		<col width="10%">
	        		<col width="*%">
	        		<col width="15%">
	        		<col width="15%">
	        		<col width="10%">
        		</colgroup>
        		
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>날짜</th>
                        <th>조회수</th>
                    </tr>
                </thead>
                
                <tbody>
                	<c:forEach items="${list}" var="list">
	                	<tr>
	                        <td>${list.bno}</td>
	                        <td class="title"><a href="/board/view?num=${page.num}&bno=${list.bno}&searchType=${searchType}&keyword=${keyword}">${list.title}</a></td>
	                        <td>${list.writer}</td>
	                        <td>${list.regDate}</td>
	                        <td>${list.viewCnt}</td>
	                    </tr>
                	</c:forEach>
                </tbody>
            </table>
        </div>
        
        <div id="searchArea">
	        <form method="get" action="/board/list?num=1">
	        	
	        	<input type="text" name=num value="1" style="display:none">
	        	
	        	<select name="searchType" class="searchType">
	        		<option value="title" <c:out value="${searchType eq 'title' ? 'selected' : ''}"/> >제목</option>
	        		<option value="content" <c:out value="${searchType eq 'content' ? 'selected' : ''}"/> >내용</option>
	        		<option value="title_content" <c:out value="${searchType eq 'title_content' ? 'selected' : ''}"/> >제목+내용</option>
	        		<option value="writer" <c:out value="${searchType eq 'writer' ? 'selected' : ''}"/> >작성자</option>
	        	</select>
	        	
	        	<input type="text" name="keyword" class="keyword" value="${keyword}">
	        	
	        	<button type="submit" id="btnSearch">검색</button>
	        </form>
        </div>
        
        
        
        <div class="pageArea">
            <a href="/board/list?num=1&searchType=${searchType}&keyword=${keyword}">처음</a>
            
            <c:if test="${page.prev}">
            	<a href="/board/list?num=${page.startPageNum-1}&searchType=${searchType}&keyword=${keyword}">이전</a>
            </c:if>
                        
            <c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
            	<c:if test="${nowPage == num}">
            		<b class = "nowPage">${num}</b>
            	</c:if>
            	<c:if test="${nowPage != num}">
            		<a class="pageNum" href="/board/list?num=${num}&searchType=${searchType}&keyword=${keyword}">${num}</a>
            	</c:if>
            	
            </c:forEach>
            
            <c:if test="${page.next}">
            	<a href="/board/list?num=${page.endPageNum+1}&searchType=${searchType}&keyword=${keyword}">다음</a>
            </c:if>
            
            <a href="/board/list?num=${page.lastPageNum}&searchType=${searchType}&keyword=${keyword}">마지막</a>
        </div>
        
        <div class="writeArea">
        	<c:if test="${login.userID ne null}">
        		<a href="/board/write?num=${page.num}&searchType=${searchType}&keyword=${keyword}">글쓰기</a>
        	</c:if>
        </div>
        
        
        
    </div>
   
</body>
</html>

