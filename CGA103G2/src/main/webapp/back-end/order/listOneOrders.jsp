<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.orders.model.*"%>
<%@ page import="java.sql.*"%>

<%
OrdersVO ordersVO = (OrdersVO) request.getAttribute("ordersVO"); //OrdersServlet.java(Concroller), 存入req的ordersVO物件
%>

<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Costic Dashboard</title>
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
	width: 1000px;
	background-color: #f0f0fa;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
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
				<li class="breadcrumb-item"><a href="#"><i
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
					<h3>訂單資料</h3>
					<h4>
						<a href="order_details.jsp">回首頁</a>
					</h4>
				</td>
			</tr>
		</table>

		<table>
			<tr>
				<th>訂單編號</th>
				<th>會員編號</th>
				<th>櫃台員工編號</th>
				<th>外送員工編號</th>
				<th>桌子編號</th>
				<th>訂單種類(外帶 外送 內用)</th>
				<th>訂單總金額</th>
				<th>訂單狀態(完成, 未完成, 退回)</th>
				<th>取餐地點</th>
				<th>成立訂單日</th>
				<th>預計製作日</th>
			</tr>
			<tr>
				<td><%=ordersVO.getOrdersID()%></td>
				<td><%=ordersVO.getMemID()%></td>
				<td><%=ordersVO.getEmpCounterID()%></td>
				<td><%=ordersVO.getEmpDeliveryID()%></td>
				<td><%=ordersVO.getSeatID()%></td>
				<td>
					<c:if test="${ordersVO.ordersType == 0}">外帶</c:if>
					<c:if test="${ordersVO.ordersType == 1}">外送</c:if>
					<c:if test="${ordersVO.ordersType == 2}">內用</c:if>
				</td>
				<td><%=ordersVO.getOrdersAmount()%></td>
				<td>
					<c:if test="${ordersVO.ordersStatus == 0}">完成</c:if>
    	   			<c:if test="${ordersVO.ordersStatus == 1}">未完成</c:if>
    	   	  		<c:if test="${ordersVO.ordersStatus == 2}">退回</c:if>
    	   		</td>
				<td><%=ordersVO.getOrdersDestination()%></td>
				<td><%=ordersVO.getOrdersBuildDate()%></td>
				<td><%=ordersVO.getOrdersMakeDate()%></td>
			</tr>
		</table>
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
</body>

</html>