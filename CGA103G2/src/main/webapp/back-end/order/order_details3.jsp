<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zh-tw">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Costic Dashboard</title>
<!-- Iconic Fonts -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="../../back-assets/vendors/iconic-fonts/font-awesome/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/flat-icons/flaticon.css">
<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins.css">
<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins-colors.css">
<!-- Bootstrap core CSS -->
<link href="../../back-assets/css/bootstrap.min.css" rel="stylesheet">
<!-- Page Specific Css (Datatables.css) -->
<link href="../../back-assets/css/datatables.min.css" rel="stylesheet">
<!-- jQuery UI -->
<link href="../../back-assets/css/jquery-ui.min.css" rel="stylesheet">
<!-- Costic Core styles -->
<link href="../../back-assets/css/style.css" rel="stylesheet">
<!-- Favicon -->
<link rel="icon" type="image/png" sizes="32x32" href="../../favicon.ico">
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
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb pl-0">
				<li class="breadcrumb-item"><a href="#"><i class="material-icons">home</i>首頁</a></li>
				<li class="breadcrumb-item"><a href="#">訂單管理</a></li>
				<li class="breadcrumb-item active" aria-current="page">查看訂單</li>
			</ol>
		</nav>
		<!-- ----- ----- -----   中間目錄條 end ----- ----- ----- -->
		<!-- ----- ----- -----   中間下面內容 start ----- ----- ----- -->
		<div class="ms-content-wrapper">
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-12">
						<div class="ms-panel ms-panel-fh">
							<div class="ms-panel-header">
								<h6>Favourite Orders</h6>
							</div>
							<div class="ms-panel-body order-circle">
								<div class="row">
									<div class="col-xl-3 col-lg-3 col-md-6">
										<h6 class="text-center">Pizza</h6>
										<div class="progress-rounded progress-round-tiny">
											<div class="progress-value">12%</div>
											<svg>
                                                <circle class="progress-cicle bg-success" cx="65" cy="65" r="57" stroke-width="4" fill="none" aria-valuenow="12" aria-orientation="vertical" aria-valuemin="0" aria-valuemax="100" role="slider"></circle>
                                            </svg>
										</div>
									</div>
									<div class="col-xl-3 col-lg-3 col-md-6">
										<h6 class="text-center">Mexican Noodels</h6>
										<div class="progress-rounded progress-round-tiny">
											<div class="progress-value">38.8%</div>
											<svg>
                                                <circle class="progress-cicle bg-primary" cx="65" cy="65" r="57" stroke-width="4" fill="none" aria-valuenow="38.8" aria-orientation="vertical" aria-valuemin="0" aria-valuemax="100" role="slider"></circle>
                                            </svg>
										</div>
									</div>
									<div class="col-xl-3 col-lg-3 col-md-6">
										<h6 class="text-center">Spicy Salad</h6>
										<div class="progress-rounded progress-round-tiny">
											<div class="progress-value">78.8%</div>
											<svg>
                                                <circle class="progress-cicle bg-secondary" cx="65" cy="65" r="57" stroke-width="4" fill="none" aria-valuenow="78.8" aria-orientation="vertical" aria-valuemin="0" aria-valuemax="100" role="slider"></circle>
                                            </svg>
										</div>
									</div>
									<div class="col-xl-3 col-lg-3 col-md-6">
										<h6 class="text-center">French Fries</h6>
										<div class="progress-rounded progress-round-tiny">
											<div class="progress-value">100%</div>
											<svg>
                                                <circle class="progress-cicle bg-dark" cx="65" cy="65" r="57" stroke-width="4" fill="none" aria-valuenow="100" aria-orientation="vertical" aria-valuemin="0" aria-valuemax="100" role="slider"></circle>
                                            </svg>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-12">
						<div class="ms-panel">
							<div class="ms-panel-header">
								<h6>Order List</h6>
							</div>
							<div class="ms-panel-body">
								<div class="table-responsive">
									<table class="table table-hover thead-primary">
										<thead>
											<tr>
												<th scope="col">Order ID</th>
												<th scope="col">Order Name</th>
												<th scope="col">Customer Name</th>
												<th scope="col">Location</th>
												<th scope="col">Order Status</th>
												<th scope="col">Delivered Time</th>
												<th scope="col">Price</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th scope="row">1</th>
												<td>French Fries</td>
												<td>Jhon Leo</td>
												<td>New Town</td>
												<td><span class="badge badge-primary">Pending</span></td>
												<td>10:05</td>
												<td>$10</td>
											</tr>
											<tr>
												<th scope="row">2</th>
												<td>Mango Pie</td>
												<td>Kristien</td>
												<td>Old Town</td>
												<td><span class="badge badge-dark">Cancelled</span></td>
												<td>14:05</td>
												<td>$9</td>
											</tr>
											<tr>
												<th scope="row">3</th>
												<td>FrieD Egg Sandwich</td>
												<td>Jack Suit</td>
												<td>Oxford Street</td>
												<td><span class="badge badge-success">Delivered</span></td>
												<td>12:05</td>
												<td>$19</td>
											</tr>
											<tr>
												<th scope="row">4</th>
												<td>Lemon Yogurt Parfait</td>
												<td>Alesdro Guitto</td>
												<td>Church hill</td>
												<td><span class="badge badge-success">Delivered</span></td>
												<td>12:05</td>
												<td>$18</td>
											</tr>
											<tr>
												<th scope="row">5</th>
												<td>Spicy Grill Sandwich</td>
												<td>Jacob Sahwny</td>
												<td>palace Road</td>
												<td><span class="badge badge-success">Delivered</span></td>
												<td>12:05</td>
												<td>$21</td>
											</tr>
											<tr>
												<th scope="row">6</th>
												<td>Chicken Sandwich</td>
												<td>Peter Gill</td>
												<td>Street 21</td>
												<td><span class="badge badge-primary">Pending</span></td>
												<td>12:05</td>
												<td>$15</td>
											</tr>
											<tr>
												<th scope="row">7</th>
												<td>Sandwich</td>
												<td>Jack Suit</td>
												<td>40, Street</td>
												<td><span class="badge badge-success">Delivered</span></td>
												<td>11:05</td>
												<td>$19</td>
											</tr>
											<tr>
												<th scope="row">8</th>
												<td>Spaghetti</td>
												<td>Jack Suit</td>
												<td>Oxford Street</td>
												<td><span class="badge badge-success">Delivered</span></td>
												<td>12:05</td>
												<td>$19</td>
											</tr>
											<tr>
												<th scope="row">9</th>
												<td>Fried Rice</td>
												<td>Jack Suit</td>
												<td>Hilltown Street</td>
												<td><span class="badge badge-success">Delivered</span></td>
												<td>12:05</td>
												<td>$19</td>
											</tr>
											<tr>
												<th scope="row">10</th>
												<td>Noodels</td>
												<td>Jack Suit</td>
												<td>Oxford Street</td>
												<td><span class="badge badge-success">Delivered</span></td>
												<td>12:05</td>
												<td>$19</td>
											</tr>
										</tbody>
									</table>
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
	<!-- SCRIPTS -->
	<!-- Global Required Scripts Start -->
	<script src="../../back-assets/js/jquery-3.3.1.min.js"></script>
	<script src="../../back-assets/js/popper.min.js"></script>
	<script src="../../back-assets/js/bootstrap.min.js"></script>
	<script src="../../back-assets/js/perfect-scrollbar.js"></script>
	<script src="../../back-assets/js/jquery-ui.min.js"></script>
	<!-- Global Required Scripts End -->
	<!-- Page Specific Scripts Start -->
	<script src="../../back-assets/js/Chart.bundle.min.js"></script>
	<!-- Page Specific Scripts End -->
	<!-- Page Specific Scripts Finish -->
	<script src="../../back-assets/js/datatables.min.js"></script>
	<script src="../../back-assets/js/data-tables.js"></script>
	<!-- Costic core JavaScript -->
	<script src="../../back-assets/js/framework.js"></script>
	<!-- Settings -->
	<script src="../../back-assets/js/settings.js"></script>
</body>

</html>