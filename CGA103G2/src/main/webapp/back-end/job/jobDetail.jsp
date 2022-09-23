<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.job.model.*"%>

<jsp:useBean id="list" scope="session" type="java.util.List<JobVO>" />
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

<link href="../../back-assets/css/empDetailStyle.css" rel="stylesheet">
<!-- ----- ----- ----- CSS&Front設定 end ----- ----- ----- -->
</head>

<body class="ms-body ms-aside-left-open ms-primary-theme ms-has-quickbar">

	<!-- ----- ----- ----- 進入網站的讀取圈圈 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/ReadingCircle.file"%>
	<!-- ----- ----- ----- 進入網站的讀取圈圈 end ----- ----- ----- -->

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
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb pl-0">
				<li class="breadcrumb-item"><a href="../../back-end/index/BackIndex.jsp"><i
						class="material-icons">home</i>首頁</a></li>
				<li class="breadcrumb-item">員工管理</li>
				<li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath}/back-end/job/JobServlet.do?action=getAll">查看職務資料</a></li>
			</ol>
		</nav>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->

		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		<h2>查看職位</h2>
		<hr>
		<div style="text-align: center;">
			<FORM METHOD="post" ACTION="${pageContext.request.contextPath}/back-end/job/JobServlet.do">
				<b>輸入職稱編號 (如1):</b> 
				<input type="text" name="jobID" value="${param.jobID}"><font color=red>${errorMsgs.jobID}</font> 
				<input type="hidden" name="action" value="getOne_For_Display"> 
				<input type="submit" value="送出">
			</FORM>
    	</div>
  		<hr>
		<table style="width: 35% ;">
			<tr>
				<th style="width: 5% ;">編號</th>
				<th style="width: 20% ;">職務<br>名稱</th>
				<th style="width: 5% ;">修改</th>
				<th style="width: 5% ; display: none ;">刪除</th>
			</tr>
			<div style="text-align: center;">
			<%@ include file="../../back-end/tool/page1.file"%>
			</div>
			<c:forEach var="jobVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
				<tr>
					<td>${jobVO.jobID}</td>
					<td>${jobVO.jobName}</td>
					<td>
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/job/JobServlet.do" style="margin-bottom: 0px;">
							<input type="submit" value="修改"> <input type="hidden" name="jobID" value="${jobVO.jobID}"> <input type="hidden" name="action" value="getOne_For_Update">
						</FORM>
					</td>
					<td style="display: none ;">
						<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/job/JobServlet.do" style="margin-bottom: 0px;">
<!-- 							        "submit" -->
							<input type="hidden" value="刪除" disabled="disabled">
							<input type="hidden" name="jobID" value="${jobVO.jobID}">
							<input type="hidden" name="action" value="delete">
						</FORM>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div style="text-align: center;">
		<%@ include file="../../back-end/tool/page2.file"%>
		</div>
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