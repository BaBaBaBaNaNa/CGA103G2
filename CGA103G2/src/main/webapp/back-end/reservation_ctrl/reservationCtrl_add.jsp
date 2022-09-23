<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page import="java.util.*"%>
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
.col-lg-6{
margin: 0 auto;
}
</style>
</head>

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
	<main class="body-content" style="padding-right: 0 px;">
		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
		<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->

		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
		<%@ include file="../../back-end/tool/Upicon.file"%>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->
		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		<FORM METHOD="post" ACTION="RsvtCtrlServlet" name="form1">
			
			<div class="col-lg-6">
				<div class="card">
					<div class="card-body">
						<h4 class="mt-0 header-title">新增訂位控制資料</h4>
						<c:if test="${not empty errorMsgs}">
							<font style="color:red">請修正以下錯誤:</font>
							<ul>
							<c:forEach var="message" items="${errorMsgs}">
							<li style="color:red">${message}</li>
							</c:forEach>
							</ul>
						</c:if>
						<div class="form-group mb-0">
							<h6 class="sub-title my-3">設定日期</h6>
							<div>
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="請選擇日期" name="rsvtCtrlDate" value="<%= rsvtCtrlVO == null ? "" :rsvtCtrlVO.getRsvtCtrlDate() %>" id="dp1" onchange="getPeriod()" autoComplete="off">
									<div class="input-group-append bg-custom b-0">
										<span class="input-group-text"></span>
									</div>
								</div>
								<!-- input-group -->
							</div>
						</div>
						
						<div class="form-group mb-0">
							<h6 class="sub-title my-3">訂位時段</h6>
							<div>
								<div class="input-group">
									<div class="input-group-append bg-custom b-0" style="width: 100%;">
										<select name="rsvtCtrlPeriod" class="form-control" id="period" >
										</select> <span class="input-group-text"></span>
									</div>
								</div>
								<!-- input-group -->
							</div>
						</div>
						<div class="form-group mb-0">
							<h6 class="sub-title my-3">設定上限人數</h6>
							<div>
								<div class="input-group">
									<input type="text" class="form-control" name="rsvtCtrlMax" size="45" value="<%= rsvtCtrlVO == null ? "" :rsvtCtrlVO.getRsvtCtrlMax() %>" maxLength="3" autoComplete="off" />
									<span class="input-group-text"></span>
								</div>
								<!-- input-group -->
							</div>
						</div>
						<div class="form-group mb-0">
							<h6 class="sub-title my-3">設定狀態</h6>
							<div>
								<div class="input-group">
									<div class="input-group-append bg-custom b-0" style="width: 100%;">
										<select name="rsvtCtrlOpen" class="form-control">
											<option value="0" selected>開放</option>
											<option value="1">不開放</option>
										</select> <span class="input-group-text"></span>
									</div>
								</div>
								<!-- input-group -->
							</div>
						</div>
					</div>
					<input type="hidden" name="action" value="insert"> 
					<input type="submit" value="送出修改" class="form-control">
				</div>
			</div>

		</FORM>
<!-- 		///========================================== -->
		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->
	<script>
	</script>
	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>
	<!-- Global Required Scripts Start -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
		var dp1 = document.getElementById('dp1');
		var period = document.getElementById('period');
		const url = '/CGA103G2/back-end/reservation_ctrl/getCtrlPeriod';
	// 時段選擇後 查詢剩餘人數
	function getPeriod(){
		fetch(url,{
			method: 'post',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({
				date : dp1.value,
			})
		})
		.then(res => res.json())
		.then(leavePeriod => {
				period.textContent = "";
				console.log(leavePeriod);
				for(let key of leavePeriod){
					const option = document.createElement('option');
					option.value = key;
					switch (key){
						case '0':{
							option.textContent = '中午';
							break;
						}
						case '1':{
							option.textContent = '晚上'
							break;
						}
					}
					period.append(option);
				}
			})
	}
// 	===============頁面載入取得設定剩餘日期===============
	const arr = [];
	const dateUrl = '/CGA103G2/back-end/reservation_ctrl/getSetDates';
	fetch(dateUrl,{
			headers: {
				'Content-Type': 'application/json'
			},
		})
		.then(res => res.json())
			.then(list => {
				console.log(list);
				for(let key of list){
					arr.push(key);
				}
			})
	var disabledDates = arr;
	$(function() {
		$("#dp1").datepicker({
			dateFormat: 'yy-mm-dd',
			changeMonth: true,
		    daysOfWeekDisabled: [3],  //每周隱藏的第幾天  0為周日6為星期六
		    todayHighlight: true,
		    minDate:1,
// 		    maxDate: 0,
			firstDay:1,
			// jQuery日期禁用
		    beforeShowDay: function(date){
		          //format date in datepicker to dd-mm-yy
		           var date1 = $.datepicker.formatDate('yy-mm-dd', date);
		          //disable dates
		          if(date.getDay() === 3){
		          	return [false]
		          }else{
		           	return [ disabledDates.indexOf(date1) == -1]
		          	}
		          },
		});
	});
	
	// 日期選擇後 查詢當前時段剩餘人數
// 	function checkPeriod(){
// 		fetch(periodUrl,{
// 			method: 'post',
// 			headers: {
// 				'Content-Type': 'application/json'
// 			},
// 			body: JSON.stringify({
// 				rsvtCtrlDate : dp1.value,
// 				rsvtNum : num.value
// 			})
// 		})
// 		.then(res => res.json())
// 		.then(periodList => {
// 			console.log(periodList)
// 			period.textContent = "";
// 			if(periodList.length != 0){
// 				period.textContent = "";
// 				let n = 0;
// 				for(let i = 0; i < periodList.length; i++){
// 					if(i == n){
// 						const option = document.createElement('option');
// 						option.value = periodList[i];
// 						switch (periodList[i]){
// 							case 0 :{
// 								option.textContent = '中午';
// 								break;
// 							}
// 							case 1 :{
// 								option.textContent = '晚上';
// 								break;
// 							}
// 							default :{
// 								option.textContent = '未有時段';
// 							}
// 						}
// 						period.append(option);

// 					}else{
// 						num.max = periodList[i];
// 					}
// 					n += 2;
// 				}
// 			}else{
// 				const option = document.createElement('option');
// 				option.textContent = '未有時段';
// 				period.append(option);
// 			}
// 		})
// 	}
	$.datepicker.regional['zh-TW']={
			   dayNames:["星期日","星期一","星期二","星期三","星期四","星期五","星期六"],
			   dayNamesMin:["日","一","二","三","四","五","六"],
			   monthNames:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
			   monthNamesShort:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
			   prevText:"上月",
			   nextText:"次月",
			   weekHeader:"週"
			};
	$.datepicker.setDefaults($.datepicker.regional["zh-TW"]);
	</script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
</body>

</html>
