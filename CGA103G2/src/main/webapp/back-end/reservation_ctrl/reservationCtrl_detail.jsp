<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="java.util.*"%>
<%@ page import="com.rsvtCtrl.model.*"%>

<%
RsvtCtrlService rsvtCtrlSvc = new RsvtCtrlService();
List<RsvtCtrlVO> list = rsvtCtrlSvc.getAll();
pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>義鄉人-義式餐酒館-管理中心</title>
<style>
.table th,.table td{
	text-align: center;
	background-color: white;
}
.table tr:nth-child(even) td{
	background-color: aliceblue;
}
.table tr th,td{
line-height:37px;
}
.input_btn {
	border-radius: 10px;
	background-color:white;
	border:1px solid aliceblue !important;
	border: none;
	width: 50px;
	height: 50px;
}

#cName:focus{
	background-color:aliceblue !important;
	border: 0;
	outline: none;
}
#cName{
	border: 1px solid aliceblue;
	outline: none;
}
.input_btn:active {
	box-shadow: inset -1px -1px 1px 1 red;
}

.input_btn:hover {
	cursor: pointer;
	background-image: linear-gradient(90deg, #F0F8FF 0%, #9DD3DF 100%);
	color: #fff;
	box-shadow: 0px 2px 5px -2px rgba(0, 0, 0, 0.3);
	/*   width: 100px;
  height: 100px; */
/* 	transform: scale(1.5); */
}
</style>
<!-- ----- ----- ----- CSS&Front設定 start ----- ----- ----- -->
<!-- Iconic Fonts -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet"
	href="../../back-assets/vendors/iconic-fonts/flat-icons/flaticon.css">
<link rel="stylesheet"
	href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins.css">
<link rel="stylesheet"
	href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins-colors.css">
<!-- Bootstrap core CSS -->
<link href="../../back-assets/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery UI -->
<!-- <link href="../../back-assets/css/jquery-ui.min.css" rel="stylesheet"> -->
<!-- Page Specific CSS (Slick Slider.css) -->
<link href="../../back-assets/css/slick.css" rel="stylesheet">
<link href="../../back-assets/css/datatables.min.css" rel="stylesheet">
<!-- Costic styles -->
<link href="../../back-assets/css/style.css" rel="stylesheet">
<!-- Favicon -->
<link rel="icon" type="image/png" sizes="32x32" href="../../favicon.ico">
<link rel="stylesheet" href="../../back-assets/css/bootstrap-datepicker.css">
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.css"> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css">
<link rel="stylesheet" href="../../back-assets/css/rsvt.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
<script src="../../back-assets/js/bootstrap-datepicker.js"></script>
<script src="../../back-assets/js/bootstrap-datepicker.zh-TW.min.js"></script>
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>
<style>
</style>
<body
	class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">
	<!-- ----- ----- ----- 進入網站的讀取圈圈 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- 進入網站的讀取圈圈 end ----- ----- ----- -->

	<div class="ms-aside-overlay ms-overlay-left ms-toggler"
		data-target="#ms-side-nav" data-toggle="slideLeft"></div>
	<div class="ms-aside-overlay ms-overlay-right ms-toggler"
		data-target="#ms-recent-activity" data-toggle="slideRight"></div>

	<!-- ----- ----- ----- 最左邊的 選擇列 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/LeftSideBar.file"%>
	<!-- ----- ----- ----- 最左邊的 選擇列 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main class="body-content"padding-right: 0 px;>
		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
		<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->

		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
		<%@ include file="../../back-end/tool/Upicon.file"%>
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
<table class="table">
	<tr>
		<th>訂位控制編號</th>
		<th>訂位控制開放</th>
		<th>訂位控制日期</th>
		<th>訂位控制時段</th>
		<th>桌子上限</th>
		<th>已預訂桌數</th>
		<th></th>
		<th></th>
	</tr>
	<%@ include file="page1.file"%>
	<c:forEach var="rsvtCtrlVO" items="${list}" begin="<%=pageIndex%>"
		end="<%=pageIndex+rowsPerPage-1%>">

		<tr>
			<td>${rsvtCtrlVO.rsvtCtrlId}</td>
			<td>${rsvtCtrlVO.rsvtCtrlOpen == 0 ? "開放" : "不開放"}</td>
			<td>${rsvtCtrlVO.rsvtCtrlDate}</td>
			<td>${rsvtCtrlVO.rsvtCtrlOpen == 0 ? "中午" : "晚上"}</td>
			<td>${rsvtCtrlVO.rsvtCtrlMax}</td>
			<td>${rsvtCtrlVO.rsvtCtrlNumber}</td>

			<td>
				<FORM METHOD="post" ACTION="RsvtCtrlServlet"
					style="margin-bottom: 0px;">
					<input type="submit" value="修改" class="input_btn"> <input type="hidden"
						name="rsvtCtrlId" value="${rsvtCtrlVO.rsvtCtrlId}"> <input
						type="hidden" name="action" value="getOne_For_Update">
				</FORM>
			</td>
			<td>
				<FORM METHOD="post" ACTION="RsvtCtrlServlet"
					style="margin-bottom: 0px;">
					<input type="submit" value="刪除" class="input_btn"> <input type="hidden"
						name="rsvtCtrlId" value="${rsvtCtrlVO.rsvtCtrlId}"> <input
						type="hidden" name="action" value="delete">
				</FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file"%>
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-assets/css/jquery.datetimepicker.css" /> --%>
<%-- <script src="<%=request.getContextPath()%>/back-assets/js/jquery.js"></script> --%>
<%-- <script src="<%=request.getContextPath()%>/back-assets/js/jquery.datetimepicker.full.js"></script> --%>
		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<!-- Global Required Scripts Start -->
	<script src="../../back-assets/js/jquery-3.3.1.min.js"></script>
	<script src="../../back-assets/js/popper.min.js"></script>
	<script src="../../back-assets/js/bootstrap.min.js"></script>
	<script src="../../back-assets/js/perfect-scrollbar.js"></script>
	<script src="../../back-assets/js/jquery-ui.min.js"></script>
	<!-- Global Required Scripts End -->
	<!-- Page Specific Scripts Start -->
	<script src="../../back-assets/js/d3.v3.min.js"></script>
	<script src="../../back-assets/js/topojson.v1.min.js"></script>
	<script src="../../back-assets/js/datatables.min.js"></script>
	<script src="../../back-assets/js/data-tables.js"></script>
	<!-- Page Specific Scripts Finish -->
	<!-- Costic core JavaScript -->
	<script src="../../back-assets/js/framework.js"></script>
	<!-- Settings -->
	<script src="../../back-assets/js/settings.js"></script>
	<script>
	
	</script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
</body>

</html>