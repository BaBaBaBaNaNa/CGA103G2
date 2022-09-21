<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="java.util.*"%>
<%@ page import="com.rsvt.model.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.rsvtCtrl.model.*"%>

<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
RsvtCtrlVO rsvtCtrlVO = (RsvtCtrlVO) request.getAttribute("rsvtCtrlVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
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
<!-- <link href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/themes/vader/jquery-ui.css" rel="stylesheet"/> -->
<link href="../../back-assets/css/jquery-ui_1.12.1.css" rel="stylesheet">
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
<style>
.table th, .table td {
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
}

.col-lg-6 {
	margin: 0 auto;
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
		<FORM METHOD="post" ACTION="RsvtCtrlServlet" name="form1">
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
			<div class="col-lg-6">
				<div class="card">
					<div class="card-body">
						<h4 class="mt-0 header-title"><%=rsvtCtrlVO.getRsvtCtrlDate()%></h4>
						<p class="text-muted mb-4 font-14">
							控制編號為:<%=rsvtCtrlVO.getRsvtCtrlId()%></p>
						<div class="form-group mb-0">
							<h6 class="sub-title my-3">訂位時段:</h6>
							<div>
								<div class="input-group">
									<p class="text-muted mb-4 font-14"><%=rsvtCtrlVO.getRsvtCtrlPeriod() == 0 ? "中午" : "晚上"%></p>
									<div class="input-group-append bg-custom b-0"></div>
								</div>
								<!-- input-group -->
							</div>
						</div>
						<div class="form-group mb-0">
							<h6 class="sub-title my-3">開放狀態:</h6>
							<div>
								<div class="input-group">
									<div class="input-group-append bg-custom b-0"
										style="width: 100%;">
										<select name="rsvtCtrlOpen" class="form-control" id="period">
											<option value="0"
												<%=rsvtCtrlVO.getRsvtCtrlOpen() == 0 ? "selected" : ""%>>開放</option>
											<option value="1"
												<%=rsvtCtrlVO.getRsvtCtrlOpen() == 1 ? "selected" : ""%>>不開放</option>
										</select> <span class="input-group-text"></span>
									</div>
								</div>
								<!-- input-group -->
							</div>
						</div>
						<div class="form-group mb-0">
							<h6 class="sub-title my-3">訂位上限:</h6>
							<div>
								<div class="input-group">
									<p class="text-muted mb-4 font-14"></p>
									<input type="text" class="form-control" name="rsvtCtrlMax"
										value="<%=rsvtCtrlVO.getRsvtCtrlMax()%>">
									<div class="input-group-append bg-custom b-0"></div>
								</div>
								<!-- input-group -->
							</div>
						</div>
					</div>
					<input type="hidden" name="action" value="update"> 
					<input type="hidden" name="rsvtCtrlId" value="<%=rsvtCtrlVO.getRsvtCtrlId()%>">
					<input type="hidden" name="tableTypeId" value="<%=rsvtCtrlVO.getTableTypeId()%>">
					<input type="hidden" name="rsvtCtrlOpen" value="<%=rsvtCtrlVO.getRsvtCtrlOpen()%>">
					<input type="hidden" name="rsvtCtrlPeriod" value="<%=rsvtCtrlVO.getRsvtCtrlPeriod()%>">
					<input type="hidden" name="rsvtCtrlDate" value="<%=rsvtCtrlVO.getRsvtCtrlDate()%>">
					
					<input type="submit" value="送出修改" class="form-control">
				</div>
			</div>

		</FORM>
		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->
	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>
	<!-- Global Required Scripts Start -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- 	<script src="../../back-assets/js/jquery-3.3.1.min.js"></script> -->
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