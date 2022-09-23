<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*"%>
<%@ page import="com.rsvt.model.*"%>
<%@ page import="java.text.SimpleDateFormat" %>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
RsvtService rsvtSvc = new RsvtService();
// List<RsvtVO> list = rsvtSvc.getAll();

ArrayList list = (ArrayList) request.getAttribute("rsvtVO"); 
pageContext.setAttribute("list", list);
SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 日期格式轉換
%>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>義鄉人-義式餐酒館-管理中心</title>
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
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
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
</head>

<body class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">
	<!-- ----- ----- ----- 進入網站的讀取圈圈 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- 進入網站的讀取圈圈 end ----- ----- ----- -->
	
	<div class="ms-aside-overlay ms-overlay-left ms-toggler" data-target="#ms-side-nav" data-toggle="slideLeft"></div>
	<div class="ms-aside-overlay ms-overlay-right ms-toggler" data-target="#ms-recent-activity" data-toggle="slideRight"></div>

	<!-- ----- ----- ----- 最左邊的 選擇列 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/LeftSideBar.file"%>
	<!-- ----- ----- ----- 最左邊的 選擇列 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main class="body-content" style="padding-right: 0 px;">
		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
			<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->
		
		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
			<%@ include file="../../back-end/tool/Upicon.file"%>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->
		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->

	<table class="table" id="myTable">
		<tr>
			<th>訂位編號</th>
			<th>會員編號</th>
			<th>桌位編號</th>
			<th>顧客姓名</th>
			<th>顧客電話</th>
			<th>訂位人數</th>
			<th>時段</th>
			<th>入座狀態</th>
			<th>訂位日期</th>
			<th>用餐日期</th>

			<th><FORM METHOD="post" ACTION="RsvtServlet" style="margin-bottom: 0px;" id="search_form">
			<label for="cName">搜尋：</label><input type="text" name="customerName" id="cName" autoComplete="off"> 
				<input type="hidden" name="action" value="getOne_For_CustomerName"></FORM></th>
			<th><input type="submit" class="input_btn" value="送出" id="search_btn"></th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="rsvtVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">
<!-- 					<FORM METHOD="post" ACTION="RsvtServlet" > -->
					
<!-- 			<input type="hidden" name="action" value="update"> <input -->
<!-- 				type="hidden" name="rsvtId" value="" id=""> -->
<!-- 				<input type="submit" value="送出修改"> -->
<!-- 			</FORM> -->
			<tr>
				<td>${rsvtVO.rsvtId}</td>
				<td>${rsvtVO.memId}</td>
				<td>${rsvtVO.tableTypeId}</td>
				<td >${rsvtVO.customerName}</td>
				<td >${rsvtVO.customerPhone}</td>
				<td >${rsvtVO.rsvtNum}</td>
				<td >${rsvtVO.rsvtPeriod == 0 ? "中午" : "晚上"}</td>
				<td >${rsvtVO.rsvtToSeat == 1 ? "未入座" : "已入座"}</td>
				<td >${rsvtVO.rsvtDate}</td>
				<td><fmt:formatDate value="${rsvtVO.rsvtMealDate == null ? '' : rsvtVO.rsvtMealDate}" type="both"/></td>
				
				<td>
					<FORM METHOD="post" ACTION="RsvtServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改" class="input_btn"> 
						<input type="hidden" name="rsvtId" value="${rsvtVO.rsvtId}">
						<input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>

				<td>
					<FORM METHOD="post"
						ACTION="RsvtServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除" class="input_btn"> 
						<input type="hidden" name="rsvtId" value="${rsvtVO.rsvtId}"> 
						<input type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>
		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->
	<script>
	let search_btn = document.getElementById('search_btn');
	let search_form = document.getElementById('search_form');
	search_btn.addEventListener('click',() =>{
		search_form.submit();
	})
	
	</script>
	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
	<script src="../../back-assets/js/bootstrap-datepicker.js"></script>
	<script src="../../back-assets/js/bootstrap-datepicker.zh-TW.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>
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
	<script src="../../back-assets/js/rsvtDatepicker.js"></script>
	<script>
	</script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
</body>

</html>