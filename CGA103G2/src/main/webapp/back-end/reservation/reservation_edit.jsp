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
RsvtVO rsvtVO = (RsvtVO) request.getAttribute("rsvtVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
RsvtCtrlService rcSvc = new RsvtCtrlService();
List<RsvtCtrlVO> rcList = rcSvc.getOneDate(rsvtVO.getRsvtDate().toString());
Integer leave = 0 + rsvtVO.getRsvtNum();
for(RsvtCtrlVO obj : rcList){
	if(obj.getRsvtCtrlPeriod() == rsvtVO.getRsvtPeriod()){
		leave = obj.getRsvtCtrlMax() - obj.getRsvtCtrlNumber() + rsvtVO.getRsvtNum();
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
		<FORM METHOD="post" ACTION="RsvtServlet" name="form1">
			<c:if test="${not empty errorMsgs}">
				<font style="color:red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color:red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
			<div class="col-lg-6">
				<div class="card">
					<div class="card-body">
						<h4 class="mt-0 header-title">訂位資料</h4>
						<p class="text-muted mb-4 font-14">
							訂位編號為:<%=rsvtVO.getRsvtId()%></p>
						<div class="form-group mb-0">
							<h6 class="sub-title mb-3">顧客姓名</h6>
							<div>
								<div class="input-group">
									<input type="text" class="form-control" name="customerName"
										value="<%=rsvtVO.getCustomerName()%>">
									<div class="input-group-append bg-custom b-0">
										<span class="input-group-text"></span>
									</div>
								</div>
								<!-- input-group -->
							</div>
						</div>
						<div class="form-group mb-0">
							<h6 class="sub-title my-3">顧客電話</h6>
							<div>
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="09123456789" maxLength="10" name="customerPhone"
										value="<%=rsvtVO.getCustomerPhone()%>">
									<div class="input-group-append bg-custom b-0">
										<span class="input-group-text"></span>
									</div>
								</div>
								<!-- input-group -->
							</div>
						</div>
						<div class="form-group mb-0">
							<h6 class="sub-title my-3">訂位日期</h6>
							<div>
								<div class="input-group">
									<input type="text" class="form-control"
										placeholder="請選擇日期" name="rsvtDate" value="<%= rsvtVO.getRsvtDate()%>" id="dp1" onchange="checkPeriod()">
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
										<select name="rsvtPeriod" class="form-control" id="period" onchange="getPeriodLeave()">
											<option value="0"
												<%=rsvtVO.getRsvtPeriod() == 0 ? "selected" : ""%>>中午</option>
											<option value="1"
												<%=rsvtVO.getRsvtPeriod() == 1 ? "selected" : ""%>>晚上</option>
										</select> <span class="input-group-text"></span>
									</div>
								</div>
								<!-- input-group -->
							</div>
						</div>
						<div class="form-group mb-0">
							<h6 class="sub-title my-3">訂位人數</h6>
							<div>
								<div class="input-group">
									<input type="range" class="form-control" name="rsvtNum"
										value="<%=rsvtVO.getRsvtNum()%>" onmousemove="getRsvtNumVal()" onchange="getRsvtNumVal()">
									<span id="numVal"></span>
								</div>
								<!-- input-group -->
							</div>
						</div>
						<div class="form-group mb-0">
							<h6 class="sub-title my-3">入座狀態</h6>
							<div>
								<div class="input-group">
									<div class="input-group-append bg-custom b-0" style="width: 100%;">
										<select name="rsvtToSeat" class="form-control">
											<option value="0"
												<%=rsvtVO.getRsvtToSeat() == 0 ? "selected" : ""%>>未入座</option>
											<option value="1"
												<%=rsvtVO.getRsvtToSeat() == 1 ? "selected" : ""%>>已入座</option>
										</select> <span class="input-group-text"></span>
									</div>
								</div>
								<!-- input-group -->
							</div>
						</div>
					</div>
					<input type="hidden" name="action" value="update"> 
					<input type="hidden" name="rsvtId" value="<%=rsvtVO.getRsvtId()%>">
					<input type="submit" value="送出修改" class="form-control">
				</div>
			</div>

		</FORM>
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
		var numVal = document.getElementById('numVal');
		var num = document.querySelector('input[name="rsvtNum"]'); 
		const arr = [];
		const periodUrl = '/CGA103G2/back-end/reservation_ctrl/Period';
		const dateUrl = '/CGA103G2/back-end/reservation_ctrl/Date';
		const periodPath = '/CGA103G2/back-end/reservation_ctrl/getPeriod';
		num.max =  <%=leave%>;
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
					console.log(arr);
		
		var disabledDates = arr;
		numVal.textContent = num.value;
		function getRsvtNumVal(){
			numVal.textContent = num.value;
		}
	// 時段選擇後 查詢剩餘人數
	function getPeriodLeave(){
		fetch(periodPath,{
			method: 'post',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({
				rsvtCtrlDate : dp1.value,
				rsvtPeriod : period.value,
			})
		})
		.then(res => res.json())
			.then(leave => {
			num.max = leave;
			})
	}
	$(function() {
		$("#dp1").datepicker({
			dateFormat: 'yy-mm-dd',
			changeMonth: true,
		    daysOfWeekDisabled: [3],  //每周隱藏的第幾天  0為周日6為星期六
		    todayHighlight: true,
		    minDate:1,
// 		    maxDate: 0,
			firstDay:1,
// 			defaultDate : "-7d",
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
	function checkPeriod(){
		fetch(periodUrl,{
			method: 'post',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify({
				rsvtCtrlDate : dp1.value,
				rsvtNum : num.value
			})
		})
		.then(res => res.json())
		.then(periodList => {
			console.log(periodList)
			period.textContent = "";
			if(periodList.length != 0){
				period.textContent = "";
				let n = 0;
				for(let i = 0; i < periodList.length; i++){
					if(i == n){
						const option = document.createElement('option');
						option.value = periodList[i];
						switch (periodList[i]){
							case 0 :{
								option.textContent = '中午';
								break;
							}
							case 1 :{
								option.textContent = '晚上';
								break;
							}
							default :{
								option.textContent = '未有時段';
							}
						}
						period.append(option);

					}else{
						num.max = periodList[i];
					}
					n += 2;
				}
			}else{
				const option = document.createElement('option');
				option.textContent = '未有時段';
				period.append(option);
			}
		})
	}
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