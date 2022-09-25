<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.mem.model.*"%>
<%@ page import="java.util.*,com.mem.controller.MemServlet"%>
<%
MemVO memVO = (MemVO) request.getAttribute("memVO");
%>
<!doctype html>
<html lang="zh-tw">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="">

<title>義鄉人 - 義式餐酒館 - 會員中心 - 緯育 中壢Java班 CGA_103 第二組</title>

<!-- ----- ----- ----- CSS&Front設定 start ----- ----- ----- -->

<link rel="preconnect" href="https://fonts.googleapis.com">

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>

<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600;700&display=swap"
	rel="stylesheet">

<link
	href="<%=request.getContextPath()%>/front-assets/bootstrap_css/bootstrap.min.css"
	rel="stylesheet">

<link
	href="<%=request.getContextPath()%>/front-assets/bootstrap_css/bootstrap-icons.css"
	rel="stylesheet">

<link
	href="<%=request.getContextPath()%>/front-assets/css/tooplate-crispy-kitchen.css"
	rel="stylesheet">

<link href="<%=request.getContextPath()%>front-assets/css/navbar.css"
	rel="stylesheet">

<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>


<body>
	<!-- ----- ----- ----- 最上面 選擇列 start ----- ----- ----- -->
	<%@ include file="../../front-end/tool/UpSideBar.file"%>
	<!-- ----- ----- ----- 最上面 選擇列 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main>
		<!-- ----- ----- ----- 中間上面 start ----- ----- ----- -->
		<header> </header>
		<!-- ----- ----- ----- 中間上面 end ----- ----- ----- -->

		<!-- ----- ----- ----- 中間內容 start ----- ----- ----- -->

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

					<td><input type="hidden" name="memPermission" size="20"
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
					<td>
						<div id="twzipcode"></div> <input type="TEXT" name="memAddress"
						size="100"
						value="<%=(memVO == null) ? "市區街巷弄" : memVO.getMemAddress()%>" />
					</td>
				</tr>
				<tr>
					<td>會員生日:</td>
					<td><input name="memBirthday" id="f_date1" type="text"></td>
				</tr>
			</table>
			<br> <input type="hidden" name="action" value="insertForMem">
			<input type="submit" value="送出新增">
		</FORM>
</body>
</main>

