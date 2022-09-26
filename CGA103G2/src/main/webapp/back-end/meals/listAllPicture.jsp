<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.meals.model.*"%>
<%@ page import="com.meals.controller.MealsServlet"%>



<jsp:useBean id="MealsSvc" scope="page" class="com.meals.model.MealsService"/>
<jsp:useBean id="list" scope="session" type="java.util.List<MealsVO>" />

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

<link href="../../back-assets/css/mealsCategoryDetailStyle.css" rel="stylesheet">
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>

<body class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">
	<!-- ----- ----- ----- 進入網站的讀取圈圈 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- 進入網站的讀取圈圈 end ----- ----- ----- -->

	<div class="ms-aside-overlay ms-overlay-left ms-toggler"data-target="#ms-side-nav" data-toggle="slideLeft"></div>
	<div class="ms-aside-overlay ms-overlay-right ms-toggler"data-target="#ms-recent-activity" data-toggle="slideRight"></div>

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
		<body bgcolor='white'>
		<h2>所有餐點種類資料</h2>
		<hr>
			<div style="text-align: center;">
				<FORM METHOD="post" ACTION="Meals.do">
					<b>輸入菜色編號 (如1):</b> <input type="text" name="mealsID">
					<input type="hidden" name="action" value="getOne_For_Display">
					<input type="submit" value="送出">
				</FORM>
			</div>
			<div style="text-align: center;">
				<FORM METHOD="post" ACTION="Meals.do" >
			       <b>選擇菜色名稱:</b>
			       <select size="1" name="mealsID">
			         <c:forEach var="MealsVO" items="${MealsSvc.all}" > 
			          <option value="${MealsVO.mealsID}">${MealsVO.mealsName}
			         </c:forEach>   
			       </select>
			       <input type="hidden" name="action" value="getOne_For_Display">
			       <input type="submit" value="送出">
	     		</FORM>
     		</div>
     		<table style="width: 90% ;">
			<tr>
				<th style="width: 5% ;">編號</th>
				<th style="width: 20% ;">菜系</th>
				<th style="width: 10% ;">菜色名稱</th>
				<th style="width: 5% ;">價錢</th>
				<th style="width: 20% ;">說明</th>
				<th style="width: 20% ;">照片</th>
				<th style="width: 5% ;">控制</th>
				<th style="width: 5% ;">修改</th>
				<th style="width: 5% ;">刪除</th>
			</tr>
			<div style="text-align: center;">
			<%@ include file="../../back-end/tool/page1.file"%>
			</div>
			<c:forEach var="MealsVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
				<tr>
					<td>${MealsVO.mealsID}</td>
					<td>${MealsVO.mealsCategoryID}-[${MealsVO.mealsCategoryVO.mealsCategory}]</td>
					<td>${MealsVO.mealsName}</td>
					<td>${MealsVO.mealsPrice}</td>
					<td>${MealsVO.mealsInfo}</td>
					<td><img src="<%=request.getContextPath()%>/meals/DBGifReader?mealsID=${MealsVO.mealsID}" width="100px"></td> 
					<td>${MealsVO.mealsControl==0?'下架':'上架'}</td>
					<td>
						<FORM METHOD="post"
							ACTION="<%=request.getContextPath()%>/back-end/meals/Meals.do"style="margin-bottom: 0px;">
							<input type="submit" value="修改"> <input type="hidden"name="mealsID" value="${MealsVO.mealsID}"> 
							<input type="hidden"name="action" value="getOne_For_Update">
						</FORM>
					</td>
					<td>
						<FORM METHOD="post"
							ACTION="<%=request.getContextPath()%>/back-end/meals/Meals.do"style="margin-bottom: 0px;">
							<input type="submit" value="刪除"> 
							<input type="hidden"name="mealsID" value="${MealsVO.mealsID}"> 
							<input type="hidden"name="action" value="delete">
						</FORM>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div style="text-align: center;">
		<%@ include file="../../back-end/tool/page2.file"%>
		</div>
			
     		
  		<hr>
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