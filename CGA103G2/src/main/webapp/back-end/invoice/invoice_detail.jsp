<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>異鄉人-義式餐酒館-管理中心</title>
<!-- ----- ----- ----- CSS&Front設定 start ----- ----- ----- -->
<!-- Iconic Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/back-assets/vendors/iconic-fonts/font-awesome/css/all.min.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/back-assets/vendors/iconic-fonts/flat-icons/flaticon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins-colors.css">
<!-- Bootstrap core CSS -->
<link href="${pageContext.request.contextPath}/back-assets/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery UI -->
<link href="${pageContext.request.contextPath}/back-assets/css/jquery-ui.min.css" rel="stylesheet">
<!-- Page Specific CSS (Slick Slider.css) -->
<link href="${pageContext.request.contextPath}/back-assets/css/slick.css" rel="stylesheet">
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
	<div class="ms-aside-overlay ms-overlay-left ms-toggler" data-target="#ms-side-nav" data-toggle="slideLeft"></div>
	<div class="ms-aside-overlay ms-overlay-right ms-toggler" data-target="#ms-recent-activity" data-toggle="slideRight"></div>
	<!-- Sidebar Navigation Left -->

	<!-- ----- ----- ----- 最左邊的 選擇列 start ----- ----- ----- -->
	<%@ include file="../../back-end/tool/LeftSideBar.file"%>
	<!-- ----- ----- ----- 最左邊的 選擇列 end ----- ----- ----- -->

	<main class="body-content">
		<!-- ----- ----- -----   中間上面Bar start ----- ----- ----- -->
			<%@ include file="../../back-end/tool/UpSideBar.file"%>
		<!-- ----- ----- -----   中間上面Bar end ----- ----- ----- -->
		
		<!-- ----- ----- -----   中間目錄條 start ----- ----- ----- -->
			<%@ include file="../../back-end/tool/Upicon.file"%>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->

		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		<div class="ms-content-wrapper">
			<div class="row">
				<div class="col-md-12">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb pl-0">
							<li class="breadcrumb-item"><a href="#"><i class="material-icons">home</i>Home</a></li>
							<li class="breadcrumb-item"><a href="#">Invoice</a></li>
							<li class="breadcrumb-item active" aria-current="page">Invoice Details</li>
						</ol>
					</nav>
					<div class="ms-panel">
						<div class="ms-panel-header header-mini">
							<div class="d-flex justify-content-between">
								<h6>Invoice</h6>
								<h6>#135178</h6>
							</div>
						</div>
						<div class="ms-panel-body">
							<!-- Invoice To -->
							<div class="row align-items-center">
								<div class="col-md-6">
									<div class="invoice-address">
										<h3>Reciever:</h3>
										<h5>Anny Farisha</h5>
										<p>Anny.123@hotmail.com</p>
										<p class="mb-0">1642 Cambridge Drive, Phoenix, 85029 Arizona</p>
										<p class="mb-0">Arizona</p>
										<p>Phoenix</p>
									</div>
								</div>
								<div class="col-md-6 text-md-right">
									<ul class="invoice-date">
										<li>Invoice Date : Saturday, April 07 2019</li>
										<li>Due Date : Sunday, April 19 2019</li>
									</ul>
								</div>
							</div>
							<!-- Invoice Table -->
							<div class="ms-invoice-table table-responsive mt-5">
								<table class="table table-hover text-right thead-light">
									<thead>
										<tr class="text-capitalize">
											<th class="text-center w-5">id</th>
											<th class="text-left">description</th>
											<th>qty</th>
											<th>Unit Cost</th>
											<th>total</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td class="text-center">1</td>
											<td class="text-left">Grilled Sandwich</td>
											<td>1</td>
											<td>$30</td>
											<td>$30</td>
										</tr>
										<tr>
											<td class="text-center">2</td>
											<td class="text-left">Fried Egg Sandwich</td>
											<td>1</td>
											<td>$69</td>
											<td>$69</td>
										</tr>
										<tr>
											<td class="text-center">2</td>
											<td class="text-left">Spicy Grilled Burger</td>
											<td>2</td>
											<td>$19</td>
											<td>$38</td>
										</tr>
										<tr>
											<td class="text-center">2</td>
											<td class="text-left">Peri Peri Fries</td>
											<td>2</td>
											<td>$9</td>
											<td>$18</td>
										</tr>
									</tbody>
									<tfoot>
										<tr>
											<td colspan="4">Total Cost:</td>
											<td>$155</td>
										</tr>
									</tfoot>
								</table>
							</div>
							<div class="invoice-buttons text-right">
								<a href="#" class="btn btn-primary mr-2">Print Invoice</a><a href="#" class="btn btn-primary">Send Invoice</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- ----- ----- -----   中間下面內容 end ----- ----- ----- -->
	</main>
	<!-- ----- ----- -----   中間內容 end ----- ----- ----- -->

	<!-- ----- ----- ----- Script Start ----- ----- ----- -->
	<!-- Global Required Scripts Start -->
	<script src="${pageContext.request.contextPath}/back-assets/js/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/perfect-scrollbar.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/jquery-ui.min.js"></script>
	<!-- Global Required Scripts End -->
	<!-- Page Specific Scripts Start -->
	<script src="${pageContext.request.contextPath}/back-assets/js/slick.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/moment.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/jquery.webticker.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/Chart.bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/back-assets/js/Chart.Financial.js"></script>
	<!-- Page Specific Scripts Finish -->
	<!-- Costic core JavaScript -->
	<script src="${pageContext.request.contextPath}/back-assets/js/framework.js"></script>
	<!-- Settings -->
	<script src="${pageContext.request.contextPath}/back-assets/js/settings.js"></script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
</body>

</html>