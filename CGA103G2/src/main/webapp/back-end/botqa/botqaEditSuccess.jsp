<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*,com.botqa.model.BotqaVO"%>

<%
BotqaVO botqaVO = (BotqaVO) request.getAttribute("botqaVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>

<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>異鄉人-義式餐酒館-管理中心</title>
<!-- ----- ----- ----- CSS&Front設定 start ----- ----- ----- -->
<!-- Iconic Fonts -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/flat-icons/flaticon.css">
<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins.css">
<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins-colors.css">
<!-- Bootstrap core CSS -->
<link href="../../back-assets/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery UI -->
<link href="../../back-assets/css/jquery-ui.min.css" rel="stylesheet">
<!-- Page Specific CSS (Slick Slider.css) -->
<link href="../../back-assets/css/slick.css" rel="stylesheet">
<link href="../../back-assets/css/datatables.min.css" rel="stylesheet">
<!-- Costic styles -->
<link href="../../back-assets/css/style.css" rel="stylesheet">
<!-- Favicon -->
<link rel="icon" type="image/png" sizes="32x32" href="../../favicon.ico">

<link href="../../back-assets/css/empStyle.css" rel="stylesheet">

<link href="../../back-assets/css/empDetailStyle.css" rel="stylesheet">
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
<style type="text/css">
table {
	border: 1px solid black;
	margin: 0 auto;
}

td {
	width: 150px;
	border: 1px solid black;
	text-align: center;
}
div{
	text-align: center;
}
h2{
	text-align: center;
}
</style>
</head>

<body class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">
	<!-- ----- ----- ----- 進入網站的讀取圈圈 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- 進入網站的讀取圈圈 end ----- ----- ----- -->
	<!-- Overlays -->
	<div class="ms-aside-overlay ms-overlay-left ms-toggler" data-target="#ms-side-nav" data-toggle="slideLeft"></div>
	<div class="ms-aside-overlay ms-overlay-right ms-toggler" data-target="#ms-recent-activity" data-toggle="slideRight"></div>

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
		<h2	> 修改成功!</h2>
		<table>
			<tr>
				<th>機器人回應編號</th>
				<th>回應名稱</th>
				<th>回應內容</th>
			</tr>
			<tr>
				<td>${botqaVO.keywordID}</td>
				<td>${botqaVO.keywordName}</td>
				<td>${botqaVO.keywordContext}</td>
			</tr>
		</table>
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
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
</body>

</html>