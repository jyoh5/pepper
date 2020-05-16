<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>	
	<link rel="stylesheet" href="<c:url value="/resources/css/home.css" />">
</head>
<body>
	
	<div id="bgImg"></div>
	
	<div id="nav">
		<%@ include file="nav/nav.jsp" %>
	</div>
	
	<div id="mainText">
		<div id="mainTextLittle">No sweat, no sweet</div>
		<div id="mainTextBig">Dr.PEPPER</div>
	</div>

</body>
</html>
