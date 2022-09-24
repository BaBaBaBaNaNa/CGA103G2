<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.orddetails.model.*"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
OrddetailsVO orddetailsVO = (OrddetailsVO) request.getAttribute("orddetailsVO"); 
%>


<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>義鄉人_訂單後台</title>
<!-- Iconic Fonts -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link
	href="../../back-assets/vendors/iconic-fonts/font-awesome/css/all.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="../../back-assets/vendors/iconic-fonts/flat-icons/flaticon.css">
<link rel="stylesheet"
	href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins.css">
<link rel="stylesheet"
	href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins-colors.css">
<!-- Bootstrap core CSS -->
<link href="../../back-assets/css/bootstrap.min.css" rel="stylesheet">
<!-- Page Specific Css (Datatables.css) -->
<link href="../../back-assets/css/datatables.min.css" rel="stylesheet">
<!-- jQuery UI -->
<link href="../../back-assets/css/jquery-ui.min.css" rel="stylesheet">
<!-- Costic Core styles -->
<link href="../../back-assets/css/style.css" rel="stylesheet">
<!-- Favicon -->
<link rel="icon" type="image/png" sizes="32x32" href="../../favicon.ico">

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 570px;
	background-color: #f0f0fa;
	margin-top: 1px;
	margin-bottom: 1px;
	margin-left: 10px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>
</head>

<body
	class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">
	<!-- ----- ----- ----- 進入網站的讀取圈圈 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- 進入網站的讀取圈圈 end ----- ----- ----- -->
	<div class="ms-aside-overlay ms-overlay-left ms-toggler"
		data-target="#ms-side-nav" data-toggle="slideLeft"></div>
	<div class="ms-aside-overlay ms-overlay-right ms-toggler"
		data-target="#ms-recent-activity" data-toggle="slideRight"></div>
	<!-- Sidebar Navigation Left -->

	<!-- ----- ----- ----- 最左邊的 選擇列 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/LeftSideBar.file"%>
	<!-- ----- ----- ----- 最左邊的 選擇列 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main class="body-content">
		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
		<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->
		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb pl-0">
				<li class="breadcrumb-item"><a
					href="../../back-end/backstage/Back_index.jsp"><i
						class="material-icons">home</i>首頁</a></li>
				<li class="breadcrumb-item"><a href="#">訂單管理</a></li>
				<li class="breadcrumb-item active" aria-current="page">查看訂單</li>
			</ol>
		</nav>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->
		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->

		<table id="table-1">
			<tr>
				<td>
					<h3>訂單明細新增 </h3>
				</td>
				<td>
					<h4>
						<a href="select_page.jsp"><img src="images/capoo.gif"
							width="250" height="250" border="0">返回訂單明細查詢</a>
					</h4>
				</td>
			</tr>
		</table>

		<h3>資料新增:</h3>

		<%-- 錯誤表列 --%>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>

		<FORM METHOD="post" ACTION="orddetails.do" name="form1">
			<table>
				<tr>
					<td>訂單明細編號:</td>
					<td><input type="TEXT" name="orddetailsID" size="45"
						value="<%=(orddetailsVO == null) ? "" : orddetailsVO.getOrddetailsID()%>" /></td>
				</tr>
				<tr>
					<td>訂單編號:</td>
					<td><input type="TEXT" name="ordersID" size="45"
						value="<%=(orddetailsVO == null) ? "" : orddetailsVO.getOrdersID()%>" /></td>
				</tr>
				<jsp:useBean id="mealsSvc" scope="page" class="com.meals.model.MealsService" />
				<tr>
					<td>餐點:</td>
					<td>
					<select size="1" name="mealsID" >
						<c:forEach var="mealsVO" items="${mealsSvc.all}">
							<option value="${mealsVO.mealsID}" ${(param.mealsID==mealsVO.mealsID)?'selected':'' }>${mealsVO.mealsName}
						</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>餐點數量:</td>
					<td><input type="TEXT" name="orddetailsMealsQuantity"
						size="45"
						value="<%=(orddetailsVO == null) ? "" : orddetailsVO.getOrddetailsMealsQuantity()%>" /></td>
				</tr>
				<tr>
					<td>餐點總金額:</td>
					<td><input type="TEXT" name="orddetailsMealsAmount" size="45"
						value="<%=(orddetailsVO == null) ? "" : orddetailsVO.getOrddetailsMealsAmount()%>" /></td>
				</tr>
				<td>製作狀態(0:已製作 , 1:未製作):</td>
				<td><select name="orddetailsMealsStatus"
					id="orddetailsMealsStatus">
						<option value="0">已製作</option>
						<option value="1">未製作</option>
				</select></td>
				</tr>
<!-- 				<tr> -->
<!-- 					<th id="test">製作狀態(0:已製作 , 1:未製作):</th> -->
<!-- 					<td><select name="orddetailsMealsStatus" id="orddetailsMealsStatus"> -->
<!-- 							<option value="0" -->
<%-- 								<c:if test="${orddetailsVO.orddetailsMealsStatus == 0}">selected</c:if>>已製作</option> --%>
<!-- 							<option value="1" -->
<%-- 								<c:if test="${orddetailsVO.orddetailsMealsStatus == 1}">selected</c:if>>未製作</option> --%>
<!-- 					</select></td> -->
<!-- 				</tr> -->
				<tr>
					<td>送餐狀態(0:已送餐 , 1:未送餐):</td>
					<td><select id="orddetailsDeliverStatus"
						name="orddetailsDeliverStatus">
							<option value="0">已送餐</option>
							<option value="1">未送餐</option>
					</select></td>
				</tr>
				<tr>
<!-- 					<th id="test">送餐狀態(0:已送餐 , 1:未送餐):</th> -->
<!-- 					<td><select name="orddetailsDeliverStatus" id="orddetailsDeliverStatus"> -->
<!-- 							<option value="0" -->
<%-- 								<c:if test="${orddetailsVO.orddetailsDeliverStatus == 0}">selected</c:if>>已送餐</option> --%>
<!-- 							<option value="1" -->
<%-- 								<c:if test="${orddetailsVO.orddetailsDeliverStatus == 1}">selected</c:if>>未送餐</option> --%>
<!-- 					</select></td> -->
<!-- 				</tr> -->

			</table>

			<br> <input type="hidden" name="action" value="insert">
			<input type="submit" value="送出新增">
		</FORM>

		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->
	<!-- SCRIPTS -->
	<!-- Global Required Scripts Start -->
	<script src="../../back-assets/js/jquery-3.3.1.min.js"></script>
	<script src="../../back-assets/js/popper.min.js"></script>
	<script src="../../back-assets/js/bootstrap.min.js"></script>
	<script src="../../back-assets/js/perfect-scrollbar.js"></script>
	<script src="../../back-assets/js/jquery-ui.min.js"></script>
	<!-- Global Required Scripts End -->
	<!-- Page Specific Scripts Start -->
	<script src="../../back-assets/js/Chart.bundle.min.js"></script>
	<!-- Page Specific Scripts End -->
	<!-- Page Specific Scripts Finish -->
	<script src="../../back-assets/js/datatables.min.js"></script>
	<script src="../../back-assets/js/data-tables.js"></script>
	<!-- Costic core JavaScript -->
	<script src="../../back-assets/js/framework.js"></script>
	<!-- Settings -->
	<script src="../../back-assets/js/settings.js"></script>

	<!-- ===================================================================================================================== -->


	<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

	<script>

document.getElementById('orddetailsMealsStatus').onchange = () => {
	console.log(this);
}
document.getElementById('orddetailsDeliverStatus').onchange = () => {
	console.log(this);
}
</body>

</html>