<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet" href="/style.css">

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


<!-- 	註冊欄位的錯誤列表 -->



<!-- ==========登入的錯誤列表======	 -->
<%
if ((request.getAttribute("errorMessage") != null)) {
%>
<script type="text/javascript">
 	alert("<%=request.getAttribute("errorMessage")%>");
</script>
<%
} else {
%>
<%
}
%>
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>


<body>
	<!-- ----- ----- ----- 最上面 選擇列 start ----- ----- ----- -->
	<%@ include file="../../front-end/tool/UpSideBarNoRSVT.file"%>
	<!-- ----- ----- ----- 最上面 選擇列 end ----- ----- ----- -->

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
	<main>
		<!-- ----- ----- ----- 中間上面 start ----- ----- ----- -->
		<header> </header>
		<!-- ----- ----- ----- 中間上面 end ----- ----- ----- -->

		<!-- ----- ----- ----- 中間內容 start ----- ----- ----- -->


		<!-- ----- ----- ----- orignal v1 start ----- ----- ----- -->

		<!-- ----- ----- ----- 會員登入區塊 start ----- ----- ----- -->

		<form name="myform" action="MemLoginServlet.do" method="POST">
			<section class="about section-padding bg-white">
				<div id="logreg-forms">
					<form class="form-signin">
						<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
							異鄉人</h1>

						<p style="text-align: center">會員登入</p>
						<input type="account" name="memAccount" id="inputEmail"
							class="form-control" placeholder="帳號" required="" autofocus="">
						<input type="password" name="memPassword" id="inputPassword"
							class="form-control" placeholder="密碼" required="">

						<button class="btn btn-success btn-block" type="submit"
							valut="Sign In">
							<i class="fas fa-sign-in-alt"></i> Sign in
						</button>

						<!-- 						忘記密碼按鈕 -->
						<!-- 						<a href="#" id="forgot_pswd">Forgot password?</a> -->
						<hr>
						<!-- ----- ----- ----- 會員登入區塊 stop ----- ----- ----- -->


						<!-- <p>Don't have an account!</p>  -->
						<!-- 						----- ----- ----- 註冊帳號按鈕 沒用到  ----- ----- ----- -->
						<!-- 						<button class="btn btn-primary btn-block" type="button" -->
						<!-- 							id="btn-signup"> -->
						<!-- 							<i class="fas fa-user-plus"></i> Sign up New Account -->
						<!-- 						</button> -->
					</form>

					<!-- 重設密碼按鈕 -->
					<!-- 					<form action="/reset/password/" class="form-reset"> -->
					<!-- 						<input type="email" id="resetEmail" class="form-control" -->
					<!-- 							placeholder="忘記密碼? 輸入你的email吧" required="" autofocus=""> -->
					<!-- 						<button class="btn btn-primary btn-block" type="submit">Reset -->
					<!-- 							Password</button> -->
					<!-- 						<a href="#" id="cancel_reset"><i class="fas fa-angle-left"></i> -->
					<!-- 							Back</a> -->
					<!-- 					</form> -->


					<!-- ================原始註冊用的signup action================ -->
					<!-- 					<form action="/signup/" class="form-signup"> -->


					<p style="text-align: center">OR</p>
					<p style="text-align: center">會員註冊</p>


					<FORM METHOD="post" ACTION="mem.do" name="form1">

						<!--                     ==========放註冊表單用的================ -->
						<!-- 						<input type="text" id="user-name" name="memName" class="form-control" -->
						<%-- 							placeholder="姓名" required="" autofocus="" value="<%=(memVO == null) ? "Leo" : memVO.getMemName()%>"> <input --%>
						<!-- 							type="text" id="user-account" name="memAccount" class="form-control" -->
						<%-- 							placeholder="帳號" required autofocus="" value="<%=(memVO == null) ? "wowowoo" : memVO.getMemAccount()%>"  > <input --%>
						<%-- 							type="password" id="user-pass" class="form-control" name="memPassword" value="<%=(memVO == null) ? "a123123" : memVO.getMemPassword()%>" --%>
						<!-- 							placeholder="密碼" required autofocus=""> <select name="memGender" class="form-control" > -->
						<!-- 							<option value="0">男生 </option> -->
						<!-- 							<option value="1">女生</option></select>  -->
						<%-- 							<input type="hidden" id="user-permission" name="memPermission" class="form-control" value="<%=(memVO == null) ? "0" : memVO.getMemPermission()%>"> --%>
						<%-- 							<input type="TEXT" id="user-Phone" name="memPhone" class="form-control" value="<%=(memVO == null) ? "987654321" : memVO.getMemPhone()%>"> --%>
						<%-- 							<input type="email" id="user-Phone" name="memEmail" class="form-control" value="<%=(memVO == null) ? "aa@aaa.com" : memVO.getMemEmail()%>"> --%>
						<!-- 							<div id="twzipcode"></div> -->
						<%-- 							<input type="TEXT" id="user-address" name="memAddress" class="form-control" value="<%=(memVO == null) ? "" : memVO.getMemAddress()%>"> --%>
						<!-- 							<input type="TEXT" id="f_date1" name=memBirthday class="form-control"> -->





						<!-- 							放註冊表單用-上線備份 -->


<%-- 						<input type="text" id="user-name" name="memName"class="form-control" placeholder="姓名" required="" autofocus=""value="<%=(memVO == null) ? "" : memVO.getMemName()%>"> <p style="color:red;">${errorMsgs.memName}</p> --%>
						
