<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date"%>
<%@ page import="com.rsvtCtrl.model.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
RsvtCtrlVO rsvtCtrlVO = (RsvtCtrlVO) request.getAttribute("rsvtCtrlVO");
java.sql.Date rsvtCtrlDate = null;
try {
	rsvtCtrlDate = rsvtCtrlVO.getRsvtCtrlDate();
} catch (Exception e) {
	rsvtCtrlDate = new java.sql.Date(System.currentTimeMillis());
}
RsvtCtrlService rsvtCtrlSvc = new RsvtCtrlService();
List<RsvtCtrlVO> list = rsvtCtrlSvc.getAll();

String DateString = "";
for (RsvtCtrlVO all : list) {
	//取得不開放的日期
	if (all.getRsvtCtrlOpen() == 1) {
		DateString += "'" + all.getRsvtCtrlDate() + "'" + ",";
	}
}
%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>義鄉人-義式餐酒館-管理中心</title>
<style>
.datepicker{
z-index: 100000 !important;
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
<link href="../../back-assets/css/jquery-ui.min.css" rel="stylesheet">
<!-- Page Specific CSS (Slick Slider.css) -->
<link href="../../back-assets/css/slick.css" rel="stylesheet">
<link href="../../back-assets/css/datatables.min.css" rel="stylesheet">
<!-- Costic styles -->
<link href="../../back-assets/css/style.css" rel="stylesheet">
<!-- Favicon -->
<link rel="icon" type="image/png" sizes="32x32" href="../../favicon.ico">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
<!-- <link rel="stylesheet" -->
<!-- 	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.css"> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css"> -->
<link rel="stylesheet" href="../../back-assets/css/rsvt.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<script src="../../back-assets/js/bootstrap-datepicker.zh-TW.min.js"></script>
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>
<style>
.datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom
	{
	z-index: 100000 !important;
}
</style>
<body class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">
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
	<main class="body-content" style:"padding-right: 0 px;">
		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
		<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->
		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
		<%@ include file="../../back-end/tool/Upicon.file"%>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->
		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		<FORM METHOD="post" ACTION="RsvtCtrlServlet" name="form1">
			<table class="table">
				<tr>
					<td>設定訂位日期:</td>
					<td><input name="rsvtCtrlDate" type="text" placeholder="請選擇日期"
						autoComplete="off" class="mr-2 form-control" size="45" id="datepicker">
						</td>
				</tr>
				<tr>
					<td>設定開放狀態:</td>
					<td><select name="rsvtCtrlOpen">
							<option value="0" selected>開放</option>
							<option value="1">不開放</option>
					</select></td>
				</tr>

				<tr>
					<td>設定訂位時段:</td>
					<td><select name="rsvtCtrlPeriod">
							<option value="0">中午</option>
							<option value="1">晚上</option>
					</select></td>
				</tr>
				<tr>
					<td>設定桌位上限:</td>
					<td><input type="TEXT" name="rsvtCtrlMax" size="45" value="" /></td>
				</tr>
				<%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" /> --%>
				<!-- 	<tr> -->
				<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
				<!-- 		<td><select size="1" name="deptno"> -->
				<%-- 			<c:forEach var="deptVO" items="${deptSvc.all}"> --%>
				<%-- 				<option value="${deptVO.deptno}" ${(rsvtCtrlVO.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname} --%>
				<%-- 			</c:forEach> --%>
				<!-- 		</select></td> -->
				<!-- 	</tr> -->

			</table>
			<br> <input type="hidden" name="action" value="insert">
			<input type="submit" value="送出新增">
		</FORM>

<!-- ----- ----- ----- 中間 end ----- ----- ----- -->
<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
</main>

<!-- ----- ----- ----- Script Start ----- ----- ----- -->
<script>
$('#datepicker').datepicker({
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
        <%=DateString%>
    ],
});
</script>
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
<!-- 	----- ----- ----- Script End ----- ----- ----- -->
</body>
</html>