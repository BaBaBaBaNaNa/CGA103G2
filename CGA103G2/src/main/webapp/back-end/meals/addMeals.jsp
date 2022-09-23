<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.meals.model.*"%>
<%
MealsVO mealsVO = (MealsVO) request.getAttribute("mealsVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>餐點種類新增 - addMealsCategory.jsp</title>
<%@ include file="included-fragment.file" %>
<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}

form {
	display: table;
}

.center {
	margin-left: auto;
	margin-right: auto;
}
</style>

<style>
table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}

#blob_holder {
	display: table-cell;
}

td div {
	display: table-cell;
}
form div div {
		display: table-cell;
	}
</style>

</head>
<body bgcolor='white'>

	<nav
		class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		<div align="center">
			<h2>員工資料新增 - addEmp.jsp</h2>
			<h3>
				<a class="navbar-brand"
					href="<%=request.getContextPath()%>/back-end/meals/select_page.jsp"><img
					src="<%=request.getContextPath()%>/back-end/meals/images/back1.gif">回查詢頁</a>
			</h3>
		</div>
	</nav>

	<h3>資料新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM  action="<%=request.getContextPath()%>/back-end/meals/Meals.do" method="post" enctype="multipart/form-data">
		<table>
			<jsp:useBean id="mealsSvc" scope="page"
				class="com.meals.model.MealsService" />

<!-- 			<tr> -->
<!-- 				<td><label for="mealsCategoryID">部門:</label></td> -->
<!-- 				<td><select id="mealsCategoryID" name="mealsCategoryID"> -->
<%-- 						<c:forEach var="mealsVO" items="${mealsSvc.all}"> --%>
<%-- 							<option value="${mealsVO.mealsCategoryID}" --%>
<%-- 								${(mealsVO.mealsCategoryID==mealsVO.mealsCategoryID)? 'selected':'' }>${mealsVO.mealsCategoryID} --%>
<%-- 						</c:forEach> --%>
<!-- 				</select></td> -->
<!-- 			<tr> -->
			  <jsp:useBean id="MealscategorySvc" scope="page" class="com.mealscateory.model.MealsCategoryService" />
				<tr>
					<td>部門:<font color=red><b>*</b></font></td>
					<td><select size="1" name="mealsCategoryID">
						<c:forEach var="MealsCategoryVO" items="${MealscategorySvc.all}">
							<option value="${MealsCategoryVO.mealsCategoryId}" ${(mealsVO.mealsCategoryID==MealsCategoryVO.mealsCategoryId)? 'selected':'' } >${MealsCategoryVO.mealsCategory}
						</c:forEach>
					</select></td>
				</tr>
			<tr>
			<tr>
				<td>種類名稱:</td>
				<td><input type="TEXT" name="mealsName" size="45"
					value="<%=(mealsVO == null) ? "薯條" : mealsVO.getMealsName()%>" /></td>
			</tr>
			<tr>
				<td>種類ID:</td>
				<td><input type="TEXT" name="mealsPrice" size="45"
					value="<%=(mealsVO == null) ? "500" : mealsVO.getMealsPrice()%>" /></td>
			</tr>
			<tr>
				<td>種類ID:</td>
				<td><input type="TEXT" name="mealsInfo" size="45"
					value="<%=(mealsVO == null) ? "超好吃" : mealsVO.getMealsInfo()%>" /></td>
			</tr>
			
			<div>
				<label for="mealsPicture">照片:</label>
				<input id="mealsPicture" name="mealsPicture" type="file"
					onclick="previewImage()" multiple="multiple"
					onchange="hideContent('mealsPicture.errors');" /> <span
					id="mealsPicture.errors" class="error">${errorMsgs.mealsPicture}</span>
				
					<div id="blob_holder"></div>
			</div>
		<tr>
		
			<td>控制:</td>
			<td><input type="radio" value="0" name="mealsControl"/>下架
			<input type="radio" value="1" name="mealsControl"/>上架</td>
		</tr>
		
<!-- 			<tr> -->
<!-- 				<td><label for="mealsControl">控制:</label></td> -->
<!-- 				<td><select id="mealsControl" name="mealsControl"> -->
<%-- 						<c:forEach var="mealsVO" items="${mealsSvc.all}"> --%>
<%-- 							<option value="${mealsVO.mealsControl}" --%>
<%-- 								${(mealsVO.mealsControl==mealsVO.mealsControl)? 'selected':'' }>${mealsVO.mealsControl} --%>
<%-- 						</c:forEach> --%>
<!-- 				</select></td> -->
<!-- 			</tr> -->

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" id="submit" value="送出新增">
	</FORM>


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
			var upfile1 = document.getElementById("mealsPicture");
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
		<!--JavaScript part -->
	</script>
</body>
</html>