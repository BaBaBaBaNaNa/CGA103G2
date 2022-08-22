<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

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
			<div class="row"></div>
			<div class="ms-content-wrapper">
				<div class="row">
					<!-- Recent Support Tickets -->
					<div class="col-xl-12 col-md-12">
						<div class="ms-panel ms-panel-fh">
							<div class="ms-panel-body p-0">
								<ul class="ms-list ms-feed ms-twitter-feed ms-recent-support-tickets">
									<li class="ms-list-item"><a href="#" class="media clearfix"><img src="../../back-assets/img/costic/customer-1.jpg" class="ms-img-round ms-img-small" alt="This is another feature">
											<div class="media-body">
												<div class="customer-meta">
													<div class="new">
														<h5 class="ms-feed-user mb-0">John Doe</h5>
														<h6 class="ml-4 mb-0 text-red">Grilled Sandwich</h6>
													</div>
													<ul class="ms-star-rating rating-fill rating-circle ratings-new">
														<li class="ms-rating-item"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
													</ul>
												</div>
												<span class="my-2 d-block"><i class="material-icons">date_range</i>February 24, 2019</span>
												<p class="d-block">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla luctus lectus a facilisis bibendum. Duis quis convallis sapien ...</p>
												<div class="d-flex justify-content-between align-items-end">
													<div class="ms-feed-controls">
														<span><i class="material-icons">chat</i>16</span><span><i class="material-icons">attachment</i>3</span>
													</div>
												</div>
											</div> </a></li>
									<li class="ms-list-item"><a href="#" class="media clearfix"><img src="../../back-assets/img/costic/customer-2.jpg" class="ms-img-round ms-img-small" alt="This is another feature">
											<div class="media-body">
												<div class="customer-meta">
													<div class="new">
														<h5 class="ms-feed-user mb-0">Ricky Martin</h5>
														<h6 class="ml-4 mb-0 text-red">Fried Egg Sandwich</h6>
													</div>
													<ul class="ms-star-rating rating-fill rating-circle ratings-new">
														<li class="ms-rating-item"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
													</ul>
												</div>
												<span class="my-2 d-block"><i class="material-icons">date_range</i>February 24, 2019</span>
												<p class="d-block">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla luctus lectus a facilisis bibendum. Duis quis convallis sapien ...</p>
												<div class="d-flex justify-content-between align-items-end">
													<div class="ms-feed-controls">
														<span><i class="material-icons">chat</i>16</span><span><i class="material-icons">attachment</i>3</span>
													</div>
												</div>
											</div> </a></li>
									<li class="ms-list-item"><a href="#" class="media clearfix"><img src="../../back-assets/img/costic/customer-3.jpg" class="ms-img-round ms-img-small" alt="This is another feature">
											<div class="media-body">
												<div class="customer-meta">
													<div class="new">
														<h5 class="ms-feed-user mb-0">Joe semual</h5>
														<h6 class="ml-4 mb-0 text-red">Peri Peri Fries</h6>
													</div>
													<ul class="ms-star-rating rating-fill rating-circle ratings-new">
														<li class="ms-rating-item"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
													</ul>
												</div>
												<span class="my-2 d-block"><i class="material-icons">date_range</i>February 24, 2019</span>
												<p class="d-block">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla luctus lectus a facilisis bibendum. Duis quis convallis sapien ...</p>
												<div class="d-flex justify-content-between align-items-end">
													<div class="ms-feed-controls">
														<span><i class="material-icons">chat</i>16</span><span><i class="material-icons">attachment</i>3</span>
													</div>
												</div>
											</div> </a></li>
									<li class="ms-list-item"><a href="#" class="media clearfix"><img src="../../back-assets/img/costic/customer-4.jpg" class="ms-img-round ms-img-small" alt="This is another feature">
											<div class="media-body">
												<div class="customer-meta">
													<div class="new">
														<h5 class="ms-feed-user mb-0">Ricky Martin</h5>
														<h6 class="ml-4 mb-0 text-red">Spicy Grilled Burger</h6>
													</div>
													<ul class="ms-star-rating rating-fill rating-circle ratings-new">
														<li class="ms-rating-item"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
													</ul>
												</div>
												<span class="my-2 d-block"><i class="material-icons">date_range</i>February 24, 2019</span>
												<p class="d-block">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla luctus lectus a facilisis bibendum. Duis quis convallis sapien ...</p>
												<div class="d-flex justify-content-between align-items-end">
													<div class="ms-feed-controls">
														<span><i class="material-icons">chat</i>16</span><span><i class="material-icons">attachment</i>3</span>
													</div>
												</div>
											</div> </a></li>
									<li class="ms-list-item"><a href="#" class="media clearfix"><img src="../../back-assets/img/costic/customer-5.jpg" class="ms-img-round ms-img-small" alt="This is another feature">
											<div class="media-body">
												<div class="customer-meta">
													<div class="new">
														<h5 class="ms-feed-user mb-0">Lim Shojin</h5>
														<h6 class="ml-4 mb-0 text-red">Grilled Sandwich</h6>
													</div>
													<ul class="ms-star-rating rating-fill rating-circle ratings-new">
														<li class="ms-rating-item"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
														<li class="ms-rating-item rated"><i class="material-icons">star</i></li>
													</ul>
												</div>
												<span class="my-2 d-block"><i class="material-icons">date_range</i>February 24, 2019</span>
												<p class="d-block">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla luctus lectus a facilisis bibendum. Duis quis convallis sapien ...</p>
												<div class="d-flex justify-content-between align-items-end">
													<div class="ms-feed-controls">
														<span><i class="material-icons">chat</i>16</span><span><i class="material-icons">attachment</i>3</span>
													</div>
												</div>
											</div> </a></li>
								</ul>
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