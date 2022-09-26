<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*,com.emp.model.EmpVO"%>

<%
EmpVO empVO = (EmpVO) request.getAttribute("empVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
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
<!-- empStyle -->
<link href="../../back-assets/css/empStyle.css" rel="stylesheet">

<link href="../../back-assets/css/empDetailStyle.css" rel="stylesheet">
<!-- GoTop -->
<link href="${pageContext.request.contextPath}/back-assets/css//gotop/GoTop.css" rel="stylesheet">
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
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
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb pl-0">
				<li class="breadcrumb-item"><a href="../../back-end/index/BackIndex.jsp"><i
						class="material-icons">home</i>首頁</a></li>
				<li class="breadcrumb-item">員工管理</li>
				<li class="breadcrumb-item active" aria-current="page">修改員工資料</li>
			</ol>
		</nav>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->

		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		<div class="ms-auth-form">
			<form METHOD="post" ACTION="EmpServlet.do" name="form1">
				<h3>修改員工帳號</h3>
				<hr>
				<div class="form-row">
					<div class="col-md-12 ">
						<label>員工編號 [不可修改]</label>
						<div class="input-group">
							<input type="text" name="empID" value="${param.empID}" class="form-control" readonly="readonly">
						</div>
						<hr>
					</div>
					<div class="col-md-12 ">
						<label>員工姓名</label><p style="color:red;">${errorMsgs.empName}</p>
						<div class="input-group">
							<input type="text" name="empName" value="${param.empName}" class="form-control" placeholder="請輸入員工姓名">
						</div>
						<hr>
					</div>
					<div class="col-md-12 ">
						<label>帳號 [不可修改]</label><p style="color:red;">${errorMsgs.empAccount}</p>
						<div class="input-group">
							<input type="text" name="empAccount" value="${param.empAccount}" class="form-control" placeholder="example@gmail.com" readonly="readonly">
						</div>
						<hr>
					</div>
					<div class="col-md-12 ">
						<label>密碼</label><p style="color:red;">${errorMsgs.empPassword}</p>
						<div class="input-group">
						<input type="password" name="empPassword" value="${param.empPassword}" class="form-control" placeholder="請輸入密碼">
						</div>
						<hr>
					</div>
					<div class="col-md-12 ">
						<label>權限</label>
						<div class="input-group">
						<select name="empPermission" class="form-control">
							<option value="0" ${(param.empPermission== "0") ? 'selected' : '' }>正常</option>
							<option value="1" ${(param.empPermission== "1") ? 'selected' : '' }>停權</option>
						</select>
						</div>
						<hr>
					</div>
					<div class="col-md-12 ">
						<label>電話</label><p style="color:red;">${errorMsgs.empPhone}</p>
						<div class="input-group">
						<input type="text" name="empPhone" value="${param.empPhone}" class="form-control" placeholder="請輸入員工電話">
						</div>
						<hr>
					</div>
					<div class="col-md-12 ">
						<label>地址</label><p style="color:red;">${errorMsgs.empAddress}</p>
						<div class="input-group">
						<input type="text" name="empAddress" value="${param.empAddress}" class="form-control" placeholder="請輸入員工地址">
						</div>
						<hr>
					</div>
					<jsp:useBean id="jobSvc" scope="page" class="com.job.model.JobService" />
					<div class="col-md-12 ">
						<label>職位</label>
						<div class="input-group">
						<select size="1" name="jobID" class="form-control">
							<c:forEach var="jobVO" items="${jobSvc.all}">
								<option value="${jobVO.jobID}" ${(param.jobID==jobVO.jobID)?'selected':'' }>${jobVO.jobName}
							</c:forEach>
						</select>
						</div>
						<hr>
					</div>
					<div class="col-md-12 ">
						<label>雇用日期</label><p style="color:red;">${errorMsgs.empHiredate}</p>
						<div class="input-group">
						<input type="text" name="empHiredate" id="f_date1" value="${param.empHiredate}" class="form-control">
						</div>
						<hr>
					</div>
				<input type="hidden" name="action" value="update">
				<input class="btn btn-primary mt-4 d-block w-100" type="submit" value="送出修改">
			</form>
		</div>
		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
		<!-- ----- ----- -----   按鈕-回到網頁最上面 start ----- ----- ----- -->
		<button type="button" id="GoTop" class="GoTop-arrow"></button>
		<!-- ----- ----- -----   按鈕-回到網頁最上面 end ----- ----- ----- -->
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
	<!-- GoTop -->
	<script src="${pageContext.request.contextPath}/back-assets/js/gotop/GoTop.js"></script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
	<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->
	<%
	java.sql.Date empHiredate = null;
	try {
		empHiredate = empVO.getEmpHiredate();
	} catch (Exception e) {
		empHiredate = new java.sql.Date(System.currentTimeMillis());
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

	<script type="text/javascript">
    $.datetimepicker.setLocale('zh');
    $('#f_date1').datetimepicker({
       theme: '',              //theme: 'dark',
       timepicker:false,       //timepicker:true,
       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
       format:'Y-m-d',         //format:'Y-m-d H:i:s',
<%-- 	   value: '<%=empHiredate%>', --%>
	   	// value:   new Date(),
		//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
		//startDate:	            '2017/07/10',  // 起始日
		//minDate:               '-1970-01-01', // 去除今日(不含)之前
		//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
		});
	</script>
</body>

</html>