<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>義鄉人_訂單明細後台</title>
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
	width: 570px;
	background-color: #F0F0FA;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 3px ridge Gray;
	height: 100px;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
	margin-left: 10px;
}

h4 {
	color: blue;
	display: inline;
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
				<li class="breadcrumb-item active" aria-current="page">查看訂單明細</li>
			</ol>
		</nav>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->
		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->


		<%-- 錯誤表列 --%>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>

		<jsp:useBean id="orddetailsSvc" scope="page"
			class="com.orddetails.model.OrddetailsService" />
		<table id="table-1">
			<tr>
				<th>
					<h3>
						<a href='listAllOrddetails.jsp'>查詢訂單明細</a>
					</h3>
				</th>
			</tr>

<!-- 			<li> -->
<!-- 				<FORM METHOD="post" ACTION="orddetails.do"> -->
<!-- 					<b>選擇明細編號:</b> <select size="1" name="orddetailsID"> -->
<%-- 						<c:forEach var="orddetailsVO" items="${orddetailsSvc.all}"> --%>
<%-- 							<option value="${orddetailsVO.orddetailsID}">${orddetailsVO.ordersID} --%>
<%-- 						</c:forEach> --%>
<!-- 					</select> <input type="hidden" name="action" value="getOne_For_Display"> -->
<!-- 					<input type="submit" value="送出"> -->
<!-- 				</FORM> -->
<!-- 			</li> -->

			<!-- 				<b>訂單明細編號:</b> -->
			<!-- 				<select size="1" name="orddetailsID"> -->
			<!-- 					<option value="1"> -->
			<%-- 						<c:forEach var="orddetailsVO" items="${orddetailsSvc.all}"> --%>
			<%-- 							<option value="${orddetailsVO.orddetailsID}">${orddetailsVO.ordersID} --%>
			<%-- 						</c:forEach> --%>
			<!-- 				</select> -->
			<!-- 				<br> -->

			<tr>
				<!-- 					<th> -->
				<!-- 						<FORM METHOD="post" ACTION="orddetails.do"> -->
				<!-- 							<b>訂單明細編號:</b>  -->
				<!-- 							<input type="text" name="orddetailsID"> -->
				<!-- 							<input type="hidden" name="action" value="getOne_For_Display"> -->
				<!-- 							<input type="submit" value="送出"> -->
				<!-- 						</FORM> -->
				<!-- 					</th> -->
			</tr>
<!-- 			<tbody> -->
<!-- 				<tr> -->
<!-- 					<td> -->
<!-- 						<FORM METHOD="post" ACTION="orddetails.do"> -->
<!-- 							<b>訂單編號:</b> <select size="1" name="orddetailsID"> -->
<%-- 								<c:forEach var="orddetailsVO" items="${orddetailsSvc.all}"> --%>
<%-- 									<option value="${orddetailsVO.orddetailsID}">${orddetailsVO.ordersID} --%>
<%-- 								</c:forEach> --%>
<!-- 							</select> <input type="hidden" name="action" value="getOne_For_Display"> -->
<!-- 							<input type="submit" value="送出"> -->
<!-- 						</FORM> -->
<!-- 					</td> -->
<!-- 				</tr> -->
<!-- 			</tbody> -->
			<tfoot>
				<tr>
					<th><a href='addOrddetails.jsp'>新增訂單明細</a></th>

				</tr>
			</tfoot>
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