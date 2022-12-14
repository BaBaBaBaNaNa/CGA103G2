<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mem.model.*"%>
<%@ page import="java.util.*,com.mem.controller.MemServlet"%>
<%
MemVO memVO = (MemVO) request.getAttribute("memVO");
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>義鄉人-義式餐酒館-管理中心</title>
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
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
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
		<h3>會員資料新增</h3>
		>

		<%-- 錯誤表列 --%>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>

		<FORM METHOD="post" ACTION="mem.do" name="form1">
			<table>
				<tr>
					<td>會員姓名:</td>
					<td><input type="TEXT" name="memName" size="50"
						value="<%=(memVO == null) ? "Leo" : memVO.getMemName()%>" /></td>
				</tr>
				<tr>
					<td>會員帳號:</td>
					<td><input type="TEXT" name="memAccount" size="20"
						value="<%=(memVO == null) ? "wowowoo" : memVO.getMemAccount()%>" /></td>
				</tr>
				<tr>
					<td>會員密碼:</td>
					<td><input type="TEXT" name="memPassword" size="20"
						value="<%=(memVO == null) ? "a123123" : memVO.getMemPassword()%>" /></td>
				</tr>
				<tr>
				
					<td>會員性別:</td>
					<td><select name="memGender">
							<option value="0">男生</option>
							<option value="1">女生</option>
					</select></td>
				</tr>
				<tr>
					<td>會員權限:</td>
					<td><input type="TEXT" name="memPermission" size="20"
						value="<%=(memVO == null) ? "0" : memVO.getMemPermission()%>" /></td>
				</tr>
				<tr>
					<td>會員電話:</td>
					<td><input type="TEXT" name="memPhone" size="20"
						value="<%=(memVO == null) ? "987654321" : memVO.getMemPhone()%>" /></td>
				</tr>
				<tr>
					<td>會員信箱:</td>
					<td><input type="TEXT" name="memEmail" size="100"
						value="<%=(memVO == null) ? "aa@aaa.com" : memVO.getMemEmail()%>" /></td>
				</tr>
				<tr>
					<td>會員地址:</td>
					<td><input type="TEXT" name="memAddress" size="100"
						value="<%=(memVO == null) ? "市區街巷弄" : memVO.getMemAddress()%>" /></td>
				</tr>
				<tr>
					<td>會員生日:</td>
					<td><input name="memBirthday" id="f_date1" type="text"></td>
				</tr>
			</table>
			<br> <input type="hidden" name="action" value="insert">
			<input type="submit" value="送出新增">
		</FORM>
</body>
</main>

<body>
	<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->
	
	<%
	
	java.sql.Date memBirthday = null;
	try {
		memBirthday = memVO.getMemBirthday();
	} catch (Exception e) {
		memBirthday = new java.sql.Date(System.currentTimeMillis());
	}
	%>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back-assets/datetimepicker/jquery.datetimepicker.css" />
	<script src="${pageContext.request.contextPath}/back-assets/datetimepicker/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/datetimepicker/jquery.datetimepicker.full.js"></script>
	
	
	<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
	width: 300px; /* width:  300px; */
}

  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
	height: 151px; /* height:  151px; */
}
</style>

<script>
	

        $.datetimepicker.setLocale('zh'); // kr ko ja en
        $('#f_date1').datetimepicker({
           theme: '',          //theme: 'dark',
           timepicker:false ,  //timepicker: false,
           step: 1,            //step: 60 (這是timepicker的預設間隔60分鐘)
	       format: 'Y-m-d',
	       value: '<%=memBirthday%>', // value:   new Date(),
           //disabledDates:    ['2022/06/08','2022/06/09','2022/06/10'], // 去除特定不含
           //startDate:	        '2022/07/10',  // 起始日
           //minDate:           '-1970-01-01', // 去除今日(不含)之前
           //maxDate:           '+1970-01-01'  // 去除今日(不含)之後
        });
</script>
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