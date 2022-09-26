<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*,com.mem.model.*"%>

<%
MemVO memVO = (MemVO) request.getAttribute("memVO"); //MemServlet.java (Concroller) 存入req的memVo物件 (包括幫忙取出的memVO, 也包括輸入資料錯誤時的memVO物件)
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

<link href="../../front-assets/bootstrap_css/bootstrap.min.css"
	rel="stylesheet">

<link href="../../front-assets/bootstrap_css/bootstrap-icons.css"
	rel="stylesheet">

<link href="../../front-assets/css/tooplate-crispy-kitchen.css"
	rel="stylesheet">

<link href="../../front-assets/css/navbar.css" rel="stylesheet">

<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>


<body>

	<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->
	
	<!-- ----- ----- ----- 最上面 選擇列 start ----- ----- ----- -->
	<%@ include file="../../front-end/tool/UpSideBarNoRSVT.file"%>
	<!-- ----- ----- ----- 最上面 選擇列 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main>
		<!-- ----- ----- ----- 中間上面 start ----- ----- ----- -->
		<header> </header>
		<!-- ----- ----- ----- 中間上面 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main class="body-content"padding-right: 0 px;>
		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
		
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->

		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
		
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->

		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		<h2>會員資料修改!</h2>

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
				
					<td><input type="hidden" name="memID"
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
									<td>會員性別</td>
					<td>
					<select name="memGender">
					<option value="0" <%=memVO.getMemGender() == 0 ? "selected": ""%>>男生</option>
					<option value="1" <%=memVO.getMemGender() == 1 ? "selected": ""%>>女生</option>
					</select>
					</td>
				<tr>
					
					<td><input type="hidden" name="memPermission"
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
					<td><input type="text" id="f_date1" name="memBirthday"
						value="<%=memVO.getMemBirthday()%>" required /></td>
				</tr>

			</table>
			<br>
			<div>
				<input type="hidden" name="action" value="updateForMem"> <input
					type="hidden" name="memID" value="<%=memVO.getMemID()%>"> <input
					type="submit" value="送出修改">
			</div>
		</form>
	</main>


<!-- 測試修改密碼用 -->
<!-- 			<div> -->
<!-- 				<input type="hidden" name="action" value=updateMemPW> <input -->
<%-- 					type="hidden" name="memID" value="<%=memVO.getMemID()%>"> <input --%>
<!-- 					type="submit" value="送出修改"> -->
<!-- 			</div> -->
<!-- 		</form> -->
<!-- 	</main> -->


	<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<!-- ----- ----- ----- Script Start ----- ----- ----- -->

	<!-- Page Specific Scripts Finish -->

	<!-- ----- ----- ----- Script End ----- ----- ----- -->
	

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

	<!-- ----- ----- ----- 跳出預先訂位頁面 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<script src="../../front-assets/js/jquery.min.js"></script>
	<script src="../../front-assets/bootstrap_js/bootstrap.bundle.min.js"></script>
	<script src="../../front-assets/js/custom.js"></script>
	<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

</body>
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

</html>
