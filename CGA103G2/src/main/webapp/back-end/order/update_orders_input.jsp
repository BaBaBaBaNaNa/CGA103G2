<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.orders.model.*"%>
<%@page import="java.sql.Timestamp"%>

<%
OrdersVO ordersVO = (OrdersVO) request.getAttribute("ordersVO"); //OrdersServlet.java (Concroller) 存入req的ordersVO物件 (包括幫忙取出的ordersVO, 也包括輸入資料錯誤時的ordersVO物件)
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
	width: 570px;
	background-color: #f0f0fa;
	margin-top: 1px;
	margin-bottom: 1px;
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
				<li class="breadcrumb-item"><a href="#"><i
						class="material-icons">home</i>首頁</a></li>
				<li class="breadcrumb-item"><a href="order_details.jsp">訂單管理</a></li>
				<li class="breadcrumb-item active" aria-current="page">查看訂單</li>
			</ol>
		</nav>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->
		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		<table id="table-1">
			<tr>
				<td>
					<h3>訂單資料修改 - update_orders_input.jsp</h3>
					<h4>
						<a href="order_details.jsp">回首頁</a>
					</h4>
				</td>
			</tr>
		</table>

		<h3>資料修改:</h3>

		<%-- 錯誤表列 --%>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>

		<FORM METHOD="post" ACTION="orders.do" name="form1">
			<table>
				<tr>
					<td>訂單編號:<font color=red><b>*</b></font></td>
					<td><%=ordersVO.getOrdersID()%></td>
				</tr>

				<tr>
					<td>會員_編號:</td>
					<td><input type="TEXT" name="memID" size="45"
						value="<%=ordersVO.getMemID()%>" /></td>
				</tr>
				<tr>
					<td>櫃台員工_編號:</td>
					<td><input type="TEXT" name="empCounterID" size="45"
						value="<%=ordersVO.getEmpCounterID()%>" /></td>
				</tr>
				<tr>
					<td>外送員工_編號:</td>
					<td><input type="TEXT" name="empDeliveryID" size="45"
						value="<%=ordersVO.getEmpDeliveryID()%>" /></td>
				</tr>
				<tr>
					<td>桌子_編號:</td>
					<td><input type="TEXT" name="seatID" size="45"
						value="<%=ordersVO.getSeatID()%>" /></td>
				</tr>
				<tr>
					<td>訂單_種類(外帶 外送 內用):</td>
					<td><select name="ordersType" id="ordersType">
							<option value="0">外帶</option>
							<option value="1">外送</option>
							<option value="2">內用</option>
					</select></td>
				</tr>
				<tr>
					<td>訂單_總金額:</td>
					<td><input type="TEXT" name="ordersAmount" size="45"
						value="<%=ordersVO.getOrdersAmount()%>" /></td>
				</tr>
				<tr>
					<td>訂單狀態(完成, 未完成, 退回):</td>
					<td><select name="ordersStatus" id="ordersStatus">
							<option value="0">完成</option>
							<option value="1">未完成</option>
							<option value="2">退回</option>
					</select></td>
				</tr>
				<tr>
					<td>取餐地點:</td>
					<td><input type="TEXT" name="ordersDestination" size="45"
						value="<%=ordersVO.getOrdersDestination()%>" /></td>
				</tr>
				<tr>
					<td>成立訂單日:</td>
					<td><input name="ordersBuildDate" id="f_date1" type="text"></td>
				</tr>
				<tr>
					<td>預計製作日:</td>
					<td><input name="ordersMakeDate" id="f_date2" type="text"></td>
				</tr>


			</table>
			<br> <input type="hidden" name="action" value="update">
			<input type="hidden" name="ordersID"
				value="<%=ordersVO.getOrdersID()%>"> <input type="submit"
				value="送出修改">
		</FORM>
		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->
	<%
	Timestamp ordersBuildDate = null;
	try {
		ordersBuildDate = ordersVO.getOrdersBuildDate();
	} catch (Exception e) {
		ordersBuildDate = new Timestamp(System.currentTimeMillis());
	}
	%>
	<%
	Timestamp ordersMakeDate = null;
	try {
		ordersMakeDate = ordersVO.getOrdersMakeDate();
	} catch (Exception e) {
		ordersMakeDate = new Timestamp(System.currentTimeMillis());
	}
	%>

	<link rel="stylesheet" type="text/css"
		href="<%=request.getContextPath()%>/back-assets/datetimepicker/jquery.datetimepicker.css" />
	<script src="<%=request.getContextPath()%>/back-assets/datetimepicker/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/back-assets/datetimepicker/jquery.datetimepicker.full.js"></script>

	<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>

document.getElementById('ordersType').onchange = () => {
	console.log(this);
}
document.getElementById('ordersStatus').onchange = () => {
	console.log(this);
}


$.datetimepicker.setLocale('zh');
$('#f_date1').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:true,       //timepicker:true,
   step: 30,                //step: 60 (這是timepicker的預設間隔60分鐘)
   format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
   value: '<%=ordersVO.getOrdersBuildDate()%>', // value:   new Date(),
   //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
   //startDate:	            '2017/07/10',  // 起始日
   //minDate:               '-1970-01-01', // 去除今日(不含)之前
   //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
});


$.datetimepicker.setLocale('zh');
$('#f_date2').datetimepicker({
   theme: '',              //theme: 'dark',
   timepicker:true,       //timepicker:true,
   step: 30,                //step: 60 (這是timepicker的預設間隔60分鐘)
   format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
   value: '<%=ordersVO.getOrdersMakeDate()%>', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	});

</script>

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