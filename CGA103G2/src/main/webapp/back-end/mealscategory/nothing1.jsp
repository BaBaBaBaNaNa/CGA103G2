<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
	<main class="body-content">
		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
		<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->

		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
		<%@ include file="../../back-end/tool/Upicon.file"%>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->

		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		<body bgcolor='white'>

			<table id="table-1">
				<tr>
					<td><h3>IBM MealsCategory: Home</h3>
						<h4>( MVC )</h4></td>
				</tr>
			</table>

			<p>This is the Home page for IBM MealsCategory: Home</p>

			<h3>資料查詢:</h3>

			<%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>

			<ul>
				<li><a href='listAllMC.jsp'>List</a> all MealsCategory <br>
				<br></li>


				<li>
					<FORM METHOD="post" ACTION="MealsCategory.do">
						<b>輸入菜系編號 (如1):</b> <input type="text" name="MealsCategoryId">
						<input type="hidden" name="action" value="getOne_For_Display">
						<input type="submit" value="送出">
					</FORM>
				</li>

				<jsp:useBean id="MealsCategorySvc" scope="page"
					class="com.mealscateory.model.MealsCategoryService" />

				<li>
					<FORM METHOD="post" ACTION="MealsCategory.do">
						<b>選擇菜系編號:</b> <select size="1" name="MealsCategoryId">
							<c:forEach var="MealsCategoryVO" items="${MealsCategorySvc.all}">
								<option value="${MealsCategoryVO.mealsCategoryId}">${MealsCategoryVO.mealsCategoryId}
							</c:forEach>
						</select> <input type="hidden" name="action" value="getOne_For_Display">
						<input type="submit" value="送出">
					</FORM>
				</li>

				<li>
					<FORM METHOD="post" ACTION="MealsCategory.do">
						<b>選擇菜色名稱:</b> <select size="1" name="MealsCategoryId">
							<c:forEach var="MealsCategoryVO" items="${MealsCategorySvc.all}">
								<option value="${MealsCategoryVO.mealsCategoryId}">${MealsCategoryVO.mealsCategory}
							</c:forEach>
						</select> <input type="hidden" name="action" value="getOne_For_Display">
						<input type="submit" value="送出">
					</FORM>
				</li>
			</ul>


			<h3>菜系管理</h3>

			<ul>
				<li><a href='addMealsCategory.jsp'>Add</a> a new MealsCategory.</li>
			</ul>

			<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
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
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
</body>

</html>