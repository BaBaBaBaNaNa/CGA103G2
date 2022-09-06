<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*"%>
<%@ page import="com.rsvt.model.*"%>
<%@ page import="java.text.SimpleDateFormat" %>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
RsvtVO rsvtVO = (RsvtVO) request.getAttribute("rsvtVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 日期格式轉換
%>
<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>義鄉人-義式餐酒館-管理中心</title>
<style>
th,td{
}
</style>
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
.input_btn {
	border-radius: 10px;
	border: none;
	width: 50px;
	height: 50px;
}

.input_btn:active {
	box-shadow: inset -1px -1px 1px 1 red;
}

.input_btn:hover {
	cursor: pointer;
	background-image: linear-gradient(90deg, #FA748B 0%, #f5a623 100%);
	color: #fff;
	box-shadow: 0px 10px 5px -2px rgba(0, 0, 0, 0.3);
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
	<main class="body-content"padding-right: 0 px;>
		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
			<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->
		
		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
			<%@ include file="../../back-end/tool/Upicon.file"%>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->
		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
	<FORM METHOD="post" ACTION="RsvtServlet" name="form1">
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
			<th></th>
			<th></th>
		</tr>
		<tr>
			<td><input type="text" value="<%=rsvtVO.getRsvtId() %>" readonly></td>
			<td><input type="text" value="<%=rsvtVO.getMemId() %>" readonly></td>
			<td><input type="text" value="<%=rsvtVO.getTableTypeId() %>" readonly></td>
			<td><input type="text" name="customerName" value="<%=rsvtVO.getCustomerName() %>"></td>
			<td><input type="text" name="customerPhone" value="<%=rsvtVO.getCustomerPhone()%>"></td>
			<td><input type="text" name="rsvtNum" value="<%=rsvtVO.getRsvtNum() %>"></td>
			<td><select name="rsvtPeriod">
				<option value="0" <%=rsvtVO.getRsvtPeriod() == 0 ? "selected" : ""%>>中午</option>
				<option value="1" <%=rsvtVO.getRsvtPeriod() == 1 ? "selected" : ""%>>晚上</option>
				</select>
			</td>
			<td><select name="rsvtToSeat">
				<option value="0" <%=rsvtVO.getRsvtToSeat() == 0 ? "selected" : ""%>>未入座</option>
				<option value="1" <%=rsvtVO.getRsvtToSeat() == 1 ? "selected" : ""%>>已入座</option>
				</select>
			</td>
			<td><input type="text" name="rsvtDate" value="<%=rsvtVO.getRsvtDate()%>" class="datepicker"></td>
			<td>
				<input type="hidden" name="action" value="update"> 
				<input type="hidden" name="rsvtId" value="<%=rsvtVO.getRsvtId()%>">
				<input type="submit" value="送出修改">
			</td>
			</tr>
	</table>
	</FORM>
		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->
	<script>
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
	$('.datepicker').datepicker({
        autoclose: true, // 選擇後自動關閉日期選擇器
        language: 'zh-TW', // 語言切換 中文
        format: 'yyyy-mm-dd', // 日期格式
        todayHighlight: true, // 高亮"當天日期"
        toggleActive: true, // 	點擊選擇，再次點擊取消
        startDate: new Date(), //開放初始日期 ex=> 
        // endDate:new Date(),
        // clearBtn: true, //顯示清除按鈕
        daysOfWeekDisabled: [3],  //每周隱藏的第幾天  0為周日6為星期六
        datesDisabled: [ // 特殊日期禁用
<%--             <%=DateString%> --%>
        ],
    });
	</script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
</body>

</html>