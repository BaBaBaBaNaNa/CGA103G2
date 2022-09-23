<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!-- empStyle -->
<link href="../../back-assets/css/empStyle.css" rel="stylesheet">

<link href="../../back-assets/css/empDetailStyle.css" rel="stylesheet">
<!-- 台灣地址選擇 -->
<link href="../../back-assets/css/tw-city-selector.css" rel="stylesheet">
<!-- GoTop -->
<link href="${pageContext.request.contextPath}/back-assets/css//gotop/GoTop.css" rel="stylesheet">
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
	<main class="body-content">

		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
		<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->

		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb pl-0">
				<li class="breadcrumb-item"><a href="../../back-end/index/BackIndex.jsp"><i
						class="material-icons">home</i>首頁</a></li>
				<li class="breadcrumb-item">員工管理</li>
				<li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath}/back-end/employee/empAdd.jsp">新增員工資料</a></li>
			</ol>
		</nav>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->

		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		<div class="ms-auth-form">
			<form METHOD="post" ACTION="EmpServlet.do" name="form1">
				<h3>新增員工帳號</h3>

				<div class="form-row">
					<div class="col-md-12 ">
						<label>員工姓名</label><p>${errorMsgs.empName}</p>
						<div class="input-group">
							<input type="text" name="empName" value="${param.empName}" class="form-control" placeholder="請輸入員工姓名">
						</div>
					</div>
					<div class="col-md-12 ">
						<label>帳號:[請輸入Email信箱]</label><p>${errorMsgs.empAccount}</p>
						<div class="input-group">
							<input type="text" name="empAccount" value="${param.empAccount}" class="form-control" placeholder="example@gmail.com">
						</div>
					</div>
					<div class="col-md-12 ">
						<label>密碼</label><p>${errorMsgs.empPassword}</p>
						<div class="input-group">
						<input type="password" name="empPassword" value="${param.empPassword}" class="form-control" placeholder="請輸入密碼">
						</div>
					</div>
					<div class="col-md-12 ">
						<label>權限</label>
						<div class="input-group">
						<select name="empPermission" class="form-control">
							<option value="0" ${(param.empPermission== "0") ? 'selected' : '' }>正常</option>
							<option value="1" ${(param.empPermission== "1") ? 'selected' : '' }>停權</option>
						</select>
						</div>
					</div>
					<div class="col-md-12 ">
						<label>電話</label><p>${errorMsgs.empPhone}</p>
						<div class="input-group">
						<input type="text" name="empPhone" value="${param.empPhone}" class="form-control" placeholder="請輸入員工電話">
						</div>
					</div>
					<div class="col-md-12 ">
						<label>地址</label><p>${errorMsgs.empAddress}</p>
						<div class="input-group">
							<input type="text" name="empAddress" value="${param.empAddress}" class="form-control" placeholder="請輸入地址">
						</div>
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
					</div>
					<div class="col-md-12 ">
						<label>雇用日期</label><p>${errorMsgs.empHiredate}</p>
						<div class="input-group">
						<input type="text" name="empHiredate" id="f_date1" value="${param.empHiredate}" class="form-control">
						</div>
					</div>
				</div>
				<input type="hidden" name="action" value="insert">
				<input class="btn btn-primary mt-4 d-block w-100" type="submit" value="送出新增">
			</form>
		</div>
		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
		<!-- ----- ----- -----   按鈕-回到網頁最上面 start ----- ----- ----- -->
		<button type="button" id="GoTop" class="GoTop-arrow"></button>
		<!-- ----- ----- -----   按鈕-回到網頁最上面 end ----- ----- ----- -->
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
	<!-- GoTop -->
	<script src="${pageContext.request.contextPath}/back-assets/js/gotop/GoTop.js"></script>
	<!-- 台灣地址選擇 -->
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.4.1/dist/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/twcityselector/tw-city-selector.js"></script>
<!-- 	<script src="https://cdn.jsdelivr.net/npm/tw-city-selector@2.1.0/dist/tw-city-selector.min.js"></script> -->
	<script>
// 		new TwCitySelector();
		new TwCitySelector({
			  el: '.city-selector-set-has-value',
			  elCounty: '.county',
			  elDistrict: '.district',
			  elZipcode: '.zipcode'
			});
	</script>
	<style>
	.city-selector-set-has-value{
		display:left;
	}
	.zipcode{
  		width: 33%;
  		display: inline-block;
  		height: calc(1.5em + .75rem + 2px);
  		padding: .375rem .75rem;
  		font-size: 1rem;
  		font-weight: 400;
  		line-height: 1.5;
  		color: #495057;
  		background-color: #fff;
  		background-clip: padding-box;
  		border: 1px solid #ced4da;
  		border-radius: .25rem;
 		transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
		}
	</style>
	
	
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
	   value: '<%=empHiredate%>'
	   	// value:   new Date(),
		//disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
		//startDate:	            '2017/07/10',  // 起始日
		//minDate:               '-1970-01-01', // 去除今日(不含)之前
		//maxDate:               '+1970-01-01'  // 去除今日(不含)之後
		});
	</script>
</body>

</html>