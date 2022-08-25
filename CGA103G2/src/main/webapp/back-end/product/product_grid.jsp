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
					<div class="row">
						<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
							<div class="ms-card">
								<div class="ms-card-img">
									<img src="../../back-assets/img/costic/food-1.jpg" alt="card_img">
								</div>
								<div class="ms-card-body">
									<div class="new">
										<h6 class="mb-0">Veggies</h6>
										<h6 class="ms-text-primary mb-0">$45.50</h6>
									</div>
									<div class="new meta">
										<p>Qty:1467</p>
										<span class="badge badge-success">In Stock</span>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, dolor sit amet, consectetur adipiscing</p>
									<div class="new mb-0">
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-primary">Remove</button>
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-secondary">Edit</button>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
							<div class="ms-card">
								<div class="ms-card-img">
									<img src="../../back-assets/img/costic/food-2.jpg" alt="card_img">
								</div>
								<div class="ms-card-body">
									<div class="new">
										<h6 class="mb-0">Garlic Bread</h6>
										<h6 class="ms-text-primary mb-0">$45.50</h6>
									</div>
									<div class="new meta">
										<p>Qty:6224</p>
										<span class="badge badge-primary">Out of Stock</span>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, dolor sit amet, consectetur adipiscing</p>
									<div class="new mb-0">
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-primary">Remove</button>
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-secondary">Edit</button>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
							<div class="ms-card">
								<div class="ms-card-img">
									<img src="../../back-assets/img/costic/food-3.jpg" alt="card_img">
								</div>
								<div class="ms-card-body">
									<div class="new">
										<h6 class="mb-0">Veg Sandwich</h6>
										<h6 class="ms-text-primary mb-0">$45.50</h6>
									</div>
									<div class="new meta">
										<p>Qty:1467</p>
										<span class="badge badge-success">In Stock</span>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, dolor sit amet, consectetur adipiscing</p>
									<div class="new mb-0">
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-primary">Remove</button>
										<button type="button" class="btn  grid-btn mt-0 btn-sm btn-secondary">Edit</button>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
							<div class="ms-card">
								<div class="ms-card-img">
									<img src="../../back-assets/img/costic/food-4.jpg" alt="card_img">
								</div>
								<div class="ms-card-body">
									<div class="new">
										<h6 class="mb-0">Roast Sandwich</h6>
										<h6 class="ms-text-primary mb-0">$45.50</h6>
									</div>
									<div class="new meta">
										<p>Qty:6224</p>
										<span class="badge badge-primary">Out of Stock</span>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, dolor sit amet, consectetur adipiscing</p>
									<div class="new mb-0">
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-primary">Remove</button>
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-secondary">Edit</button>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
							<div class="ms-card">
								<div class="ms-card-img">
									<img src="../../back-assets/img/costic/food-5.jpg" alt="card_img">
								</div>
								<div class="ms-card-body">
									<div class="new">
										<h6 class="mb-0">Burger</h6>
										<h6 class="ms-text-primary mb-0">$45.50</h6>
									</div>
									<div class="new meta">
										<p>Qty:1467</p>
										<span class="badge badge-success">In Stock</span>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, dolor sit amet, consectetur adipiscing</p>
									<div class="new mb-0">
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-primary">Remove</button>
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-secondary">Edit</button>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
							<div class="ms-card">
								<div class="ms-card-img">
									<img src="../../back-assets/img/costic/food-6.jpg" alt="card_img">
								</div>
								<div class="ms-card-body">
									<div class="new">
										<h6 class="mb-0">Veggies</h6>
										<h6 class="ms-text-primary mb-0">$45.50</h6>
									</div>
									<div class="new meta">
										<p>Qty:1467</p>
										<span class="badge badge-success">In Stock</span>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, dolor sit amet, consectetur adipiscing</p>
									<div class="new mb-0">
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-primary">Remove</button>
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-secondary">Edit</button>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
							<div class="ms-card">
								<div class="ms-card-img">
									<img src="../../back-assets/img/costic/food-7.jpg" alt="card_img">
								</div>
								<div class="ms-card-body">
									<div class="new">
										<h6 class="mb-0">Pepperoni Pizza</h6>
										<h6 class="ms-text-primary mb-0">$45.50</h6>
									</div>
									<div class="new meta">
										<p>Qty:6224</p>
										<span class="badge badge-primary">Out of Stock</span>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, dolor sit amet, consectetur adipiscing</p>
									<div class="new mb-0">
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-primary">Remove</button>
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-secondary">Edit</button>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-lg-4 col-md-6 col-sm-6">
							<div class="ms-card">
								<div class="ms-card-img">
									<img src="../../back-assets/img/costic/food-8.jpg" alt="card_img">
								</div>
								<div class="ms-card-body">
									<div class="new">
										<h6 class="mb-0">Egg McMuffin</h6>
										<h6 class="ms-text-primary mb-0">$45.50</h6>
									</div>
									<div class="new meta">
										<p>Qty:1467</p>
										<span class="badge badge-success">In Stock</span>
									</div>
									<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, dolor sit amet, consectetur adipiscing</p>
									<div class="new mb-0">
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-primary">Remove</button>
										<button type="button" class="btn grid-btn mt-0 btn-sm btn-secondary">Edit</button>
									</div>
								</div>
							</div>
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