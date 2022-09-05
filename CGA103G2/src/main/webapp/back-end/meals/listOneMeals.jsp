<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>菜單資料 - listOneMeals.jsp</title>

<%@ include file="included-fragment.file" %>
<style type="text/css">
	
    span {
		display: inline-block;
		width: 150px;
		text-align: left;
		font-weight: bold;
	}
</style>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		 <div align="center"> <h2>菜單資料 - listOneMeals.jsp</h2>
		 <h3><a class="navbar-brand" href="<%=request.getContextPath()%>/meals/select_page.jsp"><img src="<%=request.getContextPath()%>/resources/images/back1.gif">回查詢頁${success}</a></h3></div>
</nav>

	<div align="center">
		<h3><span>查詢結果 :</span></h3>
		<span>菜單編號:</span><span>${mealsVO.mealsID}</span><br/>
		<span>菜系編號:</span><span>${mealsVO.mealsCategoryID}</span><br/>
		<span>菜單名稱:</span><span>${mealsVO.mealsName}</span><br/>
		<span>價錢:</span><span>${mealsVO.mealsPrice}</span><br/>
		<span>控制:</span><span>${mealsVO.mealsControl}</span><br/>
		<span>照片:</span><span><img src="<%=request.getContextPath()%>/meals/DBGifReader?mealsID=${mealsVO.mealsID}" width="100px"></span><br/>
	</div>


</body>
</html>