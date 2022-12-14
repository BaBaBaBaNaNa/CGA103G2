<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.orddetails.model.OrddetailsVO"%>
<%@ page import="java.sql.*"%>

<%
ArrayList list = (ArrayList) request.getAttribute("orddetailsVO"); 
pageContext.setAttribute("list", list);
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
	width: 100%;
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
	<!-- ----- ----- ----- ??????????????????????????? start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- ??????????????????????????? end ----- ----- ----- -->
	<div class="ms-aside-overlay ms-overlay-left ms-toggler"
		data-tar="#ms-side-nav" data-toggle="slideLeft"></div>
	<div class="ms-aside-overlay ms-overlay-right ms-toggler"
		data-tar="#ms-recent-activity" data-toggle="slideRight"></div>
	<!-- Sidebar Navigation Left -->

	<!-- ----- ----- ----- ???????????? ????????? start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/LeftSideBar.file"%>
	<!-- ----- ----- ----- ???????????? ????????? end ----- ----- ----- -->

	<!-- ----- ----- ----- ?????? start ----- ----- ----- -->
	<main class="body-content">
		<!-- ----- ----- -----   ????????????Bar start ----- ----- ----- -->
		<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   ????????????Bar end ----- ----- ----- -->
		<!-- ----- ----- -----   ??????????????? start ----- ----- ----- -->
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb pl-0">
				<li class="breadcrumb-item"><a href="#"><i
						class="material-icons">home</i>??????</a></li>
				<li class="breadcrumb-item"><a href="#">????????????</a></li>
				<li class="breadcrumb-item active" aria-current="page">????????????</li>
			</ol>
		</nav>
		<!-- ----- ----- -----   ??????????????? end ----- ----- ----- -->
		<!-- ----- ----- -----   ?????????????????? start ----- ----- ----- -->
<table id="table-1">
	<tr><td>
		 <h3>????????????</h3>
		 <h4><a href="<%=request.getContextPath()%>/back-end/order/listAllOrders.jsp">??????????????????</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>??????????????????</th>
		<th>????????????</th>
		<th>????????????</th>
		<th>????????????</th>
		<th>???????????????</th>
		<th>????????????</th>
		<th>????????????</th>
		<th>??????</th>
	</tr>
	
	<c:forEach var="orddetailsVO" items="${list}" >
	<tr>
		<td>${orddetailsVO.orddetailsID}</td>
		<td>${orddetailsVO.ordersID}</td>
		<td>${orddetailsVO.mealsVO.mealsName}</td>
		<td>${orddetailsVO.orddetailsMealsQuantity}</td>
		<td>${orddetailsVO.orddetailsMealsAmount}</td>
		<td>${orddetailsVO.orddetailsMealsStatus == 0 ?"?????????":"?????????"}</td>
		<td>${orddetailsVO.orddetailsDeliverStatus == 0 ?"?????????":"?????????"}</td>
		<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/orddetails/orddetails.do" style="margin-bottom: 0px;">
			     <input type="submit" value="??????">
			     <input type="hidden" name="orddetailsID"  value="${orddetailsVO.orddetailsID}">
			     <input type="hidden" name="action"	value="xxx"></FORM>
			</td>
	</tr>
	</c:forEach>
</table>

		<!-- ----- ----- -----   ?????????????????? end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- ?????? end ----- ----- ----- -->

	

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