<%-- 						<input type="text" id="user-account" name="memAccount"class="form-control" placeholder="帳號" required autofocus=""value="<%=(memVO == null) ? "" : memVO.getMemAccount()%>"><p style="color:red;">${errorMsgs.memAccount}</p> --%>
<%-- 						<input type="password" id="user-pass" class="form-control"name="memPassword"value="<%=(memVO == null) ? "" : memVO.getMemPassword()%>"placeholder="密碼" required autofocus=""> <p style="color:red;">${errorMsgs.memPassword}</p> --%>
						
<!-- 						<select name="memGender" class="form-control"> -->
<!-- 							<option value="0">男生</option> -->
<!-- 							<option value="1">女生</option> -->
<!-- 						</select>  -->
						
<%-- 						<input type="hidden" id="user-permission" name="memPermission"class="form-control"value="<%=(memVO == null) ? "1" : memVO.getMemPermission()%>"> --%>
						
<%-- 						<input type="TEXT" id="user-Phone" name="memPhone"placeholder="電話" class="form-control"value="<%=(memVO == null) ? "" : memVO.getMemPhone()%>"> <p style="color:red;">${errorMsgs.memPhone}</p> --%>
						
<%-- 						<input type="email" id="user-Phone" name="memEmail"class="form-control" placeholder="信箱"value="<%=(memVO == null) ? "" : memVO.getMemEmail()%>"> <p style="color:red;">${errorMsgs.memEmail}</p> --%>
						
<!-- 						<div id="twzipcode"></div> -->
						
<%-- 						<input type="TEXT" id="user-address" name="memAddress"class="form-control" placeholder="地址"value="<%=(memVO == null) ? "" : memVO.getMemAddress()%>"> --%>
						
<!-- 						<input type="TEXT" id="f_date1" placeholder="生日" name=memBirthday class="form-control"> -->



						<!--                     ==========放註冊表單用的-原始備份用================ -->
						<
						<input type="text" id="user-name" name="memName"
							class="form-control" placeholder="姓名" required="" autofocus=""
							value="<%=(memVO == null) ? "" : memVO.getMemName()%>"><p style="color:red">${errorMsgs.memName} </p>  
							<input type="text" id="user-account" name="memAccount"
							class="form-control" placeholder="帳號" required autofocus=""
							value="<%=(memVO == null) ? "" : memVO.getMemAccount()%>"><p style="color:red">${errorMsgs.memAccount} </p>
						<input type="password" id="user-pass" class="form-control"
							name="memPassword" value="<%=(memVO == null) ? "" : memVO.getMemPassword()%>" placeholder="密碼" required autofocus=""> 
							<select
							name="memGender" class="form-control">
							<option value="0">男生</option>
							<option value="1">女生</option>
						</select> <input type="hidden" id="user-permission" name="memPermission"
							class="form-control"
							value="<%=(memVO == null) ? "1" : memVO.getMemPermission()%>">
						<input type="TEXT" id="user-Phone" name="memPhone"
							placeholder="電話" class="form-control"
							value="<%=(memVO == null) ? "" : memVO.getMemPhone()%>"><p style="color:red">${errorMsgs.memPhone} </p>
						<input type="email" id="user-Phone" name="memEmail"
							class="form-control" placeholder="信箱"
							value="<%=(memVO == null) ? "" : memVO.getMemEmail()%>"><p style="color:red">${errorMsgs.memEmail} </p>
						<div id="twzipcode"></div>
						<input type="TEXT" id="user-address" name="memAddress"
							class="form-control" placeholder="地址"
							value="<%=(memVO == null) ? "" : memVO.getMemAddress()%>"><p style="color:red">${errorMsgs.memAddress} </p>
						<input type="TEXT" id="f_date1" placeholder="生日" name=memBirthday
							class="form-control">



						<input type="hidden" name="action" value="insertForMem">
						<button class="btn btn-primary btn-block" type="submit"
							value="送出新增">
							<i class="fas fa-user-plus"></i> Sign1 Up
						</button>
						<a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i>
							Back</a>
					</form>
					<br>

				</div>
				<!-- 						<div class="col-lg-6 col-12"> -->


				<!-- 						----- ----- ----- 舊版member.jsp的按鈕 沒用到  ----- ----- ----- -->

				<!-- 				<div id="submit"> -->
				<!-- 					<input type="submit" id="submit1" value="Sign In" -->
				<!-- 						onclick="return checkForm()"> -->
				<!-- 														<input type="submit" -->
				<!-- 														id="submit2" value="Sign In"> -->
				<!-- 				</div> -->
				<!-- 				<div id="submit"> -->
				<!-- 					<input type="submit" id="submit1" value="忘記密碼" -->
				<!-- 						onclick="return checkForm()"> -->
				<!-- 														<input type="submit" -->
				<!-- 														id="submit2" value="Sign In"> -->
				<!-- 				</div> -->

			</section>
		</form>

		<!-- ----- ----- ----- orignal v1 stop ----- ----- ----- -->
		-->
		<!-- ----- ----- ----- 中間內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->

    <!-- ----- ----- ----- 頁面 底部 start ----- ----- ----- -->
	<%@ include file="../../front-end/tool/PageFooter.file"%>
    <!-- ----- ----- ----- 頁面 底部 end ----- ----- ----- -->
	<!-- ----- ----- ----- 跳出預先訂位頁面 start ----- ----- ----- -->

	<!-- ----- ----- ----- 跳出預先訂位頁面 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<script src="../../front-assets/js/jquery.min.js"></script>
	<script src="../../front-assets/bootstrap_js/bootstrap.bundle.min.js"></script>
	<script src="../../front-assets/js/custom.js"></script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->



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