<body>

	<!-- ----- ----- ----- 中間內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->

	<!-- ----- ----- ----- 底部 start ----- ----- ----- -->
	<footer class="site-footer section-padding">

		<div class="container">

			<div class="row">

				<div class="col-12">
					<h4 class="text-white mb-4 me-5">義式餐酒館</h4>
				</div>

				<div class="col-lg-4 col-md-7 col-xs-12 tooplate-mt30">
					<h6 class="text-white mb-lg-4 mb-3">Location</h6>

					<p>緯育 中壢Java班 CGA_103 第二組</p>

					<a href="https://goo.gl/maps/wcmDpTGaAHn3eWPd7"
						class="custom-btn btn btn-dark mt-2">Directions</a>
				</div>

				<div class="col-lg-4 col-md-5 col-xs-12 tooplate-mt30">
					<h6 class="text-white mb-lg-4 mb-3">Opening Hours</h6>

					<p class="mb-2">Monday - Friday</p>

					<p>17:00 PM - 03:00 AM</p>

					<p>
						Tel: <a href="tel: 03-425-1108" class="tel-link">03-425-1108</a>
					</p>
				</div>

				<div class="col-lg-4 col-md-6 col-xs-12 tooplate-mt30">
					<h6 class="text-white mb-lg-4 mb-3">社群</h6>

					<ul class="social-icon">
						<li><a href="#" class="social-icon-link bi-facebook"></a></li>

						<li><a href="#" class="social-icon-link bi-instagram"></a></li>

						<li><a
							href="https://twitter.com/search?q=tooplate.com&src=typed_query&f=live"
							target="_blank" class="social-icon-link bi-twitter"></a></li>

						<li><a href="#" class="social-icon-link bi-youtube"></a></li>
					</ul>

					<p class="copyright-text tooplate-mt60">
						Copyright © 2022 中壢Java班 CGA_103 緯育 第二組 Co., Ltd. <br>Design:
						<a rel="nofollow" href="" target="_blank">2022 中壢Java班 CGA_103
							緯育 第二組</a>
					</p>

				</div>

			</div>
			<!-- row ending -->

		</div>
		<!-- container ending -->

	</footer>
	<!-- ----- ----- ----- 底部 end ----- ----- ----- -->

	<!-- ----- ----- ----- 跳出預先訂位頁面 start ----- ----- ----- -->
	<div class="modal fade" id="BookingModal" tabindex="-1"
		aria-labelledby="BookingModal" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered modal-xl">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="mb-0">預先訂位</h3>

					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>

				<div class="modal-body d-flex flex-column justify-content-center">
					<div class="booking">

						<form class="booking-form row" role="form" action="#"
							method="post">
							<div class="col-lg-6 col-12">
								<label for="name" class="form-label">您的名字</label> <input
									type="text" name="name" id="name" class="form-control"
									placeholder="Your Name" required>
							</div>

							<div class="col-lg-6 col-12">
								<label for="email" class="form-label">Email</label> <input
									type="email" name="email" id="email" pattern="[^ @]*@[^ @]*"
									class="form-control" placeholder="your@email.com" required>
							</div>

							<div class="col-lg-6 col-12">
								<label for="phone" class="form-label">電話號碼</label> <input
									type="telephone" name="phone" id="phone"
									pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" class="form-control"
									placeholder="123-456-7890">
							</div>

							<div class="col-lg-6 col-12">
								<label for="people" class="form-label">訂位人數</label> <input
									type="text" name="people" id="people" class="form-control"
									placeholder="12 persons">
							</div>

							<div class="col-lg-6 col-12">
								<label for="date" class="form-label">日期</label> <input
									type="date" name="date" id="date" value="" class="form-control">
							</div>

							<div class="col-lg-6 col-12">
								<label for="time" class="form-label">時間</label> <select
									class="form-select form-control" name="time" id="time">
									<option value="5" selected>5:00 PM</option>
									<option value="6">18:00 PM</option>
									<option value="7">19:00 PM</option>
									<option value="8">20:00 PM</option>
									<option value="10">21:00 PM</option>
									<option value="11">22:00 PM</option>
									<option value="12">23:00 PM</option>
									<option value="13">00:00 AM</option>
								</select>
							</div>

							<div class="col-12">
								<label for="message" class="form-label">其他需求:</label>

								<textarea class="form-control" rows="4" id="message"
									name="message" placeholder=""></textarea>
							</div>

							<div class="col-lg-4 col-12 ms-auto">
								<button type="submit" class="form-control">送出</button>
							</div>
						</form>
					</div>
				</div>

				<div class="modal-footer"></div>

			</div>

		</div>
	</div>
	<!-- ----- ----- ----- 跳出預先訂位頁面 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<script src="../../front-assets/js/jquery.min.js"></script>
	<script src="../../front-assets/bootstrap_js/bootstrap.bundle.min.js"></script>
	<script src="../../front-assets/js/custom.js"></script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->

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

	<!-- 下拉式地址註冊表格script  start -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-twzipcode@1.7.14/jquery.twzipcode.min.js"></script>

	<script>
	$("#twzipcode").twzipcode();

	$("#twzipcode_ADV").twzipcode({
	zipcodeIntoDistrict: true, // 郵遞區號自動顯示在地區
	css: ["city form-control", "town form-control"], // 自訂 "城市"、"地區" class 名稱 
	countyName: "zip", // 自訂城市 select 標籤的 name 值
	districtName: "zip" // 自訂地區 select 標籤的 name 值

		/*! Callback */
// 		twzipcode.get(function (data) {
// 			consol.log(8);
		
// 		 data (Array)
// 		    [
// 		        {
// 		            "county": "縣市",
// 		            "district": "鄉鎮市區",
// 		            "zipcode": "郵遞區號",
// 		        }
// 		        …
// 		    ]


	
 	});
	
</script>
	<!-- 下拉式地址註冊表格script  stop -->
	<script>
	

        $.datetimepicker.setLocale('zh'); // kr ko ja en
        $('#f_date1').datetimepicker({
           theme: '',          //theme: 'dark',
           timepicker:false ,  //timepicker: false,
           step: 1,            //step: 60 (這是timepicker的預設間隔60分鐘)
	       format: 'Y-m-d',
	       value: '<%=memBirthday%>
		', // value:   new Date(),
		//disabledDates:    ['2022/06/08','2022/06/09','2022/06/10'], // 去除特定不含
		//startDate:	        '2022/07/10',  // 起始日
		//minDate:           '-1970-01-01', // 去除今日(不含)之前
		//maxDate:           '+1970-01-01'  // 去除今日(不含)之後
		});
	</script>

</body>

</html>