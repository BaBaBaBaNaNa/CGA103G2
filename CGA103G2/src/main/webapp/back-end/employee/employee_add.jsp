<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.emp.controller.EmpServlet"%>
<%@ page import="com.emp.model.*"%>

<%
EmpVO empVO = (EmpVO) request.getAttribute("empVO");
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
<style type="text/css">
table {
	border: 0px solid black;
	margin: 0 auto;
}

td {
	width: 150px;
	border: 1px solid black;
	text-align: center;
}
</style>
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
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
		<%-- 錯誤表列 --%>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>

		<FORM METHOD="post" ACTION="emp.do" name="form1">
			<table>
				<tr>
					<td>ID:</td>
					<td><input type="TEXT" name="emp_id" size="45" value="<%=(empVO == null) ? "Lock" : empVO.getEmp_id()%>" readonly /></td>
				</tr>
				<tr>
					<td>員工姓名:</td>
					<td><input type="TEXT" name="emp_name" size="45" value="<%=(empVO == null) ? "吳永志" : empVO.getEmp_name()%>" /></td>
				</tr>
				<tr>
					<td>帳號:</td>
					<td><input type="TEXT" name="emp_account" size="45" value="<%=(empVO == null) ? "empxx" : empVO.getEmp_account()%>" /></td>
				</tr>
				<tr>
					<td>密碼:</td>
					<td><input type="TEXT" name="emp_password" size="45" value="<%=(empVO == null) ? "**********" : empVO.getEmp_password()%>" /></td>
				</tr>
				<tr>
					<td>權限:</td>
					<td><input type="TEXT" name="emp_permission" size="45" value="<%=(empVO == null) ? "" : empVO.getEmp_permission()%>" /></td>
				</tr>
				<tr>
					<td>電話:</td>
					<td><input type="TEXT" name="emp_phone" size="45" value="<%=(empVO == null) ? "" : empVO.getEmp_phone()%>" /></td>
				</tr>
				<tr>
					<td>地址:</td>
					<td><input type="TEXT" name="emp_address" size="45" value="<%=(empVO == null) ? "" : empVO.getEmp_address()%>" /></td>
				</tr>
				<tr>
					<td>職位:</td>
					<td><input type="TEXT" name="emp_job" size="45" value="<%=(empVO == null) ? "" : empVO.getEmp_job()%>" /></td>
				</tr>
				<tr>
					<td>雇用日期:</td>
					<td><input name="emp_hiredate" id="f_date1" type="text"></td>
				</tr>

			</table>
			<br> <input type="hidden" name="action" value="insert"> <input type="submit" value="送出新增">
		</FORM>
		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->

	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
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
	
	<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->
	<%
	java.sql.Date emp_hiredate = null;
	try {
		emp_hiredate = empVO.getEmp_hiredate();
	} catch (Exception e) {
		emp_hiredate = new java.sql.Date(System.currentTimeMillis());
	}
	%>

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/back-assets/datetimepicker/jquery.datetimepicker.css" />
	<script src="<%=request.getContextPath()%>/back-assets/datetimepicker/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/back-assets/datetimepicker/jquery.datetimepicker.full.js"></script>

	<style>
.xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

.xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

	<script type="text/javascript">
    $.datetimepicker.setLocale('zh');
    $('#f_date1').datetimepicker({
       theme: '',              //theme: 'dark',
       timepicker:false,       //timepicker:true,
       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
       format:'Y-m-d',         //format:'Y-m-d H:i:s',
	   value: '<%=emp_hiredate%>
		', // value:   new Date(),
		//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
		//startDate:	            '2017/07/10',  // 起始日
		//minDate:               '-1970-01-01', // 去除今日(不含)之前
		//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
		});
	</script>

</body>

</html>