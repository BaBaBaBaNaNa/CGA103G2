<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.meals.model.*"%>
<%@ page import="com.meals.controller.MealsServlet"%>

<%
MealsVO mealsVO = (MealsVO) request.getAttribute("mealsVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
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
<!-- empStyle -->
<link href="../../back-assets/css/empStyle.css" rel="stylesheet">

<link href="../../back-assets/css/empDetailStyle.css" rel="stylesheet">
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>

<body
	class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">
	<!-- ----- ----- ----- 進入網站的讀取圈圈 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- 進入網站的讀取圈圈 end ----- ----- ----- -->
	<!-- Overlays -->
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
		<div class="ms-auth-form">
			<form METHOD="post" ACTION="Meals.do" name="form1"
				enctype="multipart/form-data">
				<h3>修改菜色</h3>
				<div class="form-row">
					<div class="col-md-12"> 
						<label>菜色編號:</label>
						<div class="input-group">
							<input id="mealsID" name="mealsID" type="text"
								value="${param.mealsID}" class="form-control"
								readonly="readonly" />
						</div>
					</div>
					<div class="col-md-12">
						<label for="mealsCategoryID">菜系編號:</label>
						<div class="input-group">
							<input id="mealsCategoryID" name="mealsCategoryID" type="text"
								value="${param.mealsCategoryID}" class="form-control"
								readonly="readonly" />
						</div>
					</div>

					<div class="col-md-12">
					<p>${errorMsgs.mealsName}</p>
						<label>菜名:</label>
						<div class="input-group">
							<input id="mealsName" name="mealsName" type="text"
								value="${param.mealsName}" class="form-control"
								placeholder="請輸入菜名" onclick="hideContent('mealsName.errors');" />
						</div>
					</div>
					<div class="col-md-12">
						<p>${errorMsgs.mealsPrice}</p>
						<label for="mealsPrice">價錢:</label> <input id="mealsPrice"
							name="mealsPrice" type="text" value="${param.mealsPrice}"
							class="form-control" placeholder="請輸入價錢"
							onclick="hideContent('mealsPrice.errors');" />
					</div>

					<div class="col-md-12">
						<p>${errorMsgs.mealsInfo}</p>
						<label for="mealsInfo">菜色說明:</label> <input id="mealsInfo"
							name="mealsInfo" type="text" value="${param.mealsInfo}"
							class="form-control" placeholder="請輸入菜色說明"
							onclick="hideContent('mealsInfo.errors');" /> <span
							id="mealsInfo" class="error">${errorMsgs.mealsInfo}</span>
					</div>

					<div class="col-md-12">
						<label for="mealsPicture">照片:</label> <input id="mealsPicture"
							name="mealsPicture" type="file" onclick="previewImage()"
							multiple="multiple" />
						<%-- 可以不修改圖片 <span  id ="mealsPicture.errors" class="error">${errorMsgs.mealsPicture}</span> --%>
						<div id="blob_holder">
							<img
								src="<%=request.getContextPath()%>/meals/DBGifReader?mealsID=${param.mealsID}"
								width="100px">
						</div>
					</div>
					<div class="col-md-12">
					<label>菜色控制:</label>
					
					</div>
					<div class="col-md-12" >
					<p>${errorMsgs.mealsControl}</p>
					<div class="input-group">
						<label> 下架</label> <input id="mealsControl"
							name="mealsControl" type="radio" value="0"
							onclick="hideContent('mealsControl.errors');" />
							</div><div class="input-group"><label> 上架 </label><input
							id="mealsControl" name="mealsControl" type="radio" value="1"
							onclick="hideContent('mealsControl.errors');" /> 
				
					</div>
					</div>
				</div>
				<input type="hidden" name="action" value="update"> <input
					type="hidden" name="mealsID" value="${param.mealsID}"> <input
					class="btn btn-primary mt-4 d-block w-100" type="submit"
					value="送出修改">
			</form>
		</div>
		>
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
	<script type="text/javascript">
		//清除提示信息
		function hideContent(d) {
			document.getElementById(d).style.display = "none";
		}

		//照片上傳-預覽用
		var filereader_support = typeof FileReader != 'undefined';
		if (!filereader_support) {
			alert("No FileReader support");
		}
		acceptedTypes = {
			'image/png' : true,
			'image/jpeg' : true,
			'image/gif' : true
		};
		function previewImage() {
			var upfile1 = document.getElementById("upFiles");
			upfile1.addEventListener("change", function(event) {
				var files = event.target.files || event.dataTransfer.files;
				for (var i = 0; i < files.length; i++) {
					previewfile(files[i])
				}
			}, false);
		}
		function previewfile(file) {
			if (filereader_support === true
					&& acceptedTypes[file.type] === true) {
				var reader = new FileReader();
				reader.onload = function(event) {
					var image = new Image();
					image.src = event.target.result;
					image.width = 100;
					image.height = 75;
					image.border = 2;
					if (blob_holder.hasChildNodes()) {
						blob_holder.removeChild(blob_holder.childNodes[0]);
					}
					blob_holder.appendChild(image);
				};
				reader.readAsDataURL(file);
				document.getElementById('submit').disabled = false;
			} else {
				blob_holder.innerHTML = "<div  style='text-align: left;'>"
						+ "● filename: "
						+ file.name
						+ "<br>"
						+ "● ContentTyp: "
						+ file.type
						+ "<br>"
						+ "● size: "
						+ file.size
						+ "bytes"
						+ "<br>"
						+ "● 上傳ContentType限制: <b> <font color=red>image/png、image/jpeg、image/gif </font></b></div>";
				document.getElementById('submit').disabled = true;
			}
		}
	</script>
</body>

</html>

