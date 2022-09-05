<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*"%>
<%@page import="com.meals.model.*"%>
<%  
	MealsService MealsSvc = new MealsService();
    List<MealsVO> list = MealsSvc.getAll(); 
    pageContext.setAttribute("MealsListData",list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>所有員工資料 - listAllEmp.jsp</title>

<%@ include file="included-fragment.file" %>
<style type="text/css">
    
    table {
      /* width: 1000px; */
	  background-color: white;
	  margin-top: 12px;
	  margin-bottom: 5px;
    }
    table, th, td {
      border: 1px solid #CCCCFF;
    }
    th, td {
      padding: 5px;
      text-align: center;
      width: 100px;
    }
	.center {
        margin-left: auto;
        margin-right: auto;
    }
    span {
		display: inline-block;
		width: 280px;
		text-align: left;
		font-weight: bold;
	}
</style>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		 <div align="center"> <h2>所有菜單資料 - listAllMeals.jsph2>
		 <h3><a class="navbar-brand" href="<%=request.getContextPath()%>/meals/select_page.jsp"><img src="<%=request.getContextPath()%>/resources/images/back1.gif">回查詢頁${success}</a></h3></div>
</nav>

<table class="center">
	<tr>
        <!-- <th>計數</th> -->
		<th>菜色編號</th>
		<th>mealsCategoryID</th>
		<th>菜色名稱</th>
		<th>價錢</th>
		<th>說明</th>
		<th>照片</th>
		<th>控制</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
    <%@ include file="page1.file" %>
	<c:forEach var="mealsVO" items="${MealsListData}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>" varStatus="s">
		
		<tr>
            <%-- <td>${s.count}</td> --%>
			<td>${mealsVO.mealsID}</td>
			<td>${mealsVO.mealsCategoryID}</td>
			<td>${mealsVO.mealsName}</td>
			<td>${mealsVO.mealsPrice}</td>
			<td>${mealsVO.mealsInfo}</td>
			<td><img src="<%=request.getContextPath()%>/meals/DBGifReader?mealsID=${mealsVO.mealsID}" width="100px"></td> 
			<td>${mealsVO.mealsControl}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/meals/Meals.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="mealsID" value="${mealsVO.mealsID}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/meals/Meals.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="mealsID" value="${mealsVO.mealsID}">
			     <input type="hidden" name="action" value="delete"></FORM> 
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>
