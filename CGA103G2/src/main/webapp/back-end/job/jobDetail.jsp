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


<style type="text/css">
table {
	border: 1px solid black;
	margin: 0 auto;
}

td {
	width: 150px;
	border: 1px solid black;
	text-align: center;
}
div{
	text-align: center;
}
h2{
	text-align: center;
}

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}
</style>
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
		<%@ include file="../../back-end/tool/Upicon.file"%>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->

		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		<h2	>查看職務</h2>
			<table>
				<tr>
					<th>職務編號</th>
					<th>職務名稱</th>
				</tr>
				<%@ include file="../../back-end/tool/page1.file"%>
				<c:forEach var="jobVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
					<tr>
						<td>${jobVO.jobID}</td>
						<td>${jobVO.jobName}</td>
						<td>
							<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/job/job.do" style="margin-bottom: 0px;">
								<input type="submit" value="修改">
								<input type="hidden" name="job_id" value="${jobVO.jobID}">
								<input type="hidden" name="action" value="getOne_For_Update">
							</FORM>
						</td>
						<td>
							<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/job/job.do" style="margin-bottom: 0px;">
								<input type="submit" value="刪除">
								<input type="hidden" name="job_id" value="${empVO.empID}">
								<input type="hidden" name="action" value="delete">
							</FORM>
						</td>
					</tr>
				</c:forEach>
			</table>
			<%@ include file="../../back-end/tool/page2.file"%>
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