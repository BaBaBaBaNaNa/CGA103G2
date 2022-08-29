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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="../../back-assets/vendors/iconic-fonts/font-awesome/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/flat-icons/flaticon.css">
<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins.css">
<link rel="stylesheet" href="../../back-assets/vendors/iconic-fonts/cryptocoins/cryptocoins-colors.css">
<!-- Bootstrap core CSS -->
<link href="../../back-assets/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery UI -->
<link href="../../back-assets/css/jquery-ui.min.css" rel="stylesheet">
<!-- Page Specific CSS (Slick Slider.css) -->
<link href="../../back-assets/css/slick.css" rel="stylesheet">
<!-- Costic styles -->
<link href="../../back-assets/css/style.css" rel="stylesheet">
<!-- Favicon -->
<link rel="icon" type="image/png" sizes="32x32" href="../../favicon.ico">
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
					<div class="col-12">
						<div class="ms-panel">
							<div class="ms-panel-header">
								<h6>Invoice List</h6>
							</div>
							<div class="ms-panel-body">
								<div class="table-responsive">
									<table class="table table-hover thead-primary">
										<thead>
											<tr>
												<th scope="col">Invoice ID</th>
												<th scope="col">Order Name</th>
												<th scope="col">Order Id</th>
												<th scope="col">Invoice Date</th>
												<th scope="col">Quantity</th>
												<th scope="col">Total Bill</th>
												<th scope="col">Send Invoice</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th scope="row">15451</th>
												<td>French Fries</td>
												<td>001</td>
												<td>19/02/2019</td>
												<td>10</td>
												<td>$10</td>
												<td><a href='#'><i class='fas fa-paper-plane text-success'></i></a><a href='a'><i class='far fa-trash-alt ms-text-danger'></i></a></td>
											</tr>
											<tr>
												<th scope="row">15452</th>
												<td>Mango Pie</td>
												<td>004</td>
												<td>9/02/2019</td>
												<td>14</td>
												<td>$9</td>
												<td><a href='#'><i class='fas fa-paper-plane text-success'></i></a><a href='a'><i class='far fa-trash-alt ms-text-danger'></i></a></td>
											</tr>
											<tr>
												<th scope="row">45263</th>
												<td>FrieD Egg Sandwich</td>
												<td>003</td>
												<td>18/02/2019</td>
												<td>12</td>
												<td>$19</td>
												<td><a href='#'><i class='fas fa-paper-plane text-success'></i></a><a href='a'><i class='far fa-trash-alt ms-text-danger'></i></a></td>
											</tr>
											<tr>
												<th scope="row">45865</th>
												<td>Lemon Yogurt Parfait</td>
												<td>005</td>
												<td>16/02/2019</td>
												<td>05</td>
												<td>$18</td>
												<td><a href='#'><i class='fas fa-paper-plane text-success'></i></a><a href='a'><i class='far fa-trash-alt ms-text-danger'></i></a></td>
											</tr>
											<tr>
												<th scope="row">56652</th>
												<td>Spicy Grill Sandwich</td>
												<td>014</td>
												<td>17/02/2019</td>
												<td>15</td>
												<td>$21</td>
												<td><a href='#'><i class='fas fa-paper-plane text-success'></i></a><a href='a'><i class='far fa-trash-alt ms-text-danger'></i></a></td>
											</tr>
											<tr>
												<th scope="row">65845</th>
												<td>Chicken Sandwich</td>
												<td>017</td>
												<td>14/02/2019</td>
												<td>120</td>
												<td>$15</td>
												<td><a href='#'><i class='fas fa-paper-plane text-success'></i></a><a href='a'><i class='far fa-trash-alt ms-text-danger'></i></a></td>
											</tr>
											<tr>
												<th scope="row">65425</th>
												<td>Veg Sandwich</td>
												<td>045</td>
												<td>13/02/2019</td>
												<td>2</td>
												<td>$15</td>
												<td><a href='#'><i class='fas fa-paper-plane text-success'></i></a><a href='a'><i class='far fa-trash-alt ms-text-danger'></i></a></td>
											</tr>
											<tr>
												<th scope="row">54556</th>
												<td>Cake</td>
												<td>033</td>
												<td>11/02/2019</td>
												<td>15</td>
												<td>$15</td>
												<td><a href='#'><i class='fas fa-paper-plane text-success'></i></a><a href='a'><i class='far fa-trash-alt ms-text-danger'></i></a></td>
											</tr>
											<tr>
												<th scope="row">45556</th>
												<td>Chicken Fried</td>
												<td>077</td>
												<td>12/02/2019</td>
												<td>06</td>
												<td>$15</td>
												<td><a href='#'><i class='fas fa-paper-plane text-success'></i></a><a href='a'><i class='far fa-trash-alt ms-text-danger'></i></a></td>
											</tr>
											<tr>
												<th scope="row">55856</th>
												<td>Nachos</td>
												<td>868</td>
												<td>10/02/2019</td>
												<td>08</td>
												<td>$15</td>
												<td><a href='#'><i class='fas fa-paper-plane text-success'></i></a><a href='a'><i class='far fa-trash-alt ms-text-danger'></i></a></td>
											</tr>
											<tr>
												<th scope="row">36456</th>
												<td>Spaghetti</td>
												<td>777</td>
												<td>20/02/2019</td>
												<td>09</td>
												<td>$15</td>
												<td><a href='#'><i class='fas fa-paper-plane text-success'></i></a><a href='a'><i class='far fa-trash-alt ms-text-danger'></i></a></td>
											</tr>
											<tr>
												<th scope="row">78456</th>
												<td>Pastries</td>
												<td>555</td>
												<td>21/02/2019</td>
												<td>14</td>
												<td>$15</td>
												<td><a href='#'><i class='fas fa-paper-plane text-success'></i></a><a href='a'><i class='far fa-trash-alt ms-text-danger'></i></a></td>
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