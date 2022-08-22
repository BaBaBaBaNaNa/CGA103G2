<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>義鄉人-義式餐酒館-管理中心</title>
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
<link rel="icon" type="image/png" sizes="32x32" href="favicon.ico">
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

	<!-- ----- ----- ----- 中間 start ----- ----- ----- -->
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
					<div class="ms-panel">
						<div class="ms-panel-header">
							<h6>Product Details</h6>
						</div>
						<div class="ms-panel-body">
							<div id="arrowSlider" class="ms-arrow-slider carousel slide" data-ride="carousel" data-interval="false">
								<div class="carousel-inner">
									<div class="carousel-item active">
										<img class="d-block w-100" src="../../back-assets/img/costic/banner-1.jpg" alt="First slide">
										<div class="carousel-caption d-none d-md-block">
											<h3 class="text-white">Pizaa img 1</h3>
										</div>
									</div>
									<div class="carousel-item">
										<img class="d-block w-100" src="../../back-assets/img/costic/banner-2.jpg" alt="Second slide">
										<div class="carousel-caption d-none d-md-block">
											<h3 class="text-white">Pizaa img 2</h3>
										</div>
									</div>
									<div class="carousel-item">
										<img class="d-block w-100" src="../../back-assets/img/costic/banner-3.jpg" alt="Third slide">
										<div class="carousel-caption d-none d-md-block">
											<h3 class="text-white">Pizaa img 3</h3>
										</div>
									</div>
								</div>
								<a class="carousel-control-prev" href="#arrowSlider" role="button" data-slide="prev"><span class="material-icons" aria-hidden="true">keyboard_arrow_left</span><span class="sr-only">Previous</span></a><a class="carousel-control-next" href="#arrowSlider" role="button" data-slide="next"><span class="material-icons" aria-hidden="true">keyboard_arrow_right</span><span
									class="sr-only">Next</span></a>
							</div>
						</div>
					</div>
				</div>
				<div class=" col-md-6">
					<div class="ms-panel ms-panel-fh">
						<div class="ms-panel-body">
							<h4 class="section-title bold">Product Info</h4>
							<table class="table ms-profile-information">
								<tbody>
									<tr>
										<th scope="row">Price</th>
										<td>$15</td>
									</tr>
									<tr>
										<th scope="row">Product Category</th>
										<td>Veg</td>
									</tr>
									<tr>
										<th scope="row">Availiblity</th>
										<td><span class="badge badge-pill badge-primary">In stock</span></td>
									</tr>
									<tr>
										<th scope="row">Delivery Charges</th>
										<td>Free</td>
									</tr>
									<tr>
										<th scope="row">SKU Identification</th>
										<td>23445</td>
									</tr>
								</tbody>
							</table>
							<div class="new">
								<button type="button" class="btn btn-primary">Edit</button>
								<button type="button" class="btn btn-secondary">Delete</button>
							</div>
						</div>
					</div>
				</div>
				<div class=" col-md-6">
					<div class="ms-panel ms-panel-fh">
						<div class="ms-panel-body">
							<h4 class="section-title bold">Product Details</h4>
							<p class="description">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book type and scrambled it to make a type specimen book.</p>
						</div>
						<div class="ms-quick-stats">
							<div class="ms-stats-grid">
								<i class="fa fa-bullhorn"></i>
								<p class="ms-text-dark">1,033</p>
								<span>Today Order</span>
							</div>
							<div class="ms-stats-grid">
								<i class="fa fa-heart"></i>
								<p class="ms-text-dark">3,039</p>
								<span>Favourite</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
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
	<script src="../../back-assets/js/slick.min.js"></script>
	<script src="../../back-assets/js/moment.js"></script>
	<script src="../../back-assets/js/jquery.webticker.min.js"></script>
	<script src="../../back-assets/js/Chart.bundle.min.js"></script>
	<script src="../../back-assets/js/Chart.Financial.js"></script>
	<!-- Page Specific Scripts Finish -->
	<!-- Costic core JavaScript -->
	<script src="../../back-assets/js/framework.js"></script>
	<!-- Settings -->
	<script src="../../back-assets/js/settings.js"></script>
	<!-- ----- ----- ----- Script End ----- ----- ----- -->
</body>

</html>