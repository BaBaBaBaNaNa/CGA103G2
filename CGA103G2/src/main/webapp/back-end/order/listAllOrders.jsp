<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.orders.model.*"%>
<%@ page import="java.sql.*"%>

<%
    OrdersService ordersSvc = new OrdersService();
    List<OrdersVO> list = ordersSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Costic Dashboard</title>
<!-- Iconic Fonts -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="../../back-assets/vendors/iconic-fonts/font-awesome/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/flat-icons/flaticon.css">
<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins.css">
<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins-colors.css">
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

<body class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">
	<!-- ----- ----- ----- ??????????????????????????? start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- ??????????????????????????? end ----- ----- ----- -->
	<div class="ms-aside-overlay ms-overlay-left ms-toggler" data-target="#ms-side-nav" data-toggle="slideLeft"></div>
	<div class="ms-aside-overlay ms-overlay-right ms-toggler" data-target="#ms-recent-activity" data-toggle="slideRight"></div>
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
				<li class="breadcrumb-item"><a href="#"><i class="material-icons">home</i>??????</a></li>
				<li class="breadcrumb-item"><a href="#">????????????</a></li>
				<li class="breadcrumb-item active" aria-current="page">????????????</li>
			</ol>
		</nav>
		<!-- ----- ----- -----   ??????????????? end ----- ----- ----- -->
		<!-- ----- ----- -----   ?????????????????? start ----- ----- ----- -->
<table id="table-1">
	<tr><td>
		 <h3>?????????????????? </h3>
		 <h4><a href="order_details.jsp">??????????????????</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>????????????</th>
		<th>????????????</th>
		<th>??????????????????</th>
		<th>??????????????????</th>
		<th>????????????</th>
		<th>????????????</th>
		<th>???????????????</th>
		<th>????????????</th>
		<th>????????????</th>
		<th>???????????????</th>
		<th>???????????????</th>
		<th>????????????</th>
		<th>??????</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="ordersVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${ordersVO.ordersID}</td>
			<td>${ordersVO.memID}</td>
			<td>${ordersVO.empCounterID}</td> 
			<td>${ordersVO.empDeliveryID}</td>
			<td>${ordersVO.seatID}</td>
			<td>
				<c:if test="${ordersVO.ordersType == 0}">??????</c:if>
				<c:if test="${ordersVO.ordersType == 1}">??????</c:if>
				<c:if test="${ordersVO.ordersType == 2}">??????</c:if>
			</td>
			<td>${ordersVO.ordersAmount}</td>
			<td>
			   <c:if test="${ordersVO.ordersStatus == 0}">??????</c:if>
    	       <c:if test="${ordersVO.ordersStatus == 1}">?????????</c:if>
    	       <c:if test="${ordersVO.ordersStatus == 2}">??????</c:if>
    	    </td>
			<td>${ordersVO.ordersDestination}</td>
			<td>${ordersVO.ordersBuildDate}</td> 
			<td>${ordersVO.ordersMakeDate}</td>
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/orddetails/orddetails.do" style="margin-bottom: 0px;">
			     <input type="submit" value="????????????" >
			     <input type="hidden" value="${ordersVO.ordersID}" name="orderDetailId">
			     <input type="hidden" name="action"	value="getOne_For_Display"></FORM>
			     
			</td>
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/order/orders.do" style="margin-bottom: 0px;">
			     <input type="submit" value="??????">
			     <input type="hidden" name="ordersID"  value="${ordersVO.ordersID}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/order/orders.do" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="??????"> -->
<%-- 			     <input type="hidden" name="ordersID"  value="${ordersVO.ordersID}"> --%>
<!-- 			     <input type="hidden" name="action" value="delete"></FORM> -->
<!-- 			</td> -->
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>
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