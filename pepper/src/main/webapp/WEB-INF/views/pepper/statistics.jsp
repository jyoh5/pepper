<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>통계</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/pepper/statistics.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/pepper/datepicker.css" />">
	<!-- <link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" /> -->  
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
	<script src="<c:url value="/resources/js/pepper/statistics.js" />"></script>  
</head>
<body>

	<div id="nav">
		<%@ include file="../nav/nav.jsp" %>
	</div>
    
	<div id="warp">
        
        <div id="dash_calendar">
        
            <div class="dash today">
                <div class="dashTitle">오늘 (특상/전체)</div>
                <div class="dashCnt">
                    <div id="todayCnt"></div><div >개/</div><div id="todayTotal"></div><div >개</div>
                </div>
            </div>
        
            <div class="dash">
                <div class="dashTitle">누적 (특상/전체)</div>
                <div class="dashCnt" >
                    <div id="totalCnt"></div><div >개/</div><div id="totalTotal"></div><div >개</div>
                </div>
            </div>
        
            <div class="dash">
                <div class=dashTitle>시세 (홍고추 특등품 by.가락동 도매시장)</div><div class=dashTitle id="priceDate"></div>
                <div class="dashCnt" >
                    <div id="price"></div><div >원/10kg</div>
                </div>
            </div>
        
            <div id="calendarChart">
                <div id="calendar" class="chart"></div>
            </div>
        </div>
        
        <div id="pieChart">
            <div id="pie" class="chart"></div>
        </div>
        
        <div id="columnChart">
            <div id="column" class="chart"></div>
        </div>
    </div>
    
    
    <div id="selectYearArea">
    	연도선택
    	<select name="job" class="input" id="selectYear">
		    <option value="2020" selected="selected">2020</option>
		    <option value="2019">2019</option>
		</select>
    </div>
    
    <div id="selectWeekArea">
    	날짜선택
    	<input type="text" class="input" id="selectWeekStart" name="startDate">
    	<input type="text" class="input" id="selectWeekEnd" name="endDate">
    	<button type="button" id="submit">OK</button>
    </div>
	
    
</body>
</html>
