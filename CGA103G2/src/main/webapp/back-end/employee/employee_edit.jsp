<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*,com.emp.model.EmpVO"%>

<%
EmpVO empVO = (EmpVO) request.getAttribute("empVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
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

<link rel="stylesheet" href="${pageContext.request.contextPath}/back-assets/vendors/iconic-fonts/flat-icons/flaticon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins-colors.css">
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/back-assets/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery UI -->
<link href="${pageContext.request.contextPath}/back-assets/css/jquery-ui.min.css" rel="stylesheet">
<!-- Page Specific CSS (Slick Slider.css) -->
<link href="${pageContext.request.contextPath}/back-assets/css/slick.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/back-assets/css/datatables.min.css" rel="stylesheet">
<!-- Costic styles -->
<link href="${pageContext.request.contextPath}/back-assets/css/style.css" rel="stylesheet">
<!-- Favicon -->
<link rel="icon" type="image/png" sizes="32x32" href="${pageContext.request.contextPath}/favicon.ico">
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>

<body class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">
	<!-- ----- ----- ----- 進入網站的讀取圈圈 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- 進入網站的讀取圈圈 end ----- ----- ----- -->
	<!-- Overlays -->
	<div class="ms-aside-overlay ms-overlay-left ms-toggler" data-target="#ms-side-nav" data-toggle="slideLeft"></div>
	<div class="ms-aside-overlay ms-overlay-right ms-toggler" data-target="#ms-recent-activity" data-toggle="slideRight"></div>

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
		<h2>修改員工訊息</h2>

		<%-- 錯誤表列 --%>
		<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>

		<form action="emp.do" name="form1" method="post">
			<table>

				<tr>
					<td>員工編號</td>
					<td><input type="text" name="emp_id" value="<%=empVO.getEmp_id()%>" readonly="readonly" /></td>
				</tr>
				<tr>
					<td>員工姓名</td>
					<td><input type="text" name="emp_name" value="<%=empVO.getEmp_name()%>" required /></td>
				</tr>
				<tr>
					<td>帳號</td>
					<td><input type="text" name="emp_account" value="<%=empVO.getEmp_account()%>" required /></td>
				</tr>
				<tr>
					<td>密碼</td>
					<td><input type="text" name="emp_password" value="<%=empVO.getEmp_password()%>" required /></td>
				</tr>
				<tr>
					<td>權限</td>
					<td><input type="text" name="emp_permission" value="<%=empVO.getEmp_permission()%>" required /></td>
				</tr>
				<tr>
					<td>員工電話</td>
					<td><input type="text" name="emp_phone" value="<%=empVO.getEmp_phone()%>" required /></td>
				</tr>
				<tr>
					<td>員工地址</td>
					<td><input type="text" name="emp_address" value="<%=empVO.getEmp_address()%>" required /></td>
				</tr>
				<tr>
					<td>員工職位</td>
					<td><input type="text" name="emp_job" value="<%=empVO.getEmp_job()%>" required /></td>
				</tr>
				<tr>
					<td>員工到職日</td>
					<td><input type="text" name="emp_hiredate" value="<%=empVO.getEmp_hiredate()%>" required /></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="action" value="update">
			<input type="hidden" name="emp_id" value="<%=empVO.getEmp_id()%>">
			<input type="submit" value="送出修改">
		</form>
		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- ----- 中間 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<!-- Global Required Scripts Start -->
	<script src="${pageContext.request.contextPath}/back-assets/js/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/perfect-scrollbar.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/jquery-ui.min.js"></script>
	<!-- Global Required Scripts End -->
	<!-- Page Specific Scripts Start -->
	<script src="${pageContext.request.contextPath}/back-assets/js/d3.v3.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/topojson.v1.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/datatables.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/data-tables.js"></script>
	<!-- Page Specific Scripts Finish -->
	<!-- Costic core JavaScript -->
	<script src="${pageContext.request.contextPath}/back-assets/js/framework.js"></script>
	<!-- Settings -->
	<script src="${pageContext.request.contextPath}/back-assets/js/settings.js"></script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
</body>

</html>