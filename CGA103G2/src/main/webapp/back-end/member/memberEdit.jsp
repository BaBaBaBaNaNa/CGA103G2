<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*,com.mem.model.*"%>

<%
MemVO memVO = (MemVO) request.getAttribute("memVO"); //MemServlet.java (Concroller) 存入req的memVo物件 (包括幫忙取出的memVO, 也包括輸入資料錯誤時的memVO物件)
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
<!-- empStyle -->
<link href="../../back-assets/css/empStyle.css" rel="stylesheet">
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>

<body
	class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">
	<!-- ----- ----- ----- 進入網站的讀取圈圈 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- 進入網站的讀取圈圈 end ----- ----- ----- -->
	<!-- Overlays -->
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
		<h2>修改會員訊息</h2>

		<%-- 錯誤表列 --%>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>

		<form
			action="${pageContext.request.contextPath}/back-end/member/mem.do"
			name="form1" method="post">
			<!-- 		<FORM METHOD="post" ACTION="mem.do" name="form1"> -->
			<table>

				<tr>
					<td>會員編號</td>
					<td><input type="text" name="memID"
						value="<%=memVO.getMemID()%>" required /></td>
				</tr>
				<tr>
					<td>會員姓名</td>
					<td><input type="text" name="memName"
						value="<%=memVO.getMemName()%>" required /></td>
				</tr>
				<tr>
					<td>會員帳號</td>
					<td><input type="text" name="memAccount"
						value="<%=memVO.getMemAccount()%>" required /></td>
				</tr>
				<tr>
					<td>密碼</td>
					<td><input type="text" name="memPassword"
						value="<%=memVO.getMemPassword()%>" required /></td>
				</tr>
				<tr>
					<td>會員性別</td>
					<td>
					<select name="memGender">
					<option value="0" <%=memVO.getMemGender() == 0 ? "selected": ""%>>男生</option>
					<option value="1" <%=memVO.getMemGender() == 1 ? "selected": ""%>>女生</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>權限</td>
					<td><input type="text" name="memPermission"
						value="<%=memVO.getMemPermission()%>" required /></td>
				</tr>
				<tr>
					<td>電話</td>
					<td><input type="text" name="memPhone"
						value="<%=memVO.getMemPhone()%>" required /></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="memAddress"
						value="<%=memVO.getMemAddress()%>" required /></td>
				</tr>
				<tr>
					<td>信箱</td>
					<td><input type="text" name="memEmail"
						value="<%=memVO.getMemEmail()%>" required /></td>
				</tr>
				<tr>
					<td>生日</td>
					<td><input type="text" name="memBirthday"
						value="<%=memVO.getMemBirthday()%>" required /></td>
				</tr>

			</table>
			<br>
			<div>
				<input type="hidden" name="action" value="update"> <input
					type="hidden" name="memID" value="<%=memVO.getMemID()%>"> <input
					type="submit" value="送出修改">
			</div>
		</form>
	</main>


	<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
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
	<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->
	<%
	java.sql.Date memBirthday = null;
	try {
		memBirthday = memVO.getMemBirthday();
	} catch (Exception e) {
		memBirthday = new java.sql.Date(System.currentTimeMillis());
	}
	%>

	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/back-assets/datetimepicker/jquery.datetimepicker.css" />
	<script
		src="${pageContext.request.contextPath}/back-assets/datetimepicker/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/back-assets/datetimepicker/jquery.datetimepicker.full.js"></script>

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
	   value: '<%=memBirthday%>
	', // value:   new Date(),
	//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
	//startDate:	            '2017/07/10',  // 起始日
	//minDate:               '-1970-01-01', // 去除今日(不含)之前
	//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
	});
</script>
</body>

</